package com.satansk.summer.site.repository.impl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.satansk.summer.site.entity.Book;
import com.satansk.summer.site.repository.BookRepository;
import com.satansk.summer.site.repository.GenericJpaRepository;

/**
 * 1. 大部分方法在 GenericJpaRepository 中已经实现，只需要实现 BookRepository 中单独定义的 getByIsbn 即可。
 */
@Repository
public class DefaultBookRepository extends GenericJpaRepository<Long, Book> implements BookRepository {

	@Override
	public Book getByIsbn(String isbn) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Book> query = builder.createQuery(this.entityClass);
		Root<Book> root = query.from(this.entityClass);
		
		return this.entityManager
				.createQuery(query.select(root).where(builder.equal(root.get("isbn"), isbn)))
				.getSingleResult();
	}
}
