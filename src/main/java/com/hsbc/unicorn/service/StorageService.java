package com.hsbc.unicorn.service;

import java.nio.file.Path;
import org.springframework.web.multipart.MultipartFile;

public interface StorageService {

    void init();

    String store(MultipartFile file);

    Path load(String filename);

    void deleteAll();

    void deleteOne(String fileName);
}
