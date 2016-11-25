package com.steven.demo.dependency.util;

import com.steven.demo.dependency.util.bean.Student;
import com.steven.demo.dependency.util.bean.Teacher;

public interface IApp {
	public Student getStudent();
	public Teacher getTeacher();
	public String getX();
	public String testString();
	public int testInjectAop(int a);
	public void setAtt(String p_Attibute);
	public String getAtt();
	public String repositoryTest();
}
