package com.kumararjun.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kumararjun.hibernate.demo.entity.Student;

public class QueryStudentDemo {

	public static void main(String[] args) {
		
		// Create Session Factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// Create session
		Session session = factory.getCurrentSession();
		
		try {
			
			// Start a transaction 
			session.beginTransaction();

			// Query the students
			List<Student> students = session.createQuery("from Student").getResultList();
			
			// Display the students
			displayStudents(students);
			
			// Query student where lastName = kumar
			students = session.createQuery("from Student s where s.lastName='kumar'").getResultList();
			// Display students
			System.out.println("displaying students who have last name as kumar");
			displayStudents(students);
			
			// query student where last name is kumar and first name = Arjun
			students = session.createQuery("from Student s where s.lastName='kumar' AND s.firstName='Arjun'").getResultList();
			
			System.out.println("\ndisplaying students where lastname=kumar and firstname = arjun");
			displayStudents(students);
			
			// query student where email like %gmail.com
			students = session.createQuery("from Student s where s.email like '%gmail.com'").getResultList();
			
			System.out.println("\ndisplaying students where email ends with gmail.com");
			displayStudents(students);
			
			// commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		} 

	}

	private static void displayStudents(List<Student> students) {
		for(Student s: students) {
			System.out.println(s);
		}
	}

}
