package com.acgist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acgist.service.DateService;

import io.swagger.annotations.ApiOperation;

@RestController
public class DateController {

	@Autowired
	private DateService dateService;
	
	@ApiOperation(value = "查询时间", notes = "查询时间不使用熔断器")
	@RequestMapping(value = "/date", method = RequestMethod.GET)
	public String date() {
		return dateService.date();
	}
	
	@ApiOperation(value = "查询时间", notes = "查询时间使用熔断器")
	@RequestMapping(value = "/v2/date", method = RequestMethod.GET)
	public String time() {
		return dateService.dateV2();
	}
	
}
