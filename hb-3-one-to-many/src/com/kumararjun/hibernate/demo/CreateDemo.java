package com.kumararjun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumararjun.hibernate.demo.entity.Instructor;
import com.kumararjun.hibernate.demo.entity.InstructorDetail;
import com.kumararjun.hibernate.demo.entity.Student;

public class CreateDemo {

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
			// create the object 
			Instructor instructor = new Instructor("Arjun", "Kumar", "abc@mail.com");
			InstructorDetail instructorDetail = new InstructorDetail("http://youtube.com", "love to code");
			
			// associate the object
			instructor.setInstructorDetail(instructorDetail);
			
			// Start a transaction 
			session.beginTransaction();
			
			// save the instructor
			// This will also save instructorDetail object because of CasecadeType ALL
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		} 

	}

}
