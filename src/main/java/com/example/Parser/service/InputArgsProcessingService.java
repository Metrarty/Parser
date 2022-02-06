package com.example.Parser.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class InputArgsProcessingService {

    public List<String> getFileNamesFromInputArgs(ApplicationArguments args) {
        String[] sourceArgs = args.getSourceArgs();
        return Arrays.stream(sourceArgs).collect(Collectors.toList());
    }
}
