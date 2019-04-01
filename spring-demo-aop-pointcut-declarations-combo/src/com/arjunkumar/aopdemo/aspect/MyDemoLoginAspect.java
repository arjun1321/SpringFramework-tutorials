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
	
	// create point cut for getter method
	@Pointcut("execution(* com.arjunkumar.aopdemo.dao.*.get*(..))")
	private void getter() {}
	
	// create point cut for setter method
	@Pointcut("execution(* com.arjunkumar.aopdemo.dao.*.set*(..))")
	private void setter() {}
	
	// create pointcut for include package and exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Exectuing @Before advice on addAccount()");
	}
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performingAPIAnalytics() {
		System.out.println("\n=====>>> Performing API Analytics");
	}
	
}