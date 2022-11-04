package com.management.customer.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.customer.dao.ICustomerDao;
import com.management.customer.entity.Customer;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerDao customerDao;

	@Override
	public Customer addCustomer(Customer customer) {
		return customerDao.addCustomerRecord(customer);
	}

	@Override
	public List<Customer> displayCustomer() {
		return customerDao.displayCustomerRecord();
	}

	@Override
	public Customer findCustomer(int customerId) {
		return customerDao.findCustomerRecord(customerId);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		return customerDao.deleteCustomerRecord(customerId);
	}

	@Override
	public boolean updateCustomer(int customerId, String firstName, String lastName, String email) {
		return customerDao.updateCustomerRecord(customerId,firstName,lastName,email);
	}

}
