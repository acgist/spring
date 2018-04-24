package com.acgist.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateBalance {

	@Bean
	@LoadBalanced // 负载均衡
	RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
}
