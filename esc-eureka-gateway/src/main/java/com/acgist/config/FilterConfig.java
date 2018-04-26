//package com.acgist.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.acgist.filter.AuthoFilter;
//import com.acgist.filter.ErrorFilter;
//import com.acgist.filter.PostFilter;
//
//// 不使用注解设置过滤器
//@Configuration
//public class FilterConfig {
//
//	@Bean
//	public AuthoFilter authoFilter() {
//		return new AuthoFilter();
//	}
//	
//	@Bean
//	public ErrorFilter errorFilter() {
//		return new ErrorFilter();
//	}
//	
//	@Bean
//	public PostFilter postFilter() {
//		return new PostFilter();
//	}
//	
//}
