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
@Component
public class App implements IApp
{
	public App(){
		
	}
	private String X;
	private Student student;
	private Teacher teacher;
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
    	return "first second "
    			+ "\r\n"
    			+ "my first";
    }
}