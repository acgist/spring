package com.acgist.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acgist.service.IUserService;

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping(value = "/user/name", method = RequestMethod.GET)
	public String userName(String name) {
		name = StringUtils.isEmpty(name) ? "测试" : name;
		return userService.userName(name);
	}
	
}
