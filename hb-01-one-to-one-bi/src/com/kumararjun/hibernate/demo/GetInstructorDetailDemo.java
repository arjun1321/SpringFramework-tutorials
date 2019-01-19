package com.kumararjun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumararjun.hibernate.demo.entity.Instructor;
import com.kumararjun.hibernate.demo.entity.InstructorDetail;
import com.kumararjun.hibernate.demo.entity.Student;

public class GetInstructorDetailDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// Start a transaction 
			session.beginTransaction();
			
			// get the instructorDetail object
			int theId = 2;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, theId);
			
			// print the instructorDetail object
			System.out.println("instructor details: " + instructorDetail);
			
			// print the instructor object
			System.out.println("associated instructor: " + instructorDetail.getInstructor());
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			// close the session
			session.close();
			factory.close();
		} 

	}

}
