package com.example.Parser.parser;

import com.example.Parser.model.Order;

import java.util.List;

public interface Parser {

    String getType();

    List<Order> parseFile(String inputFileName);
}
