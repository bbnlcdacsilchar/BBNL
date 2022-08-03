package com.bbnl.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.bbnl.handler.CustomLoginFailureHandler;
import com.bbnl.handler.CustomLoginSuccessHandler;
import com.bbnl.handler.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
@SuppressWarnings("deprecation")
public class MyConfig extends WebSecurityConfigurerAdapter {
	
//	@Autowired
//	private CustomLoginFailureHandler failureHandler;
	
	@Bean
	CustomLoginFailureHandler failureHandler() {
		return new CustomLoginFailureHandler();
	}
	
//	@Autowired
//	private LoginSuccessHandler successHandler;
	
	@Bean
	CustomLoginSuccessHandler successHandler() {
		return new CustomLoginSuccessHandler();
	}
	
	@Bean
	LoginSuccessHandler successHandlers() {
		return new LoginSuccessHandler();
	}
	
	@Bean
	 UserDetailsService getUserDetailsService() {
		return new UserDetailsServiceImpl();
	}

    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
	 DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
		daoAuthenticationProvider.setUserDetailsService(this.getUserDetailsService());
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
		
		return daoAuthenticationProvider;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/", "/registrationConfirm*","/forgotPassword*",
				"/user/resetPassword*",
	              "/user/changePassword*",
	              "/user/savePassword*").permitAll()
		
		.antMatchers("/user/**").hasRole("USER")
		.antMatchers("/customer/**").hasRole("CUSTOMER")
		.antMatchers("/ministerial/**").hasRole("MINISTERIAL")
		.antMatchers("/provider/**").hasRole("PROVIDER")
		.and()
		.formLogin()
			.loginPage("/signin")
			.failureHandler(failureHandler())
			.successHandler(successHandler())
			.successHandler(successHandlers())
		.and()
		.csrf().disable()
		;
	}
	
}
