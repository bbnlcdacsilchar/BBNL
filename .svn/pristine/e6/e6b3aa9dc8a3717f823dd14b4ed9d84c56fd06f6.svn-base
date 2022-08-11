package com.bbnl.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bbnl.entity.PasswordResetToken;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    PasswordResetToken findByToken(String token);

}
