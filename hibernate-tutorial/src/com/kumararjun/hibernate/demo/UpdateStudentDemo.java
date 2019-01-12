package com.kumararjun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumararjun.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			int studentId = 2;
			
			// Getting a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Retrieve student based on the Id: primary key
			System.out.println("\nGettinng student with id: " + studentId);
			Student myStudent = session.get(Student.class,studentId);
			
			System.out.println("Updating student.....");
			myStudent.setFirstName("Sachin");
			
			// Commit the transaction
			session.getTransaction().commit();
			
			
			// new code for updating email for all students
			
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Update emails for all students");
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		} 

	}

}
