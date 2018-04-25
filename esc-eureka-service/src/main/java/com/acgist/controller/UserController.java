package com.acgist.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acgist.api.APIUserService;

@RestController
public class UserController implements APIUserService {

	// 参数注解需要和feign注解一致，并且@RequestParam和@RequestHeader的value值不能少
	@Override // 继承注释
	public String userName(@RequestParam("name") String name) {
		return "acgist's name is " + name + "!";
	}

}
