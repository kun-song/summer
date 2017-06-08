package com.satansk.summer.site.service.impl;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.satansk.summer.site.entity.mongo.UserInfo;
import com.satansk.summer.site.repository.UserInfoRepository;
import com.satansk.summer.site.service.UserManagerService;

@Service
public class UserManagerSeviceImpl implements UserManagerService
{

	@Inject
	private UserInfoRepository userInfoRepository;
	
	@Override
	public UserInfo add(UserInfo user)
	{
		return userInfoRepository.insert(user);
	}

	@Override
	public UserInfo findById(String id) 
	{
		return userInfoRepository.findOne(id);
	}

	@Override
	public UserInfo findByName(String name) 
	{
		return userInfoRepository.findByName(name);
	}

}
