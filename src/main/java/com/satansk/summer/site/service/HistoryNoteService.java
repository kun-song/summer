package com.satansk.summer.site.service;

import java.util.List;

import com.satansk.summer.site.entity.mongo.HistoryNote;

/**
 * HistoryNote 服务接口
 * 
 * @author satansk
 */
public interface HistoryNoteService {

	boolean addNote(HistoryNote note);

	boolean removeNote(String noteId);
	
	boolean modifyNote(HistoryNote note);
	
	HistoryNote getNote(String noteId);
	
	List<HistoryNote> getNoteList(int offset, int limit);
}
