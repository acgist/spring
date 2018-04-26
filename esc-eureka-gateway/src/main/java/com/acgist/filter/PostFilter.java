package com.acgist.filter;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * 执行了SendErrorFilter后会forward到/error上面，然后页面已经响应后，依然会执行post的filter
 */
@Component
public class PostFilter extends ZuulFilter {

	@Override
	public Object run() throws ZuulException {
		System.out.println("----------------POST----------------");
		// 获取内容后可以进行签名处理
//		String content = new BufferedReader(new InputStreamReader(RequestContext.getCurrentContext().getResponseDataStream())).readLine();
//		System.out.println(content);
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

	@Override
	public String filterType() {
		return "post";
	}

}
