package com.kumararjun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumararjun.hibernate.demo.entity.Course;
import com.kumararjun.hibernate.demo.entity.Instructor;
import com.kumararjun.hibernate.demo.entity.InstructorDetail;
import com.kumararjun.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// Start a transaction 
			session.beginTransaction();
			
			// get the instructor from db
			int theId = 1;
			Instructor instructor = session.get(Instructor.class, theId);
			
			// create some courses
			Course course1 = new Course("Air Guitar - The Ultimate Guide");
			Course course2 = new Course("The PinBall Masterclass");
			
			// add courses to instructor
			instructor.add(course1);
			instructor.add(course2);
			
			// save the courses
			session.save(course1);
			session.save(course2);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		} 

	}

}
