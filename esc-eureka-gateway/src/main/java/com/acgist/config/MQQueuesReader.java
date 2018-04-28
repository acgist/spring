package com.acgist.config;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MQQueuesReader {

	@RabbitHandler
	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name = "acgist.demo", type = ExchangeTypes.FANOUT), value = @Queue(name = "acgist.demo.send.queue"), key = "send"))
	public void process(Message message) {
		System.out.println("收到信息：" + new String(message.getBody()));
	}
	
}
