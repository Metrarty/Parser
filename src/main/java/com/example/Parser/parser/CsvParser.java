package com.example.Parser.parser;

import com.example.Parser.model.Order;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class CsvParser extends FileReaderParser {

    @Override
    public String getType() {
        return "csv";
    }

    @Override
    protected List<Order> doParsing(String inputFileName, BufferedReader reader) throws Exception {
        ArrayList<Order> orders = new ArrayList<>();
        CsvToBean<Order> beans = new CsvToBeanBuilder<Order>(reader)
                .withType(Order.class)
                .withThrowExceptions(false)
                .withIgnoreEmptyLine(true)
                .build();

        List<Order> parsedOrders = beans.parse();
        List<CsvException> capturedExceptions = beans.getCapturedExceptions();
        Map<Integer, CsvException> exceptionsByLine = new HashMap<>();
        for (CsvException ex : capturedExceptions) {
            exceptionsByLine.put(Long.valueOf(ex.getLineNumber()).intValue(), ex);
        }

        int resultSize = parsedOrders.size() + capturedExceptions.size();
        int parsedOrderIndex = 0;
        for (int i = 1; i <= resultSize; i++) {
            Order order;

            if (exceptionsByLine.get(i) == null) {
                order = parsedOrders.get(parsedOrderIndex);
                order.setLine(i);
                order.setResult("OK");
                order.setFilename(FilenameUtils.getName(inputFileName));
                parsedOrderIndex++;
            } else {
                order = new Order();
                order.setFilename(FilenameUtils.getName(inputFileName));
                order.setLine(i);
                order.setResult("Error");
            }
            orders.add(order);
        }
        return orders;
    }
}
