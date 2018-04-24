package com.acgist.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class APIController {

	@Value("${system.name:}")
	private String name;
	
	@RequestMapping(value = "/date", method = RequestMethod.GET)
	public String date() {
		final String name = this.name == null ? "当前只有一个服务提供者" : this.name;
		return name + "，当前时间：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
	}
	
	// 参数注解需要和feign注解一致，并且@RequestParam和@RequestHeader的value值不能少
	@RequestMapping(value = "/user/name", method = RequestMethod.GET)
	public String userName(@RequestParam("name") String name) {
		return "acgist's name is " + name + "!";
	}
	
}
