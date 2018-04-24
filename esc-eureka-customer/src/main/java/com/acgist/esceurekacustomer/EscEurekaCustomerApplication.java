package com.acgist.esceurekacustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients(basePackages = { "com.acgist.service" }) // Feign
//@EnableCircuitBreaker // 断路器
@EnableDiscoveryClient // 服务消费者
@SpringBootApplication
@ComponentScan(basePackages = { "com" })
public class EscEurekaCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscEurekaCustomerApplication.class, args);
	}
	
}
