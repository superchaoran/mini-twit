package com.twit.account.service;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	@SuppressWarnings("unused")
	private CsrfTokenRepository csrfTokenRepository() 
	{ 
	    HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository(); 
	    repository.setSessionAttributeName("_csrf");
	    return repository; 
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	    http.csrf().csrfTokenRepository(csrfTokenRepository());
	}
}