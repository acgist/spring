package com.acgist.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommonController implements ErrorController {

	@RequestMapping(value = "/error")
	public String index() {
		return "/ftl/error";
	}
	
	@RequestMapping(value = "/v1/ftl")
	public String ftlV1() {
		return "/ftl/index";
	}
	
	@RequestMapping(value = "/v2/ftl")
	public ModelAndView ftlV2() {
		ModelAndView view = new ModelAndView("/ftl/index");
		return view;
	}
	
	@RequestMapping(value = "/v1/html")
	public String htmlV1() {
		return "/html/index.html";
	}
	
	@RequestMapping(value = "/v2/html")
	public ModelAndView htmlV2() {
		ModelAndView view = new ModelAndView("/html/index.html");
		return view;
	}

	@Override
	public String getErrorPath() {
		return "/ftl/error";
	}
	
}