package com.satansk.summer.site.rest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.satansk.summer.config.annotation.RestEndpoint;
import com.satansk.summer.site.entity.mongo.ApiSpec;

/**
 * @RequestMapping 使用请求路径 + 请求内容来做路由，只接受 Content-Type 为 application/json 的请求
 */
@RestEndpoint
@RequestMapping(
		value = "api/spec",
		consumes = "application/json",
		produces = "application/json"
		)
public class ApiSpecRestEndpoint {
	
	private static final Logger logger = LogManager.getLogger(ApiSpecRestEndpoint.class);
	
	/************************************** REST 接口 ***************************************/
	
	/**
	 * 允许使用 OPTIONS, GET, POST, PUT, DELETE 等方法。
	 */
	@RequestMapping(method = RequestMethod.OPTIONS)
	public ResponseEntity<Void> discover() {
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Allow", "OPTIONS, GET, POST, PUT, DELETE");
		
		logger.info("Allow Http Methods: " + headers.getAllow());
		
		return new ResponseEntity<Void>(null, headers, HttpStatus.OK);
	}
	

}
