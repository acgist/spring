package com.acgist.esceurekadashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.ComponentScan;

@EnableCircuitBreaker // 断路器
@EnableDiscoveryClient // 服务消费者
@EnableHystrixDashboard // 监控仪表盘
@SpringBootApplication
@ComponentScan(basePackages = { "com" })
public class EscEurekaDashboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscEurekaDashboardApplication.class, args);
	}
	
}
