package com.satansk.summer.site.repository;

import com.satansk.summer.site.domain.UserInfo;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/10
 */
public interface UserInfoRepository extends MongoRepository<UserInfo, String>, UserInfoOptions {
}
