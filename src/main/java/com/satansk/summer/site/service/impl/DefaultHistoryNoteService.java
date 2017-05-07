package com.satansk.summer.site.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.satansk.summer.site.entity.mongo.HistoryNote;
import com.satansk.summer.site.repository.HistoryNoteRepository;
import com.satansk.summer.site.service.HistoryNoteService;

@Service
public class DefaultHistoryNoteService implements HistoryNoteService {
	
	@Inject
	private HistoryNoteRepository historyNoteRepository;
	
	@Override
	public boolean addNote(HistoryNote note) {
		
		if (note == null) {
			return false;
		}
		
		historyNoteRepository.save(note);
		
		return true;
	}

	@Override
	public boolean removeNote(String noteId) {
		return false;
	}

	@Override
	public boolean modifyNote(HistoryNote note) {
		return false;
	}

	@Override
	public HistoryNote getNote(String noteId) {
		return null;
	}

	@Override
	public List<HistoryNote> getNoteList(int offset, int limit) {
		return null;
	}

	@Override
	public boolean exist(String noteId) {
		return historyNoteRepository.exists(noteId);
	}

	@Override
	public boolean exist(HistoryNote note) {
		return false;
	}

}
