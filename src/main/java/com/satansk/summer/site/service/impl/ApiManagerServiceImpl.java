package com.satansk.summer.site.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.query.Order;
import org.springframework.stereotype.Service;

import com.satansk.summer.site.constant.MongoConstants;
import com.satansk.summer.site.entity.mongo.ApiSpec;
import com.satansk.summer.site.repository.ApiSpecRepository;
import com.satansk.summer.site.service.ApiManagerService;

/**
 * API 管理服务类
 *
 * 1. ApiSpec 管理。
 * 2. ApiPath 管理。
 */
@Service
public class ApiManagerServiceImpl implements ApiManagerService {

	private static final Logger logger = LogManager.getLogger(ApiManagerServiceImpl.class);
	
	@Inject
	private ApiSpecRepository apiSpecRepository;
	
	/************************************** ApiSpec 接口实现 ***************************************/
	
	@Override
	public ApiSpec saveApiSpec(ApiSpec apiSpec) 
	{
		return apiSpecRepository.save(apiSpec);
	}

	@Override
	public void deleteApiSpec(String id) 
	{
		apiSpecRepository.delete(id);
	}

	@Override
	public void deleteApiSpec(ApiSpec apiSpec) 
	{
		apiSpecRepository.delete(apiSpec);
	}

	@Override
	public ApiSpec updateApiSpec(ApiSpec apiSpec) 
	{
		return apiSpecRepository.save(apiSpec);
	}

	@Override
	public List<ApiSpec> findApiSpecByTitle(String title) 
	{
		return apiSpecRepository.findByInfoTitleIgnoreCase(title);
	}

	@Override
	public List<ApiSpec> findAllApiSpec() 
	{
		return apiSpecRepository.findAll(new Sort(Direction.DESC, MongoConstants.spec_modifiedTime));
	}

	@Override
	public ApiSpec findApiSpecById(String id) 
	{
		return apiSpecRepository.findOne(id);
	}
	
}
