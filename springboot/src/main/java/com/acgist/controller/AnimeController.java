package com.acgist.controller;

import java.util.HashMap;
import java.util.Map;

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
	public String anime() {
		return "hello world，" + systemName +
				"，spring.profiles.active=" + env.getProperty("spring.profiles.active") +
				"，profiles=" + env.getProperty("profile");
	}
	
	@RequestMapping("/json")
	public Map<String, String> json() {
		Map<String, String>	json = new HashMap<String, String>();
		json.put("name", "acgist");
		json.put("value", "json");
		return json;
	}

}
