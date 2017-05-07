package com.satansk.summer.site.repository;

import java.util.List;

import com.satansk.summer.site.entity.mongo.HistoryNote;

/**
 * 1. Spring Data 可以为 Repository 接口自动生成实现。
 * 2. 可以通过中间接口扩展默认实现。
 */
public interface HistoryNoteOptions {
	
	/**
	 * 查找指定 API 所有历史备注
	 * 
	 * @param api
	 * @return HistoryNote 列表
	 */
	List<HistoryNote> findByApi(String api);
}
