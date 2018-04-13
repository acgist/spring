package com.acgist.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SBErrorController implements ErrorController {

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