package com.bbnl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbnl.entity.VerificationToken;



public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
	VerificationToken findByToken(String token);
}