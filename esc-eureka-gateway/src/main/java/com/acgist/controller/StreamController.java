package com.acgist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.messaging.Processor;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stream")
public class StreamController {

	@Autowired
	@Qualifier(Processor.OUTPUT)
//	private MessageService messageService;
	private MessageChannel messageChannel;
	
	@RequestMapping(value = "/send", method = RequestMethod.GET)
	public String send(String message) {
		if(message == null) {
			message = "black message";
		}
		messageChannel.send(MessageBuilder.withPayload(message).build());
//		messageService.output().send(MessageBuilder.withPayload(message).build());
		return "success";
	}
	
}
