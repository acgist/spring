package com.acgist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acgist.service.IUserService;
import com.acgist.service.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService userService;
	
	@RequestMapping("/index")
	public User index(String name) {
		return userService.findOne(name == null ? "测试" : name);
	}
	
}
