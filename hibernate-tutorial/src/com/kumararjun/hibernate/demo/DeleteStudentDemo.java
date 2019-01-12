package com.kumararjun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumararjun.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

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
			
			// Delete student
			System.out.println("Deleting student: " + myStudent);
			//session.delete(myStudent);
			
			// Delete student with ID 4
			session.createQuery("delete from Student where id=4").executeUpdate();
			
			// Commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		} 

	}

}
