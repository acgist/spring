package com.acgist.service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DateService {

	public Mono<ServerResponse> date(ServerRequest request) {
		return ServerResponse.ok().contentType(MediaType.TEXT_PLAIN)
				.body(Mono.just(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd"))), String.class);
	}

	public Mono<ServerResponse> time(ServerRequest serverRequest) {
		return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(Flux.interval(Duration.ofSeconds(1L))
				.map(index -> LocalDateTime.now().format(DateTimeFormatter.ofPattern("HHmmss")) + "，当前返回序列：" + index),
				String.class).onErrorMap((e) -> {
					System.out.println("发生异常");
					return e;
				});
	}

}
