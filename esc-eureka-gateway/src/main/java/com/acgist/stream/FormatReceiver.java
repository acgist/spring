package com.acgist.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.handler.annotation.SendTo;

@EnableBinding(value = {Format.class})
public class FormatReceiver {

	@StreamListener(value = Format.INPUT)
	@SendTo(Sink.INPUT)
	public String receive1(String obj) {
		System.out.println("format收到消息：" + obj);
		return "format>>>>" + obj;
	}
	
	
}
