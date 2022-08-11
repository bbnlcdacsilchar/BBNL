package com.bbnl.service;

import org.springframework.stereotype.Service;

import com.bbnl.entity.PasswordResetToken;
import com.bbnl.entity.User;
import com.bbnl.entity.VerificationToken;
import com.bbnl.exception.EmailExistsException;

@Service
public interface IUserService {
	
	 User findUserByEmail(final String email);
	// User findByToken(String token);
	
	User registerNewUser(User user) throws EmailExistsException;
	
	VerificationToken getVerificationToken(String token);
	
	void createVerificationTokenForUser(User user, String token);
	void createPasswordResetTokenForUser(User user, String token);

    PasswordResetToken getPasswordResetToken(String token);

    void changeUserPassword(User user, String password);
    void saveRegisteredUser(User user);


	void save(User user);
}
