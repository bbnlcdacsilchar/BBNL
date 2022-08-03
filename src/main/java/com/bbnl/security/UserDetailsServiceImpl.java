package com.bbnl.security;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.bbnl.entity.User;
import com.bbnl.repository.UserRepository;

public class UserDetailsServiceImpl implements  UserDetailsService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUserId(username);
		if (user==null) {
			throw new UsernameNotFoundException("Could not find user with username: "+ username);
		}
	
	return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),user.isStatus(),true,true,true, getAuthorities("ROLE_USER"));
	}


	public Collection<? extends GrantedAuthority> getAuthorities(String role) {
		return Arrays.asList(new SimpleGrantedAuthority(role));
	}
}