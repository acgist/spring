package com.acgist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.zuul.FilterFileManager;
import com.netflix.zuul.FilterLoader;
import com.netflix.zuul.groovy.GroovyCompiler;
import com.netflix.zuul.groovy.GroovyFileFilter;

@Configuration
public class FilterConfig {

// 不使用注解时设置过滤器
//	@Bean
//	public AuthoFilter authoFilter() {
//		return new AuthoFilter();
//	}
	
	// 自动扫描filter/pre和filter/post读取过滤器
	@Bean
	@Autowired
	public FilterLoader filterLoader(ZuulFilterConfig config) {
		FilterLoader loader = FilterLoader.getInstance();
		loader.setCompiler(new GroovyCompiler());
		FilterFileManager.setFilenameFilter(new GroovyFileFilter());
		try {
			FilterFileManager.init(config.getInterval(), config.getRoot() + "/pre", config.getRoot() + "/post");
		} catch (Exception e) {
			// TODO 异常处理
			throw new RuntimeException(e);
		}
		return loader;
	}
	
}
