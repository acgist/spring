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
//	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name = "acgist.demo", type = ExchangeTypes.TOPIC), value = @Queue(name = "acgist.demo.send.queue"), key = "send"))
	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name = "acgist.demo", type = ExchangeTypes.FANOUT), value = @Queue(name = "acgist.demo.send.queue"), key = "send"))
	public void process1(Message message) {
		System.out.println("通道1收到信息：" + new String(message.getBody()));
	}
	
	@RabbitHandler
//	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name = "acgist.demo", type = ExchangeTypes.TOPIC), value = @Queue(name = "acgist.demo.send.queue"), key = "send"))
	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name = "acgist.demo", type = ExchangeTypes.FANOUT), value = @Queue(name = "acgist.demo.send.queue"), key = "send"))
	public void process2(Message message) {
		System.out.println("通道2收到信息：" + new String(message.getBody()));
	}
	
	@RabbitHandler
//	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name = "acgist.demo", type = ExchangeTypes.TOPIC), value = @Queue(name = "acgist.demo.send.queueAll"), key = "send"))
	@RabbitListener(bindings = @QueueBinding(exchange = @Exchange(name = "acgist.demo", type = ExchangeTypes.FANOUT), value = @Queue(name = "acgist.demo.send.queueAll"), key = "send"))
	public void processAll(Message message) {
		System.out.println("通道All收到信息：" + new String(message.getBody()));
	}
	
}
