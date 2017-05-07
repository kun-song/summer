package com.satansk.summer.site.repository.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import com.satansk.summer.site.constant.MongoConstants;
import com.satansk.summer.site.entity.mongo.HistoryNote;
import com.satansk.summer.site.repository.HistoryNoteOptions;

/**
 * 1. 扩展 Spring Data 自动生成的 Repository 实现
 * 2. 虽然继承 HistoryNoteOptions，但名字是 HistoryNoteRepository 接口名 + Impl，
 *    只有这样，Spring Data 才能将其作为 HistoryNoteRepository 接口自动实现的一部分混合加入。
 */
public class HistoryNoteRepositoryImpl implements HistoryNoteOptions {

	@Inject
	private MongoOperations mongo;
	
	
	@Override
	public List<HistoryNote> findByApi(String api) {
		
		List<HistoryNote> results = null;
	
		results = mongo.find(Query.query(Criteria.where("api").is(api)), 
				HistoryNote.class, 
				MongoConstants.HISTORY_NOTE);
		
		return results;
	}

}
