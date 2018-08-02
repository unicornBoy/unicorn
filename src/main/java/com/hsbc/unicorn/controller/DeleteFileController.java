package com.hsbc.unicorn.controller;

import com.hsbc.unicorn.entity.CloudFiles;
import com.hsbc.unicorn.repository.CloudFilesRepository;
import com.hsbc.unicorn.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:CHM
 * @date:2018/8/2 12:55
 * @description:
 */
@RestController
@RequestMapping("/cloudfiles")
public class DeleteFileController {
    @Autowired
    private CloudFilesRepository cloudFilesRepository;
    @Autowired
    private StorageService storageService;
    @GetMapping("/delete")
    public String deleteFileMessage(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        CloudFiles cloudFiles = cloudFilesRepository.findOne(id);
        if (cloudFiles != null) {
            //1.先删除磁盘文件
            storageService.deleteOne(cloudFiles.getFileName());
            //2.再删除数据表该文件信息
            cloudFilesRepository.delete(cloudFiles);
            return "successful";
        } else {
            return "this id is not find";
        }
    }
}
