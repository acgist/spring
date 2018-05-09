package com.acgist.esceurekazipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin.server.internal.EnableZipkinServer;

@EnableZipkinServer
//@EnableZipkinStreamServer
@SpringBootApplication
public class EscEurekaZipkinServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EscEurekaZipkinServerApplication.class, args);
	}
}
