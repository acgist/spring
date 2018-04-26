package com.acgist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.acgist.config.EmailConfig;

@RestController
public class EmailController {

//	@Autowired
//	private Environment env;
	@Autowired
	private EmailConfig emailConfig;
	
	@RequestMapping("/email")
	public String email() {
//		return env.getProperty("email.port");
		return "PORT：" + emailConfig.getPort() +
				"，NAME：" + emailConfig.getName() +
				"，USER-NAMES：" + emailConfig.getNames() +
				"，YMLS：" + emailConfig.getYmls() +
				"，YMLS-SIZE：" + emailConfig.getYmls().size();
	}
	
}
