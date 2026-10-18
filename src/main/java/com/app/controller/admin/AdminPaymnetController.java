package com.app.controller.admin;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.PremiumPayment;
import com.app.service.PremiumpaymentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/admin/payments")
public class AdminPaymnetController {
	
	private final PremiumpaymentService premiumpaymentService;
	
	public AdminPaymnetController(PremiumpaymentService premiumpaymentService, PremiumpaymentService premiumpaymentService2) {
		this.premiumpaymentService = premiumpaymentService;
	}
	
	@GetMapping
	public List<PremiumPayment> getAllPayments(){
		
		return premiumpaymentService.getAllPayments();

	}
	
	@PutMapping("/{paymentId}")
	public PremiumPayment updatePayment(@PathVariable Long paymentId ,@Valid @RequestBody PremiumPayment payment) {
		return premiumpaymentService.updatePayment(paymentId, payment);	
	}
	
	@DeleteMapping("/{paymentId}")
	public String deletePayment(@PathVariable Long paymentId) {
		
		premiumpaymentService.deletePayment(paymentId);
		
		return "Payment delete successfully...!";
		
		
	}

}
