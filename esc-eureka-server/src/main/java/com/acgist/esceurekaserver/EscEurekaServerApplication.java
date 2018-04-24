package com.acgist.esceurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // eureka注册中心
@SpringBootApplication
public class EscEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscEurekaServerApplication.class, args);
	}
	
}
