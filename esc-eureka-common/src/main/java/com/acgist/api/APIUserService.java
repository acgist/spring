package com.acgist.api;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/api")
public interface APIUserService {

	@RequestMapping(value = "/user/name", method = RequestMethod.GET)
	String userName(@RequestParam("name") String name);
	
}
