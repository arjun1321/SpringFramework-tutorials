package com.arjunkumar.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.arjunkumar.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLoginAspect {

	// Add related advices for logging
	
	// add a new advice for  @AfterReturning on the findAccounts method
	
	@AfterReturning(
			pointcut="execution(* com.arjunkumar.aopdemo.dao.AccountDAO.findAccounts(..))",
			returning="result"
			)
	public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint, List<Account> result) {
		
		// print out which method we are advising on
		String method = theJoinPoint.getSignature().toShortString();
		System.out.println("\n====> Executing @AfterReturning method: " + method);
		
		// print out results of the method call
		System.out.println("\n=====>>> result is: " + result);
		
		// lets postprocess the data
		
		
		// convert the account names to uppercase
		convertAccountNamesToUpperCase(result);
		
	}
	
	private void convertAccountNamesToUpperCase(List<Account> result) {
		// loop through accounts
		
		for( Account tempAccount: result) {
			// get the upper case version of name
			String theUpperCase = tempAccount.getName().toUpperCase();
			
			// update the name on the account
			tempAccount.setName(theUpperCase);
		}
		
		
	}

	@Before("com.arjunkumar.aopdemo.aspect.LuvAopExpression.forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
		
		System.out.println("\n=====>>> Exectuing @Before advice on addAccount()");
		
		// display the method signature
		MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
		
		System.out.println("Method: " + methodSig);
		
		// display tne  method arguments
		
		// get the args
		Object[] args = theJoinPoint.getArgs();
		
		// loop through args
		for(Object tempArg: args) {
			System.out.println(tempArg);
			
			if( tempArg instanceof Account) {
				// downcast and print account specific
				Account theAccount = (Account) tempArg;
				
				System.out.println("Account name: " + theAccount.getName());
				System.out.println("Account level: " + theAccount.getLevel());
			}
		}
		
	}
	

	
}