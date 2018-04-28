package com.acgist.config;

import java.io.Serializable;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 不能使用配置中心
 */
@Component
@PropertySource(value = "filter.properties")
@ConfigurationProperties(prefix = "zuul.filter")
public class ZuulFilterConfig implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String root;
	private Integer interval;

	public String getRoot() {
		return root;
	}

	public void setRoot(String root) {
		this.root = root;
	}

	public Integer getInterval() {
		return interval;
	}

	public void setInterval(Integer interval) {
		this.interval = interval;
	}

}
