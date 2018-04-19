package com.acgist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.acgist.service.DateService;

@Configuration
public class RouterConfig {
	
	@Autowired
	private DateService dateService;
	
    @Bean
    public RouterFunction<ServerResponse> date() {
        return RouterFunctions.route(RequestPredicates.GET("/router/date"), dateService::date).filter((request, next) -> {
        	return next.handle(request);
        });
    }
    
    @Bean
    public RouterFunction<ServerResponse> time() {
    	return RouterFunctions.route(RequestPredicates.GET("/router/time"), dateService::time).filter((request, next) -> {
    		return next.handle(request);
    	});
    }

}
