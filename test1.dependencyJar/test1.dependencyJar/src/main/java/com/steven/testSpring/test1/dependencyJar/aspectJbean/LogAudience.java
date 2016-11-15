package com.steven.testSpring.test1.dependencyJar.aspectJbean;

public class LogAudience {
	public void runBeforeMethod(){
		System.out.println("This is printed before method running......\r\n");
	}
	public void runAfterMethod(){
		System.out.println("This is Printed after method running......\r\n");
	}
	public void runAfterThrow(){
		System.out.println("This is Printed after method throw Exceptions......\r\n");
	}
}
