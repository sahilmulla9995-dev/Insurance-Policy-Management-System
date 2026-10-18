package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Claim;

public interface ClaimRepository extends JpaRepository<Claim, Long> {

}
