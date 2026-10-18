package com.app.controller.admin;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Claim;
import com.app.service.ClaimService;

@RestController
@RequestMapping("/api/admin/claims")
public class AdminClaimController {
	
	private final ClaimService claimService;
	
	public AdminClaimController(ClaimService claimService, ClaimService claimService2) {
		
		this.claimService = claimService;
	}
	
	@GetMapping
	public List<Claim> getAllClaims(){
		
		return claimService.getAllClaims();
		
	}
	
	@PutMapping("/{claimId}/status")
	public Claim updateClaimStatus(
	        @PathVariable Long claimId,
	        @RequestBody Claim claim) {

	    return claimService.updateClaimStatus(claimId, claim);
	}
	
	@DeleteMapping("/{claimId}")
	public String deleteClaim(@PathVariable Long claimId) {
		
		claimService.deteleClaim(claimId);
		return "Claim deleted successfully...!";
		
	}

}
