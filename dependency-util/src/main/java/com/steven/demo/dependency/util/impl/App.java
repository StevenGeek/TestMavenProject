package com.steven.demo.dependency.util.impl;

import com.steven.demo.dependency.util.IApp;

import com.steven.demo.dependency.util.bean.Student;
import com.steven.demo.dependency.util.bean.Teacher;
import org.springframework.context.annotation.Primary;

/**
 * Hello world!
 *
 */
@Primary
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
//		System.out.println("run testString method......\r\n");
		String aString = "b";
    	return aString;
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
	public String repositoryTest(){
		return "see";
	}
}
