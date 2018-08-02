package com.hsbc.unicorn.controller;

import com.hsbc.unicorn.entity.CloudFiles;
import com.hsbc.unicorn.exception.StorageException;
import com.hsbc.unicorn.repository.CloudFilesRepository;
import com.hsbc.unicorn.service.FileSystemStorageService;
import com.hsbc.unicorn.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

/**
 * @author:lmm
 * @date:2018/8/2
 * @description:
 */
@RestController()
@RequestMapping("/cloudfiles")
public class AddFileController {
    @Autowired
    private CloudFilesRepository cloudFilesRepository;
    @Autowired
    private StorageService storageService;

    /**
     * 文件上传接口
     * @param file
     * @throws IOException
     */
    @PostMapping("/add")
    public String save(@RequestParam("file") MultipartFile file) throws IOException {
        if (file.isEmpty() || file == null) {
            throw new StorageException("is empty file or file is null ");
        }
        String realName = file.getOriginalFilename();
        //存储文件到磁盘目录
        String fileName = storageService.store(file);
        CloudFiles cloudFiles = new CloudFiles(fileName, realName, new Date(), "");
        cloudFilesRepository.save(cloudFiles);
        return fileName+"upload seccussful";
    }
}

