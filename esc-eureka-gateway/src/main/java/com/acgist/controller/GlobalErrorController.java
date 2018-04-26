package com.acgist.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GlobalErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	@ResponseBody
	@RequestMapping("/error")
	public String error() {
		return "自定义错误信息";
	}

}
