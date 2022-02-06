package com.example.Parser.service;

import com.example.Parser.model.Order;
import com.example.Parser.parser.Parser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ParserProvider {

    private final List<Parser> parsers;
    private Map<String, Parser> parserMapping;

    @PostConstruct
    private void init() {
        parserMapping = new HashMap<>();
        for (Parser parser : parsers) {
            parserMapping.put(parser.getType(), parser);
        }
    }

    public Parser findRequiredParser(String type) {

        Parser parser = parserMapping.get(type);
        if (parser == null) {
            throw new RuntimeException("Parser not found.");
        }
        return parser;
    }
}
