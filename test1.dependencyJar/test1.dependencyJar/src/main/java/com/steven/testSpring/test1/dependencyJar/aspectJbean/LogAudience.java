package com.steven.testSpring.test1.dependencyJar.aspectJbean;

import org.aspectj.lang.ProceedingJoinPoint;

public class LogAudience {
	private String attribute;
	public void runBeforeMethod(){
		System.out.println("This is printed before method running......\r\n");
	}
	public void runAfterMethod(){
		System.out.println("This is Printed after method running......\r\n");
	}
	public void runAfterThrow(){
		System.out.println("This is Printed after method throw Exceptions......\r\n");
	}
	public void aroundNotification(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("start timeStamp");
		long start = System.currentTimeMillis();
		joinPoint.proceed();
		long end = System.currentTimeMillis();
		System.out.println("end timeStamp, time is " + (end-start));
	}
	public void readAtt(String p_Att){
		this.attribute = p_Att;
		System.out.println("display read att: " + this.attribute + "\r\n");
	}
	public String getAtt(){
		return this.attribute;
	}
}
