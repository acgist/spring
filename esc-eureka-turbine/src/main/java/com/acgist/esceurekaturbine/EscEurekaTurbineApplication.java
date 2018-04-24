package com.acgist.esceurekaturbine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

//@EnableTurbineStream // Turbine Stream使用RabbitMQ
@EnableTurbine // Turbine
@EnableDiscoveryClient // 服务消费者
@EnableHystrixDashboard // 监控仪表盘
@SpringBootApplication
public class EscEurekaTurbineApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscEurekaTurbineApplication.class, args);
	}

}
