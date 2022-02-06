package com.example.Parser.parser;

import com.example.Parser.model.Order;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Collections;
import java.util.List;

public abstract class FileReaderParser implements Parser {

    @Override
    public List<Order> parseFile(String inputFileName) {
        List<Order> orders = Collections.emptyList();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            orders = doParsing(inputFileName, reader);
        } catch (Exception e) {
            // ignore according requirement
        }
        return orders;
    }

    protected abstract List<Order> doParsing(String inputFileName, BufferedReader reader) throws Exception;
}
