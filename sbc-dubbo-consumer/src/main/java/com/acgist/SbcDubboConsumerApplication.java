package com.acgist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com")
@SpringBootApplication
public class SbcDubboConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbcDubboConsumerApplication.class, args);
	}
}
