package com.satansk.summer.site.service;

import java.util.List;

import com.satansk.summer.site.entity.mongo.ApiSpec;

public interface ApiManagerService {
	
	/************************************** ApiSpec 接口 ***************************************/
	
	ApiSpec saveApiSpec(ApiSpec apiSpec);
	
	void deleteApiSpec(String id);
	
	void deleteApiSpec(ApiSpec apiSpec);
	
	ApiSpec updateApiSpec(ApiSpec apiSpec);
	
	List<ApiSpec> findApiSpecByTitle(String title);
	
	List<ApiSpec> findAllApiSpec();
	
	ApiSpec findApiSpecById(String id);
	
}
