package com.acgist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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
	
	@ResponseBody
	@RequestMapping("/system/vars")
	public String systemAcgistName() {
		return systemAcgistName + "<br />" +
				springCloudConfigUri + "<br />" +
				config.getRoot();
	}
	
	@ResponseBody
	@RequestMapping("/refresh")
	public String refresh() {
		return systemAcgistName;
	}
	
}
