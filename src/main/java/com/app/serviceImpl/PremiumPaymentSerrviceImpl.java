package com.app.serviceImpl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.entity.Policy;
import com.app.entity.PremiumPayment;
import com.app.exception.ResourceNotFoundException;
import com.app.repository.PolicyRepository;
import com.app.repository.PremiumPaymentRepository;
import com.app.service.PremiumpaymentService;

@Service
public class PremiumPaymentSerrviceImpl implements PremiumpaymentService {
	
		private final PremiumPaymentRepository premiumPaymentRepository;
		private final PolicyRepository policyRepository;
		
		public PremiumPaymentSerrviceImpl(PremiumPaymentRepository premiumPaymentRepository , PolicyRepository policyRepository, PolicyRepository policyRepository2)
		{
			this.premiumPaymentRepository = premiumPaymentRepository;
			this.policyRepository = policyRepository;
		}

	@Override
	public PremiumPayment addPayment(PremiumPayment payments) {

		return premiumPaymentRepository.save(payments);
	}

	@Override
	public PremiumPayment getPaymentById(Long paymentId) {

		return premiumPaymentRepository.findById(paymentId).orElseThrow(()-> new ResourceNotFoundException("payment not found with id: "+paymentId));
	}

	@Override
	public List<PremiumPayment> getAllPayments() {

		return premiumPaymentRepository.findAll();
	}

	@Override
	public PremiumPayment updatePayment(Long paymentId, PremiumPayment payment) {

	    PremiumPayment existingPayment =
	            premiumPaymentRepository.findById(paymentId)
	            .orElseThrow(() ->
	                new ResourceNotFoundException(
	                    "Payment not found with id: " + paymentId
	                )
	            );

	    existingPayment.setAmount(payment.getAmount());
	    existingPayment.setPaymentDate(payment.getPaymentDate());
	    existingPayment.setPaymentMode(payment.getPaymentMode());
	    existingPayment.setTransactionId(payment.getTransactionId());
	    existingPayment.setPaymentStatus(payment.getPaymentStatus());

	    if (payment.getPolicy() != null) {

	        Long policyId = payment.getPolicy().getPolicyId();

	        Policy policy = policyRepository.findById(policyId).orElseThrow(() ->new ResourceNotFoundException( "Policy not found with id: " + policyId) );

	        existingPayment.setPolicy(policy);
	    }

	    return premiumPaymentRepository.save(existingPayment);
	}

	@Override
	public void deletePayment(Long paymentId) {

		if (! premiumPaymentRepository.existsById(paymentId)) {
			
			throw new ResourceNotFoundException("Payment not found with id: "+paymentId);
		}
		
		premiumPaymentRepository.deleteById(paymentId);
		
	}

	@Override
	public List<PremiumPayment> getPaymentsByPolicyId(Long policyId) {

		List<PremiumPayment> payments = premiumPaymentRepository.findAll();
		
		List<PremiumPayment> policyPayments = payments.stream()
	            .filter(payment -> payment.getPolicy() != null
	                    && payment.getPolicy().getPolicyId().equals(policyId))
	            .toList();
		
		if (policyPayments.isEmpty()) {
			
			throw new ResourceNotFoundException("No payments found for policy id:"+policyId);
			
		}
		
		return policyPayments;
		
	}
	

}
