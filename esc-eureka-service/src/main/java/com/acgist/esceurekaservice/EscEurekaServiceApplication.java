package com.acgist.esceurekaservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient
@SpringBootApplication
@ComponentScan(basePackages = { "com" })
public class EscEurekaServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscEurekaServiceApplication.class, args);
	}
	
}
