package com.arjunkumar.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {

	// Add related advices for logging
	
	// Before Advice
	
	@Pointcut("execution(* com.arjunkumar.aopdemo.dao.*.*(..))")
	private void forDaoPackage() {}
	
	
	@Before("forDaoPackage()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Exectuing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackage()")
	public void performingAPIAnalytics() {
		System.out.println("\n=====>>> Performing API Analytics");
	}
	
}