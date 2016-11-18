package com.steven.testSpring.test1.dependencyJar;

import com.steven.testSpring.test1.dependencyJar.bean.Student;
import com.steven.testSpring.test1.dependencyJar.bean.Teacher;

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
