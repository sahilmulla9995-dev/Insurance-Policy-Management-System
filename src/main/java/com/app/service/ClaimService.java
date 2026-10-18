package com.app.service;

import java.util.List;

import com.app.entity.Claim;

public interface ClaimService {
	
	Claim addClaim(Claim claim);
	
	Claim getClaimById(Long claimId);
	
	List<Claim> getAllClaims();
	
	Claim updateClaim(Long claimId , Claim claim);
	
	Claim updateClaimStatus(Long claimId, Claim claim);
	
	List<Claim> getClaimsByPolicyId(Long policyId);
	
	void deteleClaim(Long claimId);

}
