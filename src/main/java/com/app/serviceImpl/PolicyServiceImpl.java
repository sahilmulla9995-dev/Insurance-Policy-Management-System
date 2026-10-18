package com.app.serviceImpl;

import com.app.repository.PolicyRepository;
import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entity.Policy;
import com.app.exception.ResourceNotFoundException;
import com.app.service.PolicyService;

@Service
public class PolicyServiceImpl implements PolicyService{

	private final PolicyRepository policyRepository;

	PolicyServiceImpl(PolicyRepository policyRepository) {
		this.policyRepository = policyRepository;
	}

	@Override
	public Policy addPolicy(Policy policy) {

		return policyRepository.save(policy);
	}

	@Override
	public Policy getPolicyById(Long policyId) {

		return policyRepository.findById(policyId).orElseThrow(()-> new ResourceNotFoundException("policy not found with id: "+policyId));
	}

	@Override
	public List<Policy> getAllPolicies() {

		return policyRepository.findAll();
	}

	@Override
	public Policy updatePolicy(Long policyId, Policy policy) {

		Policy existingPolicy = policyRepository.findById(policyId).orElseThrow(()-> new ResourceNotFoundException("policy not found with id: "+policyId));
		
		if (existingPolicy !=null) {
			
			existingPolicy.setPolicyNumber(policy.getPolicyNumber());
			existingPolicy.setPolicyType(policy.getPolicyType());
			existingPolicy.setCoverageAmount(policy.getCoverageAmount());
			existingPolicy.setStartDate(policy.getStartDate());
			existingPolicy.setEndDate(policy.getEndDate());
			existingPolicy.setPolicyStatus(policy.getPolicyStatus());
			existingPolicy.setAgentId(policy.getAgentId());
			existingPolicy.setAgentName(policy.getAgentName());
			existingPolicy.setAgentBranch(policy.getAgentBranch());
			existingPolicy.setAgentContact(policy.getAgentContact());
			existingPolicy.setCustomer(policy.getCustomer());
			
			return policyRepository.save(existingPolicy);
			
			
		}
	
	return null;
		
	}

	@Override
	public void deletePolicy(Long policyId) {
		
		if (!policyRepository.existsById(policyId)) {
			
			throw new ResourceNotFoundException("policy not found with id: "+policyId);
			
		}
		
	    policyRepository.deleteById(policyId);
	}

	@Override
	public Policy getPolicyByCustomerId(Long customerId) {

		List<Policy> policies = policyRepository.findAll();
		
		for(Policy policy : policies)
		{
			if (policy.getCustomer() !=null && policy.getCustomer().getCustomerId().equals(customerId)) {
				
				return policy;
				
			}
		}
		
		throw new ResourceNotFoundException("Policy not found for customer id: "+customerId);
	}

	

}
