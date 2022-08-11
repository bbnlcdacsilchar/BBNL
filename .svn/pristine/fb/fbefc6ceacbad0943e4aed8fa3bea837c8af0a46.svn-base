package com.bbnl.handler;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.bbnl.entity.User;
import com.bbnl.service.UserService;



@Component
public class CustomLoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
	

	@Autowired
	UserService userService;
	
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String email = request.getParameter("username");
		User user =  userService.findUserByEmail(email);
		
		if(user != null) {
			if(user.isStatus() && user.isAccountNonLocked()) {
				if(user.getUnsuccessfulAttempt() < UserService.MAX_FAILED_ATTEMPT - 1) {
					userService.increaseFailedAttempt(user);
				}
				else {
					userService.lock(user);
					exception = new LockedException("Your account has been locked due to 3 failed attempt."
							+"   your account is unlock after 24 hours");
				}
				}else if(!user.isAccountNonLocked()) {
					if(userService.unlock(user)) {
					exception = new LockedException("Your account has been unlocked. Please try to login again");
				}
			}
			System.out.println("User Failed to login: "+ email);
		}
		
		
		super.setDefaultFailureUrl("/signin?error");
		super.onAuthenticationFailure(request, response, exception);
	}

}
