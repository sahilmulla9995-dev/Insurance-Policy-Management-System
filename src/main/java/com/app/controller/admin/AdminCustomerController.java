package com.app.controller.admin;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Customer;
import com.app.entity.LoginAccount;
import com.app.service.CustomerService;
import com.app.service.LoginAccountService;

@RestController
@RequestMapping("/api/admin/customers")
public class AdminCustomerController {
	
	private final CustomerService customerService;
	
	private final LoginAccountService loginAccountService;
	
	public AdminCustomerController(CustomerService customerService, LoginAccountService loginAccountService, LoginAccountService loginAccountService2 )
	{
		this.customerService = customerService;
		this.loginAccountService = loginAccountService;
		
	}
	
	@PostMapping("/{customerId}/login-account")
	public LoginAccount createLoginAccount(
	        @PathVariable Long customerId,
	        @RequestBody LoginAccount loginAccount) {

	    return loginAccountService.createLoginAccount(
	            customerId,
	            loginAccount);
	}
	
	@PostMapping
	public Customer createCustomer(@RequestBody Customer customer) {
		
		return customerService.addCustomer(customer);
		
	}
	
	@GetMapping
	public List<Customer> getAllCustomers()
	{
		
		return customerService.getAllCustomers();
		
	}
	
	@GetMapping("/{customerId}")
	public Customer getCustomerById(@PathVariable Long customerId)
	{
		
		return customerService.getCustomerById(customerId);
		
	}
	
	@PutMapping("/{customerId}")
	public Customer updateCustomer(@PathVariable Long customerId , @RequestBody Customer customer) {
		
		return customerService.updateCustomer(customerId, customer);
	}
	
	public String deleteCustomer(@PathVariable Long customerrId)
	{
		
		customerService.deleteCutomer(customerrId);
		
		return "Customer deleted successfully...!";
		
	}
}




