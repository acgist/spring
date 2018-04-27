package com.acgist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.acgist.service.RetryService;

@RestController
public class RetryController {
	
	@Autowired
	private RetryService retryService;
	
	@RequestMapping(value = "/ribbon/retry", method = RequestMethod.GET)
	public String retry() {
		return retryService.retry();
	}
	
}
