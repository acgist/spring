package com.acgist.filter;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * SendErrorFilter已经改为error，并且执行的顺序是0
 */
@Component
public class ErrorFilter extends ZuulFilter {

	@Override
	public Object run() throws ZuulException {
		System.out.println("----------------ERROR----------------");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return -1;
	}

	@Override
	public String filterType() {
		return "error";
	}

}
