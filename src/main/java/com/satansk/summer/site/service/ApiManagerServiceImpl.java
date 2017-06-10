package com.satansk.summer.site.service;

import com.satansk.summer.site.constant.MongoConstants;
import com.satansk.summer.site.domain.ApiSpec;
import com.satansk.summer.site.repository.ApiSpecRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/10
 */
@Service
public class ApiManagerServiceImpl implements ApiManagerService {
    private static final Logger logger = LoggerFactory.getLogger(ApiManagerServiceImpl.class);

    @Autowired private ApiSpecRepository apiSpecRepository;

    /************************************** ApiSpec 接口实现 ***************************************/

    @Override
    public ApiSpec saveApiSpec(ApiSpec apiSpec)
    {
        return apiSpecRepository.save(apiSpec);
    }

    @Override
    public void deleteApiSpec(String id)
    {
        apiSpecRepository.deleteById(id);
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
        return apiSpecRepository.findAll(new Sort(Sort.Direction.DESC, MongoConstants.spec_modifiedTime));
    }

    @Override
    public long countApiSpec()
    {
        return apiSpecRepository.count();
    }
}
