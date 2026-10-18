package com.app.service;

import java.util.List;

import com.app.entity.Customer;

public interface CustomerService {
	
	Customer addCustomer(Customer customer);
	
	Customer getCustomerById(Long customerId);
	
	List<Customer> getAllCustomers();
	
	Customer updateCustomer(Long customerId , Customer customer);
	
	void deleteCutomer(Long customerId);

}
