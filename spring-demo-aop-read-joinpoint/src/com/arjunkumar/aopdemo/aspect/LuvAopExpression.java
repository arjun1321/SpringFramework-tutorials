package com.arjunkumar.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class LuvAopExpression {
	
	@Pointcut("execution(* com.arjunkumar.aopdemo.dao.*.*(..))")
	public void forDaoPackage() {}
	
	// create point cut for getter method
	@Pointcut("execution(* com.arjunkumar.aopdemo.dao.*.get*(..))")
	public void getter() {}
	
	// create point cut for setter method
	@Pointcut("execution(* com.arjunkumar.aopdemo.dao.*.set*(..))")
	public void setter() {}
	
	// create pointcut for include package and exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	public void forDaoPackageNoGetterSetter() {}
	
}
