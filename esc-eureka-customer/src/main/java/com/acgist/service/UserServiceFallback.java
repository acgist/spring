package com.acgist.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 实现熔断器逻辑
 */
@Component
@RequestMapping("/fallback/api") // 防止出现requestMappingHandlerMapping重复异常
public class UserServiceFallback implements IUserService {

	@Override
	public String userName(@RequestParam("name") String name) {
		return "服务调用失败，服务降级，回滚中...";
	}

}
