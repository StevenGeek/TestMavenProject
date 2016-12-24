package com.steven.demo.dependency.util.bean;

import javax.swing.*;

/**
 * Created by kira7 on 2016/11/30 0030.
 */
public class SpringConfigInjectBean {
	public String getNameA() {
		return nameA;
	}

	public void setNameA(String nameA) {
		this.nameA = nameA;
	}

	private String nameA;
	public SpringConfigInjectBean(){

	}
	public SpringConfigInjectBean(String nameA){
		this.nameA=nameA;
	}

	public synchronized void print(String x){
		this.nameA = x;
		Thread thread = Thread.currentThread();
		System.out.print(thread.getName() + " start print: " + nameA + "\n");
	}
}
