package com.acgist.esceurekaconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class EscEurekaConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscEurekaConfigApplication.class, args);
	}

}
