package com.acgist.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.acgist.service.IUserService;
import com.acgist.service.User;

@Service
public class UserService implements IUserService {

	@Value("${server.port}")
	private String port;
	
	@Override
	public User findOne(String name) {
		return new User(name, Integer.valueOf(port));
	}

}
