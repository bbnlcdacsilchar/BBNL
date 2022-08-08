package com.bbnl.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbnl.entity.PasswordResetToken;
import com.bbnl.entity.User;
import com.bbnl.entity.VerificationToken;
import com.bbnl.exception.EmailExistsException;
import com.bbnl.repository.UserRepository;
import com.bbnl.repository.PasswordResetTokenRepository;
import com.bbnl.repository.VerificationTokenRepository;

@Service
@Transactional
public class UserService implements IUserService {
//================================================================================	
	public static final int MAX_FAILED_ATTEMPT = 3;
	public static final long LOCK_TIME_DURATION = 2 * 60 * 1000;
//=================================================================================	
	
	private UserRepository repo;
	
	
	
	public UserService(UserRepository repo) {

		this.repo = repo;
	}

	@Autowired
	    private PasswordResetTokenRepository passwordTokenRepository;
	
	 @Autowired
	    private VerificationTokenRepository verificationTokenRepository;
	
	 @Autowired
	    private PasswordEncoder passwordEncoder;
	 
	 private boolean emailExist(final String email) {
	        final User user = repo.findByEmail(email);
	        return user != null;
	    }
	
	public List<User> listAllUser() {
		return repo.findAll();
	}
	
	public User saveUser(User user) {
		return repo.save(user);
	}
	
	public void deleteUser(String id) {
		repo.deleteById(id);
	}

	@Override
	public User findUserByEmail(String email) {
		
		System.out.println("override "+ email);
		return repo.findByEmail(email);
	}

	@Override
	public User registerNewUser(User user) throws EmailExistsException {
		if (emailExist(user.getEmail())) {
            throw new EmailExistsException("There is an account with that email address: " + user.getEmail());
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repo.save(user);
}
	

	

	@Override
	public VerificationToken getVerificationToken(String token) {
		System.out.println("token at override"+token);
		 return verificationTokenRepository.findByToken(token);
	}

	@Override
	public void createVerificationTokenForUser(User user, String token) {
		 final VerificationToken myToken = new VerificationToken(token, user);
	        verificationTokenRepository.save(myToken);
		
	}

	@Override
	public void createPasswordResetTokenForUser(User user, String token) {
		final PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordTokenRepository.save(myToken);
		
	}

	@Override
	public void changeUserPassword(User user, String password) {
		user.setPassword(passwordEncoder.encode(password));
        repo.save(user);
		
	}

	@Override
	public void saveRegisteredUser(User user) {
		 repo.save(user);
		
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PasswordResetToken getPasswordResetToken(String token) {
		return passwordTokenRepository.findByToken(token);
	}

	/*
	 * @Override public User findByToken(String token) {
	 * System.out.println("token at override"+token); return
	 * repo.findByToken(token); }
	 */
//===============================================================================================================================
	
	public void increaseFailedAttempt(User user) {
		long newUnsuccessfulAttempt = user.getUnsuccessfulAttempt() + 1;
		repo.updateUnsuccessfulAttempt(newUnsuccessfulAttempt, user.getEmail());
	}

	public void lock(User user) {
		user.setAccountNonLocked(false);
		user.setLockTime(new Date());
		user.setStatus(false);
		repo.save(user);
	}
	
	public boolean unlock(User user) {
		long lockTimeInMillisec = user.getLockTime().getTime();
		long currentTimeInMillisec = System.currentTimeMillis();
		
		if(lockTimeInMillisec + LOCK_TIME_DURATION < currentTimeInMillisec) {
			user.setAccountNonLocked(true);
			user.setLockTime(null);
			user.setUnsuccessfulAttempt(0);
			user.setStatus(true);
			repo.save(user);
			return true;
		}
		return false;
		
	}

	public void resetUnsuccessfulAttempts(String email) {
		repo.updateUnsuccessfulAttempt(0, email);
//		User user = repo.findByEmail(email);
//		user.setUnsuccessfulAttempt(0);
//		return repo.save(user);
		
	}
	
	//User Management Service
	
		public User getUserById(String id) {
			Optional<User> optional = repo.findById(id);

			if (optional.isPresent()) {
				return optional.get();
			} else {
				throw new RuntimeException("User not found of id " + id);
			}
		}

		public void deleteUserById(String id) {
			repo.deleteById(id);
		}
}
