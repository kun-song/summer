package com.satansk.summer.site.entity.mongo;

import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * 1. @Document @Id 注解实现 Java 实体类与 MongoDB 文档的映射。
 * 2. 类似 @Entity @Id 实现实体类与关系数据库表的映射。
 */
@Document
public class HistoryNote {
	
	@Id
	private String id;
	
	private String api;
	private String content;
	private int priority;
	private String author;
	
	private String createdTime;
	private String modifiedTime;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getApi() {
		return api;
	}
	public void setApi(String api) {
		this.api = api;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public String getCreatedTime() {
		return createdTime;
	}
	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}
	
	public String getModifiedTime() {
		return modifiedTime;
	}
	public void setModifiedTime(String modifiedTime) {
		this.modifiedTime = modifiedTime;
	}
	
	@Override
	public String toString() {
		return "HistoryNote [id=" + id + ", content=" + content + ", priority=" + priority + ", author=" + author
				+ ", createdTime=" + createdTime + ", modifiedTime=" + modifiedTime + "]";
	}
}
