package com.acgist.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@SpringBootApplication
@ComponentScan(basePackages = { "com" })
public class SpringbootApplication {
	
	/**
	 * 加载系统用户和角色绑定
	 */
	@Bean
	public InMemoryUserDetailsManager inMemoryUserDetailsManager() {
	    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//	    manager.createUser(User.withDefaultPasswordEncoder().username("user").password("user").roles("USER").build());
//	    manager.createUser(User.withDefaultPasswordEncoder().username("admin").password("admin").roles("ADMIN").build());
	    manager.createUser(User.withUsername("user").password("user").roles("USER").build());
	    return manager;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
