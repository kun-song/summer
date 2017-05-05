package com.satansk.summer.site.rest;

import javax.inject.Inject;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.satansk.summer.config.annotation.RestEndpoint;
import com.satansk.summer.site.bean.SummerResponse;
import com.satansk.summer.site.entity.mongo.HistoryNote;
import com.satansk.summer.site.service.impl.DefaultHistoryNoteService;

/**
 * 历史备注 REST 接口类
 * 
 * @author satansk
 */
@RestEndpoint(value = "note")
public class HistoryNoteRestEndpoint {
	
	@Inject
	DefaultHistoryNoteService historyNoteService;
	
	/**
	 * 添加一条备注
	 * 
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public SummerResponse addHistoryNote(@RequestBody HistoryNote note) {
		
		HistoryNote historyNote = new HistoryNote();
		historyNote.setContent("content");
		
		historyNoteService.addNote(historyNote);
		
		SummerResponse response = new SummerResponse();
		response.setContent(historyNote);
		
		return response;
	}
}
