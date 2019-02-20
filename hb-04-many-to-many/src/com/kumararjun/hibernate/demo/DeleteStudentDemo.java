package com.kumararjun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumararjun.hibernate.demo.entity.Course;
import com.kumararjun.hibernate.demo.entity.Instructor;
import com.kumararjun.hibernate.demo.entity.InstructorDetail;
import com.kumararjun.hibernate.demo.entity.Review;
import com.kumararjun.hibernate.demo.entity.Student;

public class DeleteStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			
			// Start a transaction 
			session.beginTransaction();
			
			// get a student from database
			int studentId = 2;
			Student theStudent = session.get(Student.class, studentId);
			
			System.out.println("\nLoaded student: " + theStudent);
			System.out.println("Courses: " + theStudent.getCourses());
			
			// delete student
			System.out.println("\nDeleting student: " + theStudent);
			session.delete(theStudent);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		} 

	}

}
