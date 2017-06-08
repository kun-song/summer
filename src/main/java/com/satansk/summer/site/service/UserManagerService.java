package com.satansk.summer.site.service;

import com.satansk.summer.site.entity.mongo.UserInfo;

public interface UserManagerService
{
	/************************************** ApiSpec 接口 ***************************************/
	
	UserInfo add(UserInfo user);
	
	UserInfo findById(String id);
	
	UserInfo findByName(String name);
}
