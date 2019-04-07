package com.arjunkumar.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.arjunkumar.aopdemo.dao.AccountDAO;
import com.arjunkumar.aopdemo.dao.MembershipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		
		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		// get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
		
		// get membership bean from spring container
		MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);
		
		// call the business method
		Account theAccount = new Account();
		theAccountDAO.addAccount(theAccount, true);
		theAccountDAO.doWork();
		
		// calling the  getter/setter method
		theAccountDAO.setName("foobar");
		theAccountDAO.setServiceCode("silver");
		
		String name = theAccountDAO.getName();
		String code = theAccountDAO.getServiceCode();
		
		// call the membership business method
		theMembershipDAO.addSillyMember();
		theMembershipDAO.goToSleep();
		
		
		// close the context
		context.close();
	}

}
