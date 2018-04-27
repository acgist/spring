package com.acgist.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RetryController {

	@RequestMapping(value = "/retry", method = RequestMethod.GET)
	public String retry() {
		System.out.println("请求中：" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			// TODO LOGGER
		}
		return "retry";
	}

}
