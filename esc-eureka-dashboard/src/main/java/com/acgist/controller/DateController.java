package com.acgist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acgist.service.DateService;

@RestController
public class DateController {

	@Autowired
	private DateService dateService;
	
	@RequestMapping(value = "/date", method = RequestMethod.GET)
	public String date() {
		return dateService.date();
	}
	
	@RequestMapping(value = "/v2/date", method = RequestMethod.GET)
	public String time() {
		return dateService.dateV2();
	}
	
}
