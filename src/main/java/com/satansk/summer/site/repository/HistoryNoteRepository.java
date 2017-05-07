package com.satansk.summer.site.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satansk.summer.site.entity.mongo.HistoryNote;

/**
 * 1. 继承 MongoRepository<T, ID> 接口，继承集合的基本操作。
 * 2. 继承 HistoryNoteOptions 接口，获取基本操作之外的额外功能。
 */
public interface HistoryNoteRepository extends MongoRepository<HistoryNote, String>, HistoryNoteOptions {
	
}
