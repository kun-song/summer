package com.satansk.summer.site.entity;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 1. @Entity 标注该类为实体类，实体类映射的表默认与实体类同名，即 Book。
 * 2. @Table 修改映射的数据库表名为 Books。
 */
@Entity
@Table(
		name = "Books", 
		uniqueConstraints = {
				@UniqueConstraint(name = "Books_ISBNs", columnNames = { "isbn" })
		},
		indexes = {
				@Index(name = "Books_Titles", columnList = "title")
		})
public class Book implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private long id;
	private String isbn;
	private String title;
	private String author;
	private double price;
	private String publisher;
	
	/**
	 * 1. @id 标注主键
	 * 2. @GeneratedValue 自动生成主键 id，可以指定 id 生成策略，例如 GenerationType.IDENTITY
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	/**
	 * 1. @Basic 基本数据类型映射
	 * 2. optional = false 表明该列不能为 null
	 * 3. 默认将实体类属性映射到数据库表的同名列
	 */
	@Basic(optional = false)
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	@Basic(optional = false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Basic(optional = false)
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Basic
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@Basic(optional = false)
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
}
