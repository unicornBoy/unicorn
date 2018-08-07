package com.hsbc.unicorn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * description:通过在数据库中的配置，实现对不同的链接进行不同的权限的操控的功能
 */
@RestController
@ResponseBody
public class UserRepositoryController {
	@RequestMapping("/")
	public String home() {
		return "Anyone can access it";
	}
	
	@GetMapping("/hello")
	public String hello() {
		return "must be login can access";
	}
	
	@RequestMapping("/admin")
	public String admin() {
		return "Only the admin user can access it";
	}
}
