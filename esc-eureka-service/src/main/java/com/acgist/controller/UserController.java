package com.acgist.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.acgist.api.APIUserService;

@RestController
public class UserController implements APIUserService {

	// 参数注解需要和feign注解一致，并且@RequestParam和@RequestHeader的value值不能少
	@Override // 继承注释
	public String userName(@RequestParam("name") String name) {
		System.out.println("请求中：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		if("retry".equals(name)) {
			try {
				Thread.sleep(10 * 1000);
			} catch (InterruptedException e) {
				// TODO LOGGER
			}
		}
		return "acgist's name is " + name + "!";
	}
	
	@RequestMapping(value = "/user/name/retry", method = RequestMethod.GET)
	public String userNameRetry(@RequestParam("name") String name) {
		System.out.println("请求中：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		if("retry".equals(name)) {
			try {
				Thread.sleep(10 * 1000);
			} catch (InterruptedException e) {
				// TODO LOGGER
			}
		}
		return "acgist's name is " + name + "!";
	}

}
