package com.satansk.summer.site.service.impl;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.satansk.summer.site.entity.mongo.ApiSpec;
import com.satansk.summer.site.repository.ApiSpecRepository;
import com.satansk.summer.site.service.ApiSpecService;

@Service
public class ApiSpecServiceImpl implements ApiSpecService {

	private static final Logger logger = LogManager.getLogger(ApiSpecServiceImpl.class);
	
	@Inject
	private ApiSpecRepository apiSpecRepository;
	
	@Override
	public ApiSpec save(ApiSpec apiSpec) {
		return apiSpecRepository.save(apiSpec);
	}
	
}
