package com.kumararjun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumararjun.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// Use the session object to save java object
			
			// Create a student object
			System.out.println("Creating a new student object");
			Student student = new Student("Arjun", "Kumar", "developer.arjun1321@gmail.com");
			
			// Start a transaction 
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(student);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		} 

	}

}
