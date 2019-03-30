package com.arjunkumar.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoginAspect {

	// Add related advices for logging
	
	// Before Advice
	
	@Before("execution(* com.arjunkumar.aopdemo.dao.*.*(..))")
//	@Before("execution(* add*(..))")
//	@Before("execution(* add*(com.arjunkumar.aopdemo.Account, ..))")
//	@Before("execution(void add*())")
//	@Before("execution(public void add*())")
//	@Before("execution(public void com.arjunkumar.aopdemo.dao.AccountDAO.addAccount())")
//	@Before("execution(public void updateAccount())")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Exectuing @Before advice on addAccount()");
	}
	
}
