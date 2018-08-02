package com.hsbc.unicorn.controller;

import com.hsbc.unicorn.entity.CloudFiles;
import com.hsbc.unicorn.repository.CloudFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/add")
    public void save(@RequestBody CloudFiles cloudFiles) {
        cloudFilesRepository.save(cloudFiles);
    }
}
