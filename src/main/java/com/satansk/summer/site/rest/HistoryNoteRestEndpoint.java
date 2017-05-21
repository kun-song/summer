package com.satansk.summer.site.rest;

import javax.inject.Inject;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.satansk.summer.config.annotation.RestEndpoint;
import com.satansk.summer.site.entity.mongo.HistoryNote;
import com.satansk.summer.site.exception.ResourceNotFoundException;
import com.satansk.summer.site.service.impl.DefaultHistoryNoteService;

/**
 * 历史备注 REST 接口类
 * 
 * @author satansk
 */
@RestEndpoint(value = "notes")
public class HistoryNoteRestEndpoint {
	
	@Inject
	private DefaultHistoryNoteService historyNoteService;
	
	/************************************** REST 接口 ***************************************/
	
	/**
	 * 1. 获取 /rest/notes/ 支持的 HTTP 方法列表
	 * 2. 因为要精确控制响应头信息，所以用 ResponseEntity 而不是 @ResponseBody
	 * 3. 因为除了响应头之外，并没有实际的响应体，所以使用 Void
	 */
	@RequestMapping(method = RequestMethod.OPTIONS)
	public ResponseEntity<Void> discover() {
		HttpHeaders headers = new HttpHeaders();
		headers.add("Allow", "OPTIONS, HEAD, GET, POST");
		
		return new ResponseEntity<Void>(null, headers, HttpStatus.NO_CONTENT);
	}
	
	/**
	 * 1. 获取 /rest/notes/{id} 支持的 HTTP 方法列表，如果 id 指定的资源不存在，则抛出异常。
	 */
	@RequestMapping(value = "{id}", method = RequestMethod.OPTIONS)
	public ResponseEntity<Void> discover(@PathVariable("id") String id) {
		if (historyNoteService.exist(id)) {
			throw new ResourceNotFoundException();
		}
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Allow", "OPTIONS, HEAD, GET, PUT, DELETE");
		
		return new ResponseEntity<>(null, headers, HttpStatus.NO_CONTENT);
	}
	
	/**
	 * 1. 两种响应类型：（1） @ResponseBody 注解 （2）ResponseEntity<body, headers, status_code> 返回类型。
	 * 2. 使用 @ResponseBody 注解时，将使用 Controller 中的返回值作为响应。
	 * 3. 使用 ResponseEntity<body, headers, status_code> 可以定制响应的头信息，更加灵活。
	 */
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<HistoryNote> addHistoryNote() {
		
		HistoryNote historyNote = new HistoryNote();
		historyNote.setContent("content");
		
		historyNoteService.addNote(historyNote);
		
		return new ResponseEntity<HistoryNote>(historyNote, HttpStatus.CREATED);
	}
}
