package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Retryer;

@Configuration
public class UserConfig {

	@Bean
	public Retryer feignRetryer() {
		return Retryer.NEVER_RETRY;
	}
	
//	@Bean
//	public Retryer userConfigRetryer() {
//		return new Retryer.Default(100, TimeUnit.SECONDS.toMillis(1L), 0);
//	}
//
//	@Bean
//	public Request.Options userConfigOptions() {
//		return new Request.Options(1 * 1000, 4 * 1000);
//	}
	
}
