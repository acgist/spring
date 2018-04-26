package com.acgist.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 设置本项目的异常处理，不包含进入到zuulfilter的请求异常，zuulfilter的异常将进入到/error处理
 * 不设置返回类型会根据客户端请求的类型进行返回，如果没有设置请求类型，将会默认返回json
 * 如果这里进行重定向会被自定义的500页面拦截
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = Exception.class)
//	public ResponseEntity<Map<String, String>> defaultErrorHandler(HttpServletRequest request, Exception e)throws Exception {
	public Map<String, String> defaultErrorHandler(HttpServletRequest request, Exception e)throws Exception {
		Map<String, String> data = new HashMap<String, String>();
		data.put("code", "9999");
		data.put("message", "全局异常处理");
		return data;
//		return ResponseEntity.status(200).contentType(MediaType.APPLICATION_JSON_UTF8).body(data);
	}

}
