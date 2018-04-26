package com.acgist.config;

import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 只能用来处理本项目的404和500，不能处理调用服务出现的情况
 */
@Configuration
public class ErrorPageConfig {

	@Bean
	public ErrorPageRegistrar errorPageRegistrar() {
		return new ErrorPageRegistrar() {
			@Override
			public void registerErrorPages(ErrorPageRegistry registry) {
//				registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"),
				registry.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/404.html"),
						new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/500.html"));
			}
		};
	}

}
