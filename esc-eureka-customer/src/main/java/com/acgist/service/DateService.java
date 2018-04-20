package com.acgist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.acgist.config.APIBuilder;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class DateService {

	@Autowired
	private APIBuilder apiBuilder;
	@Autowired
	private RestTemplate restTemplate;

	public String date() {
		return restTemplate.getForEntity(apiBuilder.buildAPIURL4Date(), String.class).getBody();
	}
	
	@HystrixCommand(fallbackMethod = "dateFail")
	public String dateV2() {
		return restTemplate.getForEntity(apiBuilder.buildAPIURL4Date(), String.class).getBody();
	}
	
	/**
	 * 进入条件：
	 * 		处于熔断/短路状态，熔断器打开时
	 * 		线程池、请求队列或信号量占满时
	 * 		抛出异常时
	 */
	public String dateFail() {
		return "服务调用失败，服务降级，回滚中";
	}
	
}
