package com.satansk.summer.site.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@Entity(name = "PublisherEntity")
@Table(
		name = "Publishers",
		indexes = {
				@Index(name = "Publishers_Names", columnList = "PublisherName")
		}
		)
public class Publisher implements Serializable {
	private long id;
	private String name;
	private String address;
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	@Column(name = "PublisherId")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Basic
	@Column(name = "PublisherName", nullable = false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Basic
	@Column(nullable = false)
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
}
