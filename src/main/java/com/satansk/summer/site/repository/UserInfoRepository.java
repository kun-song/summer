package com.satansk.summer.site.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satansk.summer.site.entity.mongo.UserInfo;

public interface UserInfoRepository extends MongoRepository<UserInfo, String>, UserInfoOptions {

}
