package com.kumararjun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumararjun.hibernate.demo.entity.Student;

public class ReadStudentDemo {

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
			Student student = new Student("Rahul", "Kumar", "rahul@gmail.com");
			
			// Start a transaction 
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			System.out.println(student);
			session.save(student);
			
			// commit the transaction
			session.getTransaction().commit();
			
			// find out student's primary key
			System.out.println("Saved student generated Id: " + student.getId());
			
			// Getting a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Retrieve student based on the Id: primary key
			System.out.println("\nGettinng student with id: " + student.getId());
			Student myStudent = session.get(Student.class,student.getId());
			
			System.out.println("Get Complete: " + myStudent);
			
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		} 

	}

}
