package com.satansk.summer.site.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.satansk.summer.site.entity.mongo.HistoryNote;


public interface HistoryNoteRepository extends MongoRepository<HistoryNote, String> {
	
}
