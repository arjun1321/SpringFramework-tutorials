package com.kumararjun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumararjun.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {
	
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
			
			// Create 3 student object
			System.out.println("Creating a new student object");
			Student student1 = new Student("Anuj", "Kumar", "anuj@gmail.com");
			Student student2 = new Student("Roshan", "Kumar", "roshan@gmail.com");
			Student student3 = new Student("Rohit", "Kumar", "rohit@gmail.com");
			
			// Start a transaction 
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(student1);
			session.save(student2);
			session.save(student3);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		} 
	}
}
