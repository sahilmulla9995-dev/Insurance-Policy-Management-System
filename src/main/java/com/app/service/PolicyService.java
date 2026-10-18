package com.app.service;

import java.util.List;

import com.app.entity.Policy;

public interface PolicyService {
	
	Policy addPolicy(Policy policy);
	
	Policy getPolicyById(Long policyId);
	
	List<Policy> getAllPolicies();
	
	Policy updatePolicy(Long policyId , Policy policy);
	
	Policy getPolicyByCustomerId(Long customerId);
	
	void deletePolicy(Long policyId);

}
