package com.app.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Customer;
import com.app.service.CustomerService;

@RestController
@RequestMapping("/api/customer/customers")
public class CustomerController {
	
	private final CustomerService customerService;
	
	public CustomerController(CustomerService customerService, CustomerService customerService2)
	{
		this.customerService = customerService;
		
	}
	
	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable Long customerId)
	{
		
		return customerService.getCustomerById(customerId);
		
	}

}
