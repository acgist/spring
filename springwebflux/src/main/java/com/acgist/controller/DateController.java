package com.acgist.controller;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class DateController {

	@GetMapping(path = "/date")
	public Mono<String> date() {
		return Mono.just(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")));
	}
	

	@GetMapping("/time")
	public Flux<ServerSentEvent<String>> time() {
		return Flux.interval(Duration.ofSeconds(1L)).map(index -> ServerSentEvent.<String>builder().event("event")
				.id("id").data(LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss"))).build());
//		return Flux.interval(Duration.ofSeconds(1L)).map(index -> {return ServerSentEvent.<String>builder().build();});
	}

}
