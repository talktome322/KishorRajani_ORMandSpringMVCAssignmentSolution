package com.management.customer.dao;

import java.util.List;

import com.management.customer.entity.Customer;

public interface ICustomerDao {
	public Customer addCustomerRecord(Customer customer);
	public List<Customer> displayCustomerRecord();
	public Customer findCustomerRecord(int customerId);
	public boolean deleteCustomerRecord(int customerId);
	public boolean updateCustomerRecord(int customerId, String firstName, String lastName, String email);
}
