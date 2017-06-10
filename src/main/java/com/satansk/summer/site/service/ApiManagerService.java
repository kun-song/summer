package com.satansk.summer.site.service;

import com.satansk.summer.site.domain.ApiSpec;

import java.util.List;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/10
 */
public interface ApiManagerService {

    /************************************** ApiSpec 接口 ***************************************/

    ApiSpec saveApiSpec(ApiSpec apiSpec);

    void deleteApiSpec(String id);

    void deleteApiSpec(ApiSpec apiSpec);

    ApiSpec updateApiSpec(ApiSpec apiSpec);

    List<ApiSpec> findApiSpecByTitle(String title);

    List<ApiSpec> findAllApiSpec();

    long countApiSpec();
}
