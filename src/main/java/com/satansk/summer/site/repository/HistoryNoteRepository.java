package com.satansk.summer.site.repository;

import java.util.List;

import com.satansk.summer.site.entity.mongo.HistoryNote;


public interface HistoryNoteRepository {
	
	public boolean save(HistoryNote note);
	
	public boolean delete(String noteId);
	
	public boolean update(HistoryNote note);
	
	public HistoryNote get(String noteId);
	
	public List<HistoryNote> getList(int offset, int limit);
}
