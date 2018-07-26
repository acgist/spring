package com.acgist.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * JAVA 9/10 请添加 --add-modules java.xml.bind
 */
@EnableCaching
@SpringBootApplication
@EnableTransactionManagement
@EntityScan("com.acgist.entity")
@ComponentScan(basePackages = { "com" })
@EnableJpaRepositories("com.acgist.dao")
public class SpringbootApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}

}
