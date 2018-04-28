package com.acgist.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

// 不使用注解时设置过滤器
//	@Bean
//	public AuthoFilter authoFilter() {
//		return new AuthoFilter();
//	}
	
//	// 自动扫描filter/pre和filter/post读取过滤器
//	@Bean
//	@Autowired
//	public FilterLoader filterLoader(ZuulFilterConfig config) {
//		FilterLoader loader = FilterLoader.getInstance();
//		loader.setCompiler(new GroovyCompiler());
//		FilterFileManager.setFilenameFilter(new GroovyFileFilter());
//		try {
//			FilterFileManager.init(config.getInterval(), config.getRoot() + "/pre", config.getRoot() + "/post");
//		} catch (Exception e) {
//			// TODO 异常处理
//			throw new RuntimeException(e);
//		}
//		return loader;
//	}
	
}
