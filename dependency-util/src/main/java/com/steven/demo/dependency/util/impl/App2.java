package com.steven.demo.dependency.util.impl;

import com.steven.demo.dependency.util.IApp;
import com.steven.demo.dependency.util.bean.Student;
import com.steven.demo.dependency.util.bean.Teacher;

/**
 * Created by kira7 on 2016/12/5 0005.
 */
public class App2 implements IApp {
	@Override
	public Student getStudent() {
		return null;
	}

	@Override
	public Teacher getTeacher() {
		return null;
	}

	@Override
	public String getX() {
		return null;
	}

	@Override
	public String testString() {
		return null;
	}

	@Override
	public int testInjectAop(int a) {
		return 0;
	}

	@Override
	public void setAtt(String p_Attibute) {

	}

	@Override
	public String getAtt() {
		return null;
	}

	@Override
	public String repositoryTest() {
		return null;
	}
}
