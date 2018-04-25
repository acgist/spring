package com.acgist.service;

import org.springframework.cloud.openfeign.FeignClient;

import com.acgist.api.APIUserService;

//@FeignClient(name = "esc-eureka-service")
@FeignClient(name = "esc-eureka-service", fallback = UserServiceFallback.class)
//@FeignClient(name = "esc-eureka-service", fallbackFactory = UserServiceFallbackFactory.class)
public interface IUserService extends APIUserService {

}
