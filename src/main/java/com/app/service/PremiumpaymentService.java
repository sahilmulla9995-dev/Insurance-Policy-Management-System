package com.app.service;

import java.util.List;

import com.app.entity.PremiumPayment;

public interface PremiumpaymentService {
	
	PremiumPayment addPayment(PremiumPayment payments);
	
	PremiumPayment getPaymentById(Long paymentId);
	
	List<PremiumPayment> getAllPayments();
	
	PremiumPayment updatePayment(Long paymentId , PremiumPayment payment);
	
	List<PremiumPayment> getPaymentsByPolicyId(Long policyId);
	
	void deletePayment(Long paymentId);

}
