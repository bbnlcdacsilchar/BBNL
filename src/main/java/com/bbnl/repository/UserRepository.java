package com.bbnl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bbnl.entity.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<User, String>{
	
	@Query("select u from User u where u.email = :id")
	public User getUserByUserId(@Param("id") String id);
	
	
	// User findByToken(String token);
	
	@Query("SELECT u FROM User u WHERE u.email= :email")
	 public User findByEmail(@Param("email") String username);
	
	 @Query("UPDATE User u SET u.unsuccessfulAttempt = ?1 WHERE u.email = ?2")
	 @Modifying
	 @Transactional
	 public void updateUnsuccessfulAttempt(long failedAttempt, String email);
}
