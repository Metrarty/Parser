package com.example.Parser;

import com.example.Parser.service.ParsingService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class ParserApplication implements ApplicationRunner {

    private final ParsingService parsingService;

    public static void main(String[] args) {
        SpringApplication.run(ParserApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        parsingService.parseData(args);
    }
}
