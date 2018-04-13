package com.acgist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com")
@SpringBootApplication
public class SbcDubboServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbcDubboServiceApplication.class, args);
	}
}
