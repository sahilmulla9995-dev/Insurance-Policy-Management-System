package com.app.controller.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Claim;
import com.app.entity.Policy;
import com.app.service.ClaimService;
import com.app.service.PolicyService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer")
public class CustomerClaimController {
	
	private final ClaimService claimService;
	
	private final PolicyService policyService;
	
	public CustomerClaimController(ClaimService claimService, PolicyService policyService, PolicyService policyService2) {
		this.claimService = claimService;
		this.policyService = policyService;
		
	}
	
	@PostMapping("/policies/{policyId}/claims")
	public Claim createClaim(@PathVariable Long policyId ,@Valid @RequestBody Claim claim)
	{
		
		Policy policy = policyService.getPolicyById(policyId);
		
		claim.setPolicy(policy);
		
		return claimService.addClaim(claim);
		
	}
	
	@GetMapping("/policies/{policyId}/claims")
	public List<Claim> getClaimsByPolicyId(@PathVariable Long policyId){
		
		return claimService.getClaimsByPolicyId(policyId);
		
	}
	
	@PutMapping("/claims/{claimId}")
	public Claim updateClaim(@PathVariable Long claimId ,@Valid @RequestBody Claim claim) {
		
		return claimService.updateClaim(claimId, claim);
		
	}

}
