package com.app.controller.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Policy;
import com.app.service.PolicyService;

@RestController
@RequestMapping("/api/customer/customers")
public class CustomerPolicyController {
	
	private final PolicyService policyService;
	
	public CustomerPolicyController(PolicyService policyService, PolicyService policyService2)
	{
		this.policyService = policyService;
		
	}
	
	@GetMapping("/{cuatomerId}/policy")
	public Policy getPolicyById(@PathVariable Long customerId)
	{
		return policyService.getPolicyByCustomerId(customerId);
	}

}
