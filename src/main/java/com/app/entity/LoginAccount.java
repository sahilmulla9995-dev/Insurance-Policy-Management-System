package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LoginAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long loginAccountId;
	private String username;
	private String password;
	private String role;
	private Boolean active;
	
	@OneToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;

}
