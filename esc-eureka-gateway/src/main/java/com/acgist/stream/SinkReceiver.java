package com.acgist.stream;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;

/**
 * 即是监听了多次Sink.INPUT在rabbit一个实例也只对应一个queue（注：没有配置分区的情况下）
 * 非常奇怪的问题：
 * 配置：spring.cloud.stream.bindings.output.destination=input
 * 没有打开output监听一切正常，但是代开output监听后发现，居然有消息跑到了output上面了
 */
@EnableBinding(value = {Sink.class, Source.class})
public class SinkReceiver {

	@StreamListener(value = Sink.INPUT)
//	@StreamListener(value = Sink.INPUT, condition = "headers['type']=='input'")
	public void receive1(String obj) {
		System.out.println("receive1收到消息：" + obj);
	}
	
	
//	这两个注释功能和@StreamListener类似
//	@Transformer
//	@ServiceActivator()
	
	@StreamListener(value = Sink.INPUT)
//	@StreamListener(value = Source.OUTPUT, condition = "headers['type']=='input'")
	public void receive2(String obj) {
		System.out.println("receive2收到消息：" + obj);
	}
	
//	@StreamListener(value = Source.OUTPUT)
////	@StreamListener(value = Source.OUTPUT, condition = "headers['type']=='input'")
//	public void receive3(String obj) {
//		System.out.println("receive3收到消息：" + obj);
//	}
	
//	消息反馈
//	#spring.cloud.stream.bindings.output.destination=input
//	#spring.cloud.stream.bindings.input.destination=output
//	@StreamListener(Processor.INPUT)
//	@SendTo(Processor.OUTPUT)
//	public String handle(String value) {
//		System.out.println("消息转换" + value);
//		return value.toUpperCase();
//	}
	
}
