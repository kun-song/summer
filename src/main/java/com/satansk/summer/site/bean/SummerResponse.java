package com.satansk.summer.site.bean;

/**
 * Summer 统一响应类型
 * 
 * @author satansk
 */
public class SummerResponse {
	
	// 响应实际内容
	private Object content;
	
	// 响应码
	private long code;
	
	// 响应消息
	private String message;
	
	/*********************************** Constructor ***********************************/
	
	public SummerResponse(Object content, long code, String message) {
		super();
		this.content = content;
		this.code = code;
		this.message = message;
	}
	
	public SummerResponse() {
		super();
	}

	/*********************************** Getter/Setter ***********************************/
	
	public Object getContent() {
		return content;
	}

	public void setContent(Object content) {
		this.content = content;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	/*********************************** toString ***********************************/
	
	@Override
	public String toString() {
		return "SummerResponse [content=" + content + ", code=" + code + ", message=" + message + "]";
	}
}
