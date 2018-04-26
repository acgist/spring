package com.acgist.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

/**
 * 如果不是用@Component注解可以使用下面的方法进行配置
 * @Bean
 * 	public AuthoFilter authoFilter() {
 * 		return new AuthoFilter();
 * 	}
 * 非常重要：zuulfilter并不是拦截所有的请求，而是只拦截routes路由的请求
 */
@Component
public class AuthoFilter extends ZuulFilter {

	@Override
	public Object run() throws ZuulException {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String token = request.getParameter("token");
		if(token == null) {
			ctx.setSendZuulResponse(false);
			ctx.setResponseStatusCode(401);
			ctx.setResponseBody("miss token");
		} else if(token.equals("error")) {
			throw new RuntimeException("系统异常！");
		}
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 10;
	}

	/**
	 * pre:请求执行之前filter
	 * route:处理请求，进行路由
	 * post:请求处理完成后执行的filter
	 * error:出现错误时执行的filter
	 */
	@Override
	public String filterType() {
		return "pre";
	}

}
