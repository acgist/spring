package com.acgist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnimeController {

	@Autowired
	private Environment env;
	@Value("${system.name:null}")
	private String systemName;

	@RequestMapping("/anime")
	public String test() {
		return "hello world，" + systemName +
				"，spring.profiles.active=" + env.getProperty("spring.profiles.active") +
				"，profiles=" + env.getProperty("profile");
	}

}
