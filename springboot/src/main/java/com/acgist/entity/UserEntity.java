package com.acgist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "tb_user")
@GenericGenerator(name = "sequenceGenerator", strategy = "uuid")
//@SequenceGenerator(name = "sequenceGenerator", sequenceName = "tb_user_sequence")
public class UserEntity extends BaseEntity {

	private static final long serialVersionUID = 1L;

	private String name;
	private Integer age;

	@Column(length = 20)
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
