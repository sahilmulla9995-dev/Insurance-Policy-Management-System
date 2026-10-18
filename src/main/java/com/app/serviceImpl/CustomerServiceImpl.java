package com.app.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entity.Customer;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.CustomerRepository;
import com.app.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	private final CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository)
	{
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(Long customerId) {

		return customerRepository.findById(customerId).orElseThrow(() -> new ResourceNotFoundException("Customer not found With id: "+customerId));
	}

	@Override
	public List<Customer> getAllCustomers() {

		return customerRepository.findAll();
	}

	@Override
	public Customer updateCustomer(Long customerId, Customer customer) {

		Customer existingCustomer = customerRepository.findById(customerId).orElseThrow(()-> new ResourceNotFoundException("Customer not found id: "+customerId));
		
			if (existingCustomer !=null) {
				
				existingCustomer.setName(customer.getName());
				existingCustomer.setEmail(customer.getEmail());
				existingCustomer.setPhoneNumber(customer.getPhoneNumber());
				existingCustomer.setAge(customer.getAge());
				existingCustomer.setGender(customer.getGender());
				
				return customerRepository.save(existingCustomer);
				
			}
		
		return null;
	}

	@Override
	public void deleteCutomer(Long customerId) {

		if (! customerRepository.existsById(customerId)) {
			
			throw new ResourceNotFoundException("Customer not found id: "+customerId);
		}
		
		customerRepository.deleteById(customerId);
	}

}
