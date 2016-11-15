package com.steven.testSpring.test1.dependencyJar.bean;

import org.springframework.stereotype.Component;

import com.steven.testSpring.test1.dependencyJar.PersonInterface;

public class Student implements PersonInterface{

	private String name;
	private int num;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	@Override
	public String toString() {
		return "student [name=" + name + ", num=" + num + "]";
	}
}
