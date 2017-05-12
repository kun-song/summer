package com.satansk.summer.site.entity.mongo;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.satansk.summer.site.misc.HttpMethod;

/**
 * 接口集合
 */
@Document
public class ApiPath {
	
	@Id
	private String id;
	
	private String path;
	
	private HttpMethod method;
	
	private String summary;
	
	private String description;
	
	private ApiResponse response;
	
	private Map<String, String> queryParameters;
	
	private Map<String, String> bodyParameters;

	/********************************* Getter/Setter **********************************/
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public HttpMethod getMethod() {
		return method;
	}

	public void setMethod(HttpMethod method) {
		this.method = method;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ApiResponse getResponse() {
		return response;
	}

	public void setResponse(ApiResponse response) {
		this.response = response;
	}

	public Map<String, String> getQueryParameters() {
		return queryParameters;
	}

	public void setQueryParameters(Map<String, String> queryParameters) {
		this.queryParameters = queryParameters;
	}

	public Map<String, String> getBodyParameters() {
		return bodyParameters;
	}

	public void setBodyParameters(Map<String, String> bodyParameters) {
		this.bodyParameters = bodyParameters;
	}

	/********************************* toString **********************************/
	
	@Override
	public String toString() {
		return "ApiSpec [id=" + id + ", path=" + path + ", queryParameters=" + queryParameters + ", bodyParameters="
				+ bodyParameters + "]";
	}
	
}
