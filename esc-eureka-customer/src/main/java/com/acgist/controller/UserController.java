package com.acgist.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acgist.service.IUserService;
import com.acgist.service.UserServiceFeign;

@RestController
public class UserController {
	
	@Autowired
	private IUserService userService;
	@Autowired
	private UserServiceFeign userServiceFeign;
	
	@RequestMapping(value = "/user/name", method = RequestMethod.GET)
	public String userName(String name) {
		name = StringUtils.isEmpty(name) ? "测试" : name;
		return userService.userName(name);
	}
	
	@RequestMapping(value = "/user/name/retry", method = RequestMethod.GET)
	public String userNameRetry(String name) {
		name = StringUtils.isEmpty(name) ? "测试" : name;
		return userServiceFeign.userNameRetry(name);
	}
	
}
