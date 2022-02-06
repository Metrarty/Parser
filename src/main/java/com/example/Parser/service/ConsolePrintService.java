package com.example.Parser.service;

import com.example.Parser.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsolePrintService {

    public void print(List<Order> ordersList) {

        for (Order order : ordersList) {
            String result = "{“id”:" +
                    order.getOrderId() +
                    ",“orderId”:" +
                    order.getOrderId() +
                    ",”amount”:" +
                    order.getAmount() +
                    ",”currency”:”" +
                    order.getCurrency() +
                    "”,”comment”:”" +
                    order.getComment() +
                    "”,”filename”:”" +
                    order.getFilename() +
                    "”,”line”:" +
                    order.getLine() +
                    ",”result”:”" +
                    order.getResult() +
                    "”}";
            System.out.println(result);
        }
    }
}
