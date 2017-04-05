package com.satansk.summer.site.entity;

import java.time.Instant;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Account {
	private long id;
	private Instant lastModified;
	private String name;
	private String address;
	private String phoneNumber;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Instant getLastModified() {
		return lastModified;
	}
	public void setLastModified(Instant lastModified) {
		this.lastModified = lastModified;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
