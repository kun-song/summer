package com.satansk.summer.site.repository;

import com.satansk.summer.site.entity.mongo.UserInfo;

public interface UserInfoOptions
{
	UserInfo findByName(String name);
}
