package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.PremiumPayment;

public interface PremiumPaymentRepository extends JpaRepository<PremiumPayment, Long> {

}
