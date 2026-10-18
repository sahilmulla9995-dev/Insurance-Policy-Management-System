package com.app.controller.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Policy;
import com.app.entity.PremiumPayment;
import com.app.service.PolicyService;
import com.app.service.PremiumpaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customer/policies")
public class CustomerPaymentController {
	
	private final PremiumpaymentService premiumpaymentService;
	private final PolicyService policyService ;
	
	public CustomerPaymentController(PremiumpaymentService premiumpaymentService, PolicyService policyService) {
		this.premiumpaymentService = premiumpaymentService;
		this.policyService = policyService;
		
	}
	
	@PostMapping("/{policyId}/payments")
	public PremiumPayment createPayment(
	        @PathVariable Long policyId,
	        @Valid @RequestBody PremiumPayment payment) {

	    Policy policy = policyService.getPolicyById(policyId);
	    payment.setPolicy(policy);

	    return premiumpaymentService.addPayment(payment);
	}
	
	@GetMapping("/{policyId}/payments")
	public List<PremiumPayment> getPaymentsByPolicyId(@PathVariable Long policyId){
		
		return premiumpaymentService.getPaymentsByPolicyId(policyId);
		
	}

}
