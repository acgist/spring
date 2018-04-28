package com.acgist.config;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "userEntity")
public class UserEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@JsonProperty(value = "nameValue")
	@JacksonXmlProperty(localName = "nameValue")
	private String name;
	@JsonProperty(value = "ageValue")
	@JacksonXmlProperty(localName = "ageValue")
	private Integer age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
