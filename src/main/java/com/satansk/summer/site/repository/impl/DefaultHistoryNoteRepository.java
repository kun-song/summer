package com.satansk.summer.site.repository.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Repository;

import com.satansk.summer.site.entity.mongo.HistoryNote;
import com.satansk.summer.site.repository.HistoryNoteRepository;

@Repository
public class DefaultHistoryNoteRepository implements HistoryNoteRepository {

	private static final Logger log = LogManager.getLogger(DefaultHistoryNoteRepository.class);
	
	@Inject
	private MongoOperations mongo;
	
	@Override
	public boolean save(HistoryNote note) {
		try {
			mongo.insert(note);
		} catch (Exception e) {
			log.error(e.getMessage());
			return false;
		}
		
		return true;
	}

	@Override
	public boolean delete(String noteId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(HistoryNote note) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public HistoryNote get(String noteId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HistoryNote> getList(int offset, int limit) {
		// TODO Auto-generated method stub
		return null;
	}
}
