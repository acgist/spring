package com.acgist.service;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class UserServiceFallbackFactory implements FallbackFactory<IUserService> {

	@Override
	public IUserService create(Throwable cause) {
		return new IUserService() {
			@Override
			public String userName(String name) {
				return "服务调用失败，服务降级，回滚中...";
			}
		};
	}

}
