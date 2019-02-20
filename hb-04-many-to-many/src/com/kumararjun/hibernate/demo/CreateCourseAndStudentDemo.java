package com.kumararjun.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumararjun.hibernate.demo.entity.Course;
import com.kumararjun.hibernate.demo.entity.Instructor;
import com.kumararjun.hibernate.demo.entity.InstructorDetail;
import com.kumararjun.hibernate.demo.entity.Review;
import com.kumararjun.hibernate.demo.entity.Student;

public class CreateCourseAndStudentDemo {

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
			
			// create a course
			Course tempCourse = new Course("Pacman - How to score one million points");
			
			
			// Save the course
			System.out.println("\nSaving the course...");
			session.save(tempCourse);
			System.out.println("Saved the course: " + tempCourse);
			
			// Create the students
			Student student1 = new Student("Rahul", "Kumar", "abc@gmail.com");
			Student student2 = new Student("Anuj", "Gupta", "anuj@gmail.com");
			
			// add students to the course
			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);
			
			// save the students
			System.out.println("\nSaving students....");
			session.save(student1);
			session.save(student2);
			System.out.println("Saved students: " + tempCourse.getStudents());
			
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			session.close();
			factory.close();
		} 

	}

}
