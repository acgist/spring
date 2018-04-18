package com.acgist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.acgist.config.APIBuilder;

@RestController
public class DateController {

	@Autowired
	private APIBuilder apiBuilder;
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value = "/date", method = RequestMethod.GET)
	public String date() {
		return restTemplate.getForEntity(apiBuilder.buildAPIURL4Date(), String.class).getBody();
	}
	
}
