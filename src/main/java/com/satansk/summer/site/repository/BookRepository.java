package com.satansk.summer.site.repository;

import com.satansk.summer.site.entity.Book;

public interface BookRepository extends GenericRepository<Long, Book> {
	Book getByIsbn(String isbn);
}
