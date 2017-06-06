package com.satansk.summer.site.rest.auth;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.satansk.summer.config.annotation.RestEndpoint;

@RestEndpoint
@RequestMapping(
		value = "auth",
		produces = "application/json; charset=UTF-8"
		)
public class UserAuth
{
	private static final Logger logger = LogManager.getLogger(UserAuth.class);
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Void> register(@RequestBody(required = true) UserAuth userAuth)
	{
		logger.info(userAuth);
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public void login(@RequestBody(required = true) UserAuth userAuth)
	{
		
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public void logout()
	{
		
	}
}
