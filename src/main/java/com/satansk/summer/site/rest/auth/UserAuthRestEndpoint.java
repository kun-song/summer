package com.satansk.summer.site.rest.auth;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.satansk.summer.config.annotation.RestEndpoint;
import com.satansk.summer.site.entity.mongo.UserInfo;
import com.satansk.summer.site.service.UserManagerService;

@RestEndpoint
@RequestMapping(
		value = "auth",
		produces = "application/json; charset=UTF-8"
		)
public class UserAuthRestEndpoint
{
	private static final Logger logger = LogManager.getLogger(UserAuthRestEndpoint.class);
	
	@Inject
	private HttpSession session;
	
	@Inject 
	private UserManagerService userManager;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<Void> register(@RequestBody(required = true) UserInfo user)
	{
		userManager.add(user);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody(required = true) UserInfo userInfo)
	{
		session.setAttribute("user", userInfo.getName());
		logger.info(session.getAttribute("username"));
		
		return "ffff";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public String logout()
	{	
		session.invalidate();
		
		return "logout successfully";
	}
}
