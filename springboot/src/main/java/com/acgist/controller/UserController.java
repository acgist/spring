package com.acgist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.acgist.entity.UserEntity;
import com.acgist.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("/create")
	public UserEntity create(String name) {
		return userService.create(name);
	}
	
	@RequestMapping("/find/one")
	public ModelAndView findOne(String name) {
		UserEntity user = userService.findOne(name);
		ModelAndView view = new ModelAndView("/ftl/user");
		view.addObject("user", user);
		return view;
	}
	
	@RequestMapping("/find/page")
	public Page<UserEntity> findOne(Integer page) {
		return userService.findPage(page);
	}
	
	@RequestMapping("/remove")
	public void remove(String name) {
		userService.remove(name);
	}
	
}
