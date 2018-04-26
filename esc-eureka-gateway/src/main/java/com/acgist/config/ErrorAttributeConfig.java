package com.acgist.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

@Component
public class ErrorAttributeConfig extends DefaultErrorAttributes {
	
	@Override
	public Map<String, Object> getErrorAttributes(WebRequest webRequest, boolean includeStackTrace) {
//		Map<String, Object> result = super.getErrorAttributes(webRequest, includeStackTrace);
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 9999);
		result.put("message", "系统错误");
		result.put("sign", "系统签名");
		return result;
	}
	
}