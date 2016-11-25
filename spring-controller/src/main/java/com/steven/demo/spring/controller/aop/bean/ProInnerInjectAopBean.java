package com.steven.demo.spring.controller.aop.bean;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ProInnerInjectAopBean {
	@Pointcut("execution(* com.steven.demo.dependency.util.impl.App.testInjectAop(..)) || within(com.steven.*)")
	public void performance(){}
	@Pointcut("execution(* com.steven.demo.dependency.util.impl.App.setAtt(String)) && args(thoughts)")
	public void read(String thoughts){
		
	}
	@Before("performance()")
	public void runBeforeMethod(){
		System.out.println("This is printed before method running......\r\n");
	}
	@Before("read(thoughts)")
	public void readAtt(String thoughts){
		System.out.println("This read by InnerInjectAop: " + thoughts + "\r\n");
	}
	@After("performance()")
	public void runAfterMethod(){
		System.out.println("This is Printed after method running......\r\n");
	}
	@AfterReturning("performance()")
	public void runAfterReturnMethod(){
		System.out.println("This is Printed after method returning......\r\n");
	}
	@AfterThrowing("performance()")
	public void runAfterThrow(){
		System.out.println("This is Printed after method throw Exceptions......\r\n");
	}
	@Around("performance()")
	public int aroundNotification(ProceedingJoinPoint joinPoint) throws Throwable{
		System.out.println("start timeStamp");
		long start = System.currentTimeMillis();
		int x = (Integer) joinPoint.proceed();
		long end = System.currentTimeMillis();
		System.out.println("end timeStamp, time is " + (end-start));
		return x;
	}
	public void testRun(){
		System.out.println("Found the Aop Injection Class,run......\r\n");
	}
}
