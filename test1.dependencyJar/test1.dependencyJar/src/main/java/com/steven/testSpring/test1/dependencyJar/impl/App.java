package com.steven.testSpring.test1.dependencyJar.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.steven.testSpring.test1.dependencyJar.IApp;
import com.steven.testSpring.test1.dependencyJar.bean.Student;
import com.steven.testSpring.test1.dependencyJar.bean.Teacher;

/**
 * Hello world!
 *
 */

public class App implements IApp
{
	public App(){
		
	}
	private String X;
	private Student student;
	private Teacher teacher;
	private String attribute;
    public String getX() {
		return X;
	}
	public void setX(String x) {
		X = x;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public String testString(){
		System.out.println("run testString method......\r\n");
    	return "first second "
    			+ "\r\n"
    			+ "my first";
    }
	public int testInjectAop(int a){
		System.out.println("run testInjectAop method......\r\n");
    	return 2/a;
    }
	public void setAtt(String p_Attibute) {
		this.attribute = p_Attibute;
	}
	public String getAtt() {
		return this.attribute;
	}
}
