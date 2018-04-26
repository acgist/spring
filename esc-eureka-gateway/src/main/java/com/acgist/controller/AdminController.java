package com.acgist.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@RequestMapping("/index")
	public String index() {
		return "/admin/index";
	}
	
	@RequestMapping("/login")
	public String login() {
		throw new RuntimeException("发生异常");
	}
	
}
