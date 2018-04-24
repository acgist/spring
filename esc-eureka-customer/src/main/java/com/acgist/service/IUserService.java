package com.acgist.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "esc-eureka-service")
public interface IUserService {

	@RequestMapping(value = "/api/user/name", method = RequestMethod.GET)
	String userName(@RequestParam("name") String name);
	
}
