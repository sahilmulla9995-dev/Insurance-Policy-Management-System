package com.app.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Policy {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long policyId;
	
	@NotBlank
	private String policyNumber;
	
	@NotBlank
	private String policyType;
	
	@NotNull
	@Positive
	private Double coverageAmount;
	
	@NotNull
	private LocalDate startDate;
	@NotNull
	private LocalDate endDate;
	private String policyStatus;
	private Long agentId;
	private String agentName;
	private String agentBranch;
	private String agentContact;
	
	@OneToOne
	private Customer customer;
	
	@OneToMany(mappedBy = "policy")
	@JsonIgnore
	private List<PremiumPayment> payments;
	
	@OneToMany(mappedBy = "policy")
	@JsonIgnore
	private List<Claim> claims;

}
