package com.satansk.summer.site.repository;

import java.io.Serializable;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

/**
 * 1. 将需要暴露 CrudRepository 中的方法复制到 BaseMongoRepository 中，即可暴露部分方法。
 * 2. @NoRepositoryBean 说明该接口为中间接口，不需要创建该接口的 Bean 实例。
 */
@NoRepositoryBean
public interface BaseRepository<T, ID extends Serializable> extends Repository<T, ID> {
	
	/**
	 * 保存给定实体，返回参数 entity 以供其他用途，防止 save 方法会改变 entity。
	 */
	<S extends T> S save(S entity);
	
	/**
	 * 保存所有实体
	 */
	<S extends T> Iterable<S> save(Iterable<S> entities);
	
	/**
	 * 1. 检索指定 ID 的实体
	 * 2. 不存在则返回 null
	 */
	T findOne(ID id);
	
	/**
	 * 检索指定 ID 的实体是否存在
	 */
	boolean exists(ID id);
}
