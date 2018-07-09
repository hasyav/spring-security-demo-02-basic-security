package com.love2code.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
//over ride methods
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter{

	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
//	add our users for in memory aythentication - creates a default login form 
		UserBuilder user = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
		.withUser(user.username("john").password("test123").roles("EMPLOYEE"))
				.withUser(user.username("Mary").password("test123").roles("MANAGER"))
						.withUser(user.username("suzan").password("test123").roles("ADMIN"));
	}
	

}
