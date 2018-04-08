package com.acgist.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties // 读取yml不能设置prefix属性
//@PropertySource(value = "email.yml")
@ConfigurationProperties(prefix = "email")
@PropertySource(value = "email.properties")
public class EmailConfig {

	private String port;
	private String name;
	/**
	 * 默认匹配email.names
	 * 	如果存在，不会获取email-tencent.user.names的值
	 * 	如果不存在时，会获取email-tencent.user.names的值
	 * 例如上面的name是存在的，加上@Value("${email-tencent.user.names}")后，依然取值是email.name的值
	 */
	@Value("${email-tencent.user.names}")
	private String names;
	@Value("#{'${yml-config}'.split(',')}")
	private List<String> ymls;

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getYmls() {
		return ymls;
	}

	public void setYmls(List<String> ymls) {
		this.ymls = ymls;
	}

}
