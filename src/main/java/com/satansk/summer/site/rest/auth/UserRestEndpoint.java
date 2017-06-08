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
public class UserRestEndpoint
{
	private static final Logger logger = LogManager.getLogger(UserRestEndpoint.class);
	
	@Inject
	private HttpSession session;
	
	@Inject 
	private UserManagerService userManager;
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<String> register(@RequestBody(required = true) UserInfo userInfo)
	{
		// 输入有效性验证
		StringBuffer msg = new StringBuffer();
		if (! isValidUserInfo(userInfo, msg))
		{
			logger.error(msg.toString());
			return new ResponseEntity<>(msg.toString(), HttpStatus.NOT_MODIFIED);
		}
		
		try
		{
			// 名字不能重复
			if (userManager.findByName(userInfo.getName()) != null)
			{
				logger.error("Username exists");
				return new ResponseEntity<>("Username has already exists", HttpStatus.NOT_MODIFIED);
			}
		}
		catch (Exception e) 
		{
			logger.error(e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_MODIFIED);
		}
		
		// 防止误传 id
		userInfo.setId(null);
		// 持久化
		UserInfo user = userManager.add(userInfo);
		
		// 持久化成功
		if (user != null)
		{
			// 添加 Session 属性
			session.setAttribute("username", user.getName());
		}
		else
		{
			// 持久化失败，提示再试一次
			return new ResponseEntity<>("Register failed, please try again", HttpStatus.CREATED);
		}
		
		return new ResponseEntity<>(msg.toString(), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@ResponseBody
	public String login(@RequestBody(required = true) UserInfo userInfo)
	{
		if (userInfo == null)
		{
			return "UserInfo can't be null";
		}
		
		UserInfo userFromDB = userManager.findByName(userInfo.getName());
		
		// 用户不存在
		if (userFromDB == null)
		{
			return "Username error, please try again";
		}
		
		// 密码错误
		if (! userFromDB.getPassword().equals(userInfo.getPassword()))
		{
			return "Password error, please try again";
		}
		
		// 登录成功，设置会话
		session.setAttribute("username", userInfo.getName());
		return "login successfully";
	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	@ResponseBody
	public String logout()
	{	
		// 设置会话失效
		session.invalidate();
		return "logout successfully";
	}
	
	/********************************** Helper ************************************/
	
	private boolean isValidUserInfo(UserInfo userInfo, StringBuffer msg)
	{
		if (userInfo == null)
		{
			msg.append("UserInfo can't be null");
			return false;
		}
		
		String username = userInfo.getName();
		if (username == null || username.length() < 4)
		{
			msg.append("Username must be 4 chars or more");
			return false;
		}
		
		String password = userInfo.getPassword();
		if (password == null || password.length() < 8)
		{
			msg.append("Password must be 8 chars or more");
			return false;
		}
		
		msg.append("register successfully");
		return true;
	}
}
