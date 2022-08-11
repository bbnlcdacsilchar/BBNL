package com.bbnl.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.bbnl.entity.User;
import com.bbnl.security.CustomUserDetails;
import com.bbnl.service.UserService;

 
@Component
public class CustomLoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
	
	
 
    @Autowired
    private UserService userService;
     
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        CustomUserDetails userDetails =  (CustomUserDetails) authentication.getPrincipal();
        User user = userDetails.getUser();
         
        if (user.getUnsuccessfulAttempt() > 0) {
            userService.resetUnsuccessfulAttempts(user.getEmail());
        }
       
        super.onAuthenticationSuccess(request, response, authentication);
    }
     
}