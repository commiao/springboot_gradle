package com.miao.mq_activemq;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = -769676438806558929L;

	private Long id;
	private Integer age;
	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
