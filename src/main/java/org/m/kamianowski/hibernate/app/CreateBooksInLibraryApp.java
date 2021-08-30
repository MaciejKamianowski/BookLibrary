package org.m.kamianowski.hibernate.app;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.m.kamianowski.hibernate.demo.entity.Student;
import org.m.kamianowski.hibernate.entity.Book;

public class CreateBooksInLibraryApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// create session factory
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Book.class)
				.buildSessionFactory();
		// create session
		Session session = factory.getCurrentSession();

		try {
			Book tempBook = new Book("The Linux Programming Interface", "Michael Kerrisk");
			// start a transaction
			session.beginTransaction();

			// save the object
			System.out.println("Saving student and the images");
			session.persist(tempBook);

			// commit the transaction
			session.getTransaction().commit();
			System.out.println("Done!");

		} finally {
			session.close();
			factory.close();
		}
	}

}
