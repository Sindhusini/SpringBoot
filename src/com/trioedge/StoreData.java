package com.trioedge;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StoreData {
	public static void main(String[] args) {

		try {
			SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = factory.openSession();
			Transaction t = session.beginTransaction();

			Employee e1 = new Employee();

			Scanner sc = new Scanner(System.in);
			System.out.print("Enter your FirstName: ");
			String firstname = sc.nextLine();
			System.out.print("Enter your LastName: ");
			String lastname = sc.nextLine();
			System.out.println("FirstName is: " + firstname);
			System.out.println("LastName is: " + lastname);
			// e1.setId(108);
			e1.setFirstName(firstname);
			e1.setLastName(lastname);
			// transient state

			session.save(e1);// object associated with session and database is called persistent
			// e1.setLastName("sin");// we can replace it
			t.commit();

			// persistent state
			System.out.println("successfully saved");

			factory.close();
			session.close();// detached state(it is not associated with session and associated database )
		} catch (Exception e) {
			System.out.println(e);
		}
		
		// session.delete(); removed state(it is associated with session and not associated with DB)

	}
}
