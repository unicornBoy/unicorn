package com.hsbc.unicorn.controller;

import com.hsbc.unicorn.entity.CloudFiles;
import com.hsbc.unicorn.repository.CloudFilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:LB
 * @date:2018/8/2 17:17
 * @description:
 */
@RestController
@RequestMapping("/cloudfiles")
public class UpdateFileContrller {

    @Autowired
    private CloudFilesRepository cloudFilesRepository;

    @RequestMapping("update")
    public String update(HttpServletRequest request) {
        Long id = Long.parseLong(request.getParameter("id"));
        String fileName = request.getParameter("filename");
        CloudFiles cloudFiles = cloudFilesRepository.findOne(id);
        if (cloudFiles != null) {
            cloudFilesRepository.update(id, fileName);
            return " update successful";
        } else {
            return "this id is not find";
        }
    }

}
