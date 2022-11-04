package com.management.customer.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.management.customer.entity.Customer;

@Repository
public class CustomerDaoImpl implements ICustomerDao {

	private SessionFactory sessionFactory;
	private Session session;

	public CustomerDaoImpl(SessionFactory sessionFactory) {
		System.out.println("Connecting to database");

		this.sessionFactory = sessionFactory;
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	@Override
	public Customer addCustomerRecord(Customer customer) {
		Transaction txn=session.beginTransaction();
		session.save(customer);
		System.out.println("Customer info saved");
		txn.commit();
		return customer;
	}

	@Override
	public List<Customer> displayCustomerRecord() {
		return session.createQuery("Select c from Customer c",Customer.class).getResultList();
	}

	@Override
	public Customer findCustomerRecord(int customerId) {
		return session.find(Customer.class, new Integer(customerId));
	}

	@Override
	public boolean deleteCustomerRecord(int customerId) {
		Customer retrievedObject=findCustomerRecord(customerId);

		session.getTransaction().begin();
		System.out.println("Deleted customer with the following email id: "+retrievedObject.getEmail());
		session.delete(retrievedObject);

		session.getTransaction().commit();

		if(retrievedObject!=null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean updateCustomerRecord(int customerId, String firstName, String lastName, String email) {
		Customer retrievedObject=findCustomerRecord(customerId);
		session.getTransaction().begin();
		retrievedObject.setFirstName(firstName);
		retrievedObject.setLastName(lastName);
		retrievedObject.setEmail(email);
		session.update(retrievedObject);
		session.getTransaction().commit();

		if(retrievedObject!=null) {
			return true;
		}
		return false;
	}

}
