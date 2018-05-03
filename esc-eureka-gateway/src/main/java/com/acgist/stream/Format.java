package com.acgist.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;

public interface Format {

	String INPUT = "formatInput";

	@Input(INPUT)
	SubscribableChannel input();
	
}
