package com.hsbc.unicorn.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hsbc.unicorn.entity.CloudFiles;
import com.hsbc.unicorn.exception.StorageFileNotFoundException;
import com.hsbc.unicorn.repository.CloudFilesRepository;
import com.hsbc.unicorn.service.StorageService;

/**
 * @author:CHM
 * @date:2018/8/2 13:07
 * @description:
 */
@RestController
@RequestMapping(value = "cloudfiles")
public class CloudFilesController {
	
	@Autowired
	private CloudFilesRepository cloudFilesRepository;
	
	/**
	 * @param
	 * @return
	 * @throws IOException
	 */
	@GetMapping("/list")
	public Iterable<CloudFiles> listUploadedFiles() throws IOException {
		//查询出数据库文件对象
		Iterable<CloudFiles> cloudFilesIt = cloudFilesRepository.findAll();
		//然后根据文件名称取文件
		return cloudFilesIt;
	}

	@ExceptionHandler(StorageFileNotFoundException.class)
	public ResponseEntity<?> handleStorageFileNotFound(StorageFileNotFoundException exc) {
		return ResponseEntity.notFound().build();
	}
}
