package com.acgist.esceurekagateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.ComponentScan;

@EnableZuulProxy
@ComponentScan(basePackages = { "com" })
@SpringBootApplication
public class EscEurekaGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscEurekaGatewayApplication.class, args);
	}

}
