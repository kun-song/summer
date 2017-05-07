package com.satansk.summer.site.repository.impl;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.satansk.summer.site.entity.Book;
import com.satansk.summer.site.repository.BookRepository;

/**
 * 1. 大部分方法在 GenericJpaRepository 中已经实现，只需要实现 BookRepository 中单独定义的 getByIsbn 即可。
 */
@Repository
public class DefaultBookRepository implements BookRepository {

	@Inject
	private EntityManager entityManager;
	
	@Override
	public Book getByIsbn(String isbn) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Book> query = builder.createQuery(Book.class);
		Root<Book> root = query.from(Book.class);
		
		return this.entityManager
				.createQuery(query.select(root).where(builder.equal(root.get("isbn"), isbn)))
				.getSingleResult();
	}
}
