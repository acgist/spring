package com.acgist.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.acgist.interceptor.UserInterceptor;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserInterceptor()).addPathPatterns("/user/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

//	// 可以不用写，自动配置以及配置过了
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//		WebMvcConfigurer.super.addResourceHandlers(registry);
//	}

///**
// * 如果继承了WebMvcConfigurationSupport或者使用@EnableWebMvc，会屏蔽EnableAutoConfiguration主动配置，所以今天资源会失效
// */
//public class InterceptorConfig extends WebMvcConfigurationSupport {
//
//	@Override
//	protected void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(new UserInterceptor()).addPathPatterns("/user/**");
//		super.addInterceptors(registry);
//	}
//	
//	@Override
//	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
//		super.addResourceHandlers(registry);
//	}
	
}
