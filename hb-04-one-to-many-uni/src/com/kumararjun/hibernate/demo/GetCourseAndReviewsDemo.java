package com.kumararjun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumararjun.hibernate.demo.entity.Course;
import com.kumararjun.hibernate.demo.entity.Instructor;
import com.kumararjun.hibernate.demo.entity.InstructorDetail;
import com.kumararjun.hibernate.demo.entity.Review;
import com.kumararjun.hibernate.demo.entity.Student;

public class GetCourseAndReviewsDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			// Start a transaction 
			session.beginTransaction();
			
			// get the course
			int theId = 10;
			Course course = session.get(Course.class, theId);
			
			// print the course
			System.out.println(course);
			
			// print the course reviews
			System.out.println(course.getReviews());
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		} 

	}

}
