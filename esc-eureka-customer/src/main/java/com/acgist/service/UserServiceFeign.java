package com.acgist.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api")
@FeignClient(name = "esc-eureka-service")
public interface UserServiceFeign {

	@RequestMapping(value = "/user/name/retry", method = RequestMethod.GET)
	String userNameRetry(@RequestParam("name") String name);

}
