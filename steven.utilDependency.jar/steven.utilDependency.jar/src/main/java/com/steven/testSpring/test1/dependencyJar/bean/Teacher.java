package com.steven.testSpring.test1.dependencyJar.bean;

import com.steven.testSpring.test1.dependencyJar.PersonInterface;

public class Teacher implements PersonInterface{
	private String num;
	private String name;
	private Student stu;
	@Override
	public String toString() {
		return "Teacher [num=" + num + ", name=" + name + ", stu=" + stu + "]";
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Student getStu() {
		return stu;
	}
	public void setStu(Student stu) {
		this.stu = stu;
	}
	
}
