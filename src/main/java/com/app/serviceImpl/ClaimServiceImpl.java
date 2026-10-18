package com.app.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entity.Claim;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.ClaimRepository;
import com.app.service.ClaimService;

@Service
public class ClaimServiceImpl implements ClaimService {

	private final ClaimRepository claimRepository;
	
	public ClaimServiceImpl(ClaimRepository claimRepository)
	{
		this.claimRepository = claimRepository;
		
	}
	
	@Override
	public Claim addClaim(Claim claim) {


		return claimRepository.save(claim);
	}

	@Override
	public Claim getClaimById(Long claimId) {

		return claimRepository.findById(claimId).orElseThrow(()-> new ResourceNotFoundException("claim not found with id: "+claimId));
	}

	@Override
	public List<Claim> getAllClaims() {

		return claimRepository.findAll();
	}

	@Override
	public Claim updateClaim(Long claimId, Claim claim) {

	    Claim existingClaim =
	            claimRepository.findById(claimId)
	            .orElseThrow(() ->
	                new ResourceNotFoundException(
	                    "Claim not found with id: " + claimId
	                )
	            );

	    existingClaim.setClaimAmount(claim.getClaimAmount());
	    existingClaim.setClaimDate(claim.getClaimDate());
	    existingClaim.setClaimStatus(claim.getClaimStatus());
	    existingClaim.setAccidentLocation(claim.getAccidentLocation());
	    existingClaim.setDescription(claim.getDescription());

	    if (claim.getPolicy() != null) {
	        existingClaim.setPolicy(claim.getPolicy());
	    }

	    return claimRepository.save(existingClaim);
	}
	
	@Override
	public Claim updateClaimStatus(Long claimId, Claim claim) {

	    Claim existingClaim =
	            claimRepository.findById(claimId)
	            .orElseThrow(() ->
	                new ResourceNotFoundException(
	                    "Claim not found with id: " + claimId
	                )
	            );

	    existingClaim.setClaimStatus(claim.getClaimStatus());

	    return claimRepository.save(existingClaim);
	}
	
	@Override
	public void deteleClaim(Long claimId) {

		if (! claimRepository.existsById(claimId)) {
			
			throw new ResourceNotFoundException("claim not found id: "+claimId);
		}
		
		claimRepository.deleteById(claimId);
		
	}

	@Override
	public List<Claim> getClaimsByPolicyId(Long policyId) {

		List<Claim> claims = claimRepository.findAll();
		
		List<Claim> policyClaims  =  claims.stream().filter(claim -> claim.getPolicy() != null && claim.getPolicy().getPolicyId().equals(policyId)).toList();
		
		if (policyClaims.isEmpty()) {
			
			throw new ResourceNotFoundException("No claims found for policy id: " +policyId);
		}
		
		return policyClaims;

	}
	 

}
