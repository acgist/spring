package com.acgist.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.acgist.api.APIUserService;
import com.config.UserConfig;

/**
 * 独立配置并没有效果
 */
//@FeignClient(name = "esc-eureka-service")
@FeignClient(name = "esc-eureka-service", fallback = UserServiceFallback.class, configuration = UserConfig.class)
//@FeignClient(name = "esc-eureka-service", fallbackFactory = UserServiceFallbackFactory.class)
public interface IUserService extends APIUserService {

}