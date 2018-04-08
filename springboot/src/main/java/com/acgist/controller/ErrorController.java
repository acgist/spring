package com.acgist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

	@Override
	public String getErrorPath() {
		return "/html/common/error.html";
	}

	@RequestMapping(value = "/error")
	public String index() {
		return getErrorPath();
	}
	
	@RequestMapping(value = "/ftl")
	public ModelAndView jsp() {
		ModelAndView view = new ModelAndView("/ftl/index");
		return view;
	}
	
}