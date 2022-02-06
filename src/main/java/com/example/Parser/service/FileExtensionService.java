package com.example.Parser.service;

import org.apache.commons.io.FilenameUtils;
import org.springframework.stereotype.Service;

@Service
public class FileExtensionService {

    public String getFileExtensionsFromFiles(String fileName) {
        return FilenameUtils.getExtension(fileName);
    }
}
