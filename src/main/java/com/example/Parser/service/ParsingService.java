package com.example.Parser.service;

import com.example.Parser.model.Order;
import com.example.Parser.parser.Parser;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class ParsingService {

    private final InputArgsProcessingService inputArgsProcessingService;
    private final FileExtensionService fileExtensionService;
    private final ParserProvider parserProvider;
    private final ConsolePrintService consolePrintService;

    public void parseData(ApplicationArguments args) {
        List<String> fileNamesFromInputArgs = inputArgsProcessingService.getFileNamesFromInputArgs(args);

        List<Order> result = fileNamesFromInputArgs.parallelStream()
                .map(this::process)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

        consolePrintService.print(result);
    }

    private List<Order> process(String fileName) {
        String type = fileExtensionService.getFileExtensionsFromFiles(fileName);
        Parser parser = parserProvider.findRequiredParser(type);
        return parser.parseFile(fileName);
    }
}
