package com.acgist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.acgist.config.APIBuilder;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class RetryService {

	@Autowired
	private APIBuilder apiBuilder;
	@Autowired
	private RestTemplate restTemplate;

	@HystrixCommand(fallbackMethod = "retryFail")
	public String retry() {
		return restTemplate.getForEntity(apiBuilder.buildAPIURL4Retry(), String.class).getBody();
	}
	
	public String retryFail() {
		return "服务调用失败，服务降级，回滚中...";
	}
	
}
