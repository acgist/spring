package com.acgist.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mq")
public class MQController {

	@Autowired
	private AmqpTemplate amqpTemplate;
	
	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public String send(String message) {
		if(message == null) {
			message = "black message";
		}
		amqpTemplate.convertAndSend("acgist.demo", "send", MessageBuilder.withBody(message.getBytes()).build());
		return "success";
	}
	
}
