package com.acgist.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class APIBuilder {

	@Value("${system.service.esc-eureka-service:}")
	private String escEurekaService;
	
	public String buildAPIURL4Date() {
		return escEurekaService + "/api/date";
	}
	
}
