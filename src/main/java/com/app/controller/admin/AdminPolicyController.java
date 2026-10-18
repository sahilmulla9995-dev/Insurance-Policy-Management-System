package com.app.controller.admin;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Policy;
import com.app.service.PolicyService;

@RestController
@RequestMapping("/api/admin/policies")
public class AdminPolicyController {
	
	private final PolicyService policyService;
	
	public AdminPolicyController(PolicyService policyService, PolicyService policyService2)
	{
		this.policyService = policyService;
		
	}
	
	@PostMapping
	public Policy cretaePolicy(@RequestBody Policy policy)
	{
		return policyService.addPolicy(policy);
	}
	
	@GetMapping
	public List<Policy> getAlPolicies()
	{
		return policyService.getAllPolicies();
	}
	
	@GetMapping("/{policyId}")
	public Policy getPolicyById(@PathVariable Long policyId) {
		
		return policyService.getPolicyById(policyId);
	}
	
	@PutMapping("/{policyId}")
	public Policy updatePolicy(@PathVariable Long policyId , @RequestBody Policy policy) {
		
		return policyService.updatePolicy(policyId, policy);
		
		
	}
	
	@DeleteMapping("/{policyId}")
	public String deletePolicy(@PathVariable Long policyId) {
		
		policyService.deletePolicy(policyId);
		
		return "Policy deleted succcessfully..!";
		
		
	}
	

}
