package com.acgist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.acgist.filter.AuthoFilter;

@Configuration
public class FilterConfig {

	@Bean
	public AuthoFilter authoFilter() {
		return new AuthoFilter();
	}
	
}
