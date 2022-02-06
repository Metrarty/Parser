package com.example.Parser.parser;

import com.example.Parser.model.Order;
import com.google.gson.Gson;
import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class JsonParser extends FileReaderParser {

    private static final Gson GSON = new Gson();

    @Override
    public String getType() {
        return "json";
    }

    @Override
    protected List<Order> doParsing(String inputFileName, BufferedReader reader) throws Exception {
        Order order;
        ArrayList<Order> orders = new ArrayList<>();
        String line;
        int lineCounter = 1;
        while ((line = reader.readLine()) != null) {
            try {
                order = GSON.fromJson(line, Order.class);
                order.setFilename(new File(inputFileName).getName());
                order.setLine(lineCounter);
                order.setResult("OK");
                orders.add(order);
            } catch (Exception e) {
                Order failedOrder = new Order();
                failedOrder.setFilename(FilenameUtils.getName(inputFileName));
                failedOrder.setLine(lineCounter);
                failedOrder.setResult("Error");
                orders.add(failedOrder);
            }
            lineCounter++;
        }

        return orders;
    }
}
