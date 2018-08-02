package com.hsbc.unicorn.service;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Calendar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.hsbc.unicorn.exception.StorageException;
import com.hsbc.unicorn.util.StorageProperties;

/**
 * @author:lmm
 * @date:2018/8/2
 * @description:
 */
@Service
public class FileSystemStorageService implements StorageService {

    private final Path rootLocation;

    @Autowired
    public FileSystemStorageService(StorageProperties properties) {
        this.rootLocation = Paths.get(properties.getLocation());
    }

    /**
     * 保存文件在本地磁盘
     *
     * @param file
     * @return
     */
    @Override
    public String store(MultipartFile file) {
        String fileRealName = StringUtils.cleanPath(file.getOriginalFilename());
        String extension = StringUtils.getFilenameExtension(file.getOriginalFilename());
        String fileName = Calendar.getInstance().getTimeInMillis() + "." + extension;
        try {
            if (file.isEmpty()) {
                throw new StorageException("is empty file " + fileRealName);
            }
            if (fileRealName.contains("..")) {
                // This is a security check
                throw new StorageException(
                        "Cannot store file with relative path outside current directory "
                                + fileRealName);
            }
            try (InputStream inputStream = file.getInputStream()) {
                Files.copy(inputStream, this.rootLocation.resolve(fileName),
                        StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (IOException e) {
            throw new StorageException("Failed to store file " + fileRealName, e);
        }
        return fileName;
    }



    @Override
    public Path load(String filename) {
        return rootLocation.resolve(filename);
    }



    @Override
    public void deleteAll() {
        FileSystemUtils.deleteRecursively(rootLocation.toFile());
    }

    @Override
    public void deleteOne(String fileName) {
        try {
            Files.delete(rootLocation.resolve(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new StorageException("Could not initialize storage", e);
        }
    }
}
