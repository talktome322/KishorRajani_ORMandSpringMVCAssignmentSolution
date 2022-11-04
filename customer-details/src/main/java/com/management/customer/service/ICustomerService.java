package com.management.customer.service;

import java.util.List;

import com.management.customer.entity.Customer;

public interface ICustomerService {
	public Customer addCustomer(Customer customer);
	public List<Customer> displayCustomer();
	public Customer findCustomer(int customerId);
	public boolean deleteCustomer(int customerId);
	public boolean updateCustomer(int customerId, String firstName, String lastName, String email);
}
