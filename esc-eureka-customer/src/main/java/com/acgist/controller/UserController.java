package com.acgist.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acgist.service.IUserService;
import com.acgist.service.UserServiceFeign;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

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
	
	@ApiOperation(value = "查询用户重试", notes = "查询用户重试")
	@ApiImplicitParam(name = "name", value = "当值为retry时，将会休眠10秒展示重试效果", type = "string")
	@RequestMapping(value = "/user/name/retry", method = RequestMethod.GET)
	public String userNameRetry(String name) {
		name = StringUtils.isEmpty(name) ? "测试" : name;
		return userServiceFeign.userNameRetry(name);
	}
	
}
