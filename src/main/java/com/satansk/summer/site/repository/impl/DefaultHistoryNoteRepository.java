package com.satansk.summer.site.repository.impl;

import java.util.List;

import javax.inject.Inject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
	public <S extends HistoryNote> List<S> save(Iterable<S> entites) {
		
		return null;
	}

	@Override
	public List<HistoryNote> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HistoryNote> findAll(Sort sort) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends HistoryNote> S insert(S entity) {
		
		log.info("start save...");
		
		mongo.save(entity);
		
		log.info("end save...");
		
		return entity;
	}

	@Override
	public <S extends HistoryNote> List<S> insert(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<HistoryNote> findAll(Pageable arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(HistoryNote arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Iterable<? extends HistoryNote> arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean exists(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<HistoryNote> findAll(Iterable<String> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HistoryNote findOne(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends HistoryNote> S save(S arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
