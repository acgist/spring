package com.acgist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acgist.config.UserEntity;
import com.acgist.config.ZuulFilterConfig;

@RefreshScope // 刷新需要配置此注解
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Value("${system.acgist.name:}")
	private String systemAcgistName;
	@Value("${spring.cloud.config.uri:}")
	private String springCloudConfigUri;
	@Autowired
	private ZuulFilterConfig config;
	
	@RequestMapping("/index")
	public String index() {
		return "/admin/index";
	}
	
	@RequestMapping("/login")
	public String login() {
		throw new RuntimeException("发生异常");
	}
	
	@RequestMapping("/system/vars")
	public String systemAcgistName() {
		return systemAcgistName + "<br />" +
				springCloudConfigUri + "<br />" +
				config.getRoot();
	}
	
	@RequestMapping("/refresh")
	public String refresh() {
		return systemAcgistName;
	}
	
	@RequestMapping("/user")
	public UserEntity user() {
		UserEntity user = new UserEntity();
		user.setName("acgist");
		user.setAge(20);
		return user;
	}
	
}
