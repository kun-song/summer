package com.satansk.summer.site.entity.mongo;

import java.util.Arrays;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class ApiSpec {
	
	@Id
	private String id;
	
	/**
	 * OpenAPI 规范的版本号，暂时只能为 2.0
	 */
	private String swagger;
	
	/**
	 * 基本描述信息
	 */
	private ApiInfo info;
	
	/**
	 * 可用协议：http/https
	 */
	private String[] schemes;
	
	/**
	 * 主机名/主机地址
	 */
	private String host;
	
	/**
	 * 根路径
	 */
	private String basePath;
	
	/**
	 * 创建时间
	 */
	private String createdTime;
	
	/**
	 * 修改时间
	 */
	private String modifiedTime;

	/********************************* Getter/Setter **********************************/
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getSwagger() {
		return swagger;
	}

	public void setSwagger(String swagger) {
		this.swagger = swagger;
	}

	public ApiInfo getInfo() {
		return info;
	}

	public void setInfo(ApiInfo info) {
		this.info = info;
	}

	public String[] getSchemes() {
		return schemes;
	}

	public void setSchemes(String[] schemes) {
		this.schemes = schemes;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String getBasePath() {
		return basePath;
	}

	public void setBasePath(String basePath) {
		this.basePath = basePath;
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

	/********************************* toString **********************************/
	@Override
	public String toString() {
		return "ApiSpec [id=" + id + ", swagger=" + swagger + ", info=" + info + ", schemes=" + Arrays.toString(schemes)
				+ ", host=" + host + ", basePath=" + basePath + ", createdTime=" + createdTime + ", modifiedTime="
				+ modifiedTime + "]";
	}
	
}
