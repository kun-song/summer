package com.satansk.summer.site.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satansk.summer.site.entity.mongo.ApiSpec;

/**
 * 1. MongoRepository -> PagingAndSortingRepository -> CrudRepository -> Repository
 * 2. 
 */
public interface ApiSpecRepository extends MongoRepository<ApiSpec, String> {
	
	/************************************* 构造查询方法 ****************************************/
	
	/**
	 * 查询构造：
	 * 1. 去掉方法名中的已知前缀（find...By, read...By, query...By, count...By, get...By），解析剩余部分。
	 * 2. 第一个 By 之后是实际的查询 Criteria，使用属性表达式定义。
	 * 3. 忽略大小写，以 path 降序排序。
	 */
	List<ApiSpec> findByInfoTitleIgnoreCase(String title);
	
}
