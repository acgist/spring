package com.acgist.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Order(1)
@Configuration
public class ActuatorWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
//				.requestMatchers(EndpointRequest.to("info")).permitAll() // 允许
//				.requestMatchers(EndpointRequest.to("mappings")).denyAll() // 禁止
//				.requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN") // ADMIN权限
//				.antMatchers("/anime").hasRole("USER") // USER权限
//				.antMatchers("/actuator", "/actuator/").hasRole("ADMIN") // ADMIN权限
//				.requestMatchers(EndpointRequest.toAnyEndpoint()).denyAll()
				.antMatchers("/**").permitAll() // 允许
				.and().httpBasic(); // HTTP Basic验证
//				.and().formLogin(); // 表单登陆
	}
	
}