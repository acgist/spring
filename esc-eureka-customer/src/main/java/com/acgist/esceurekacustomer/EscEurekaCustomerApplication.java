package com.acgist.esceurekacustomer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableEurekaClient // 服务提供
@EnableFeignClients(basePackages = { "com.acgist.service" }) // Feign，需要指定basePackages
@EnableCircuitBreaker // 断路器
@EnableDiscoveryClient // 服务消费者
@SpringBootApplication
@ComponentScan(basePackages = { "com.acgist" })
@ServletComponentScan(basePackages = { "com.acgist.servlet" }) // 默认servlet
public class EscEurekaCustomerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscEurekaCustomerApplication.class, args);
	}

}
