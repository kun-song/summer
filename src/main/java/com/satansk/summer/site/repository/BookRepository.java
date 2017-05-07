package com.satansk.summer.site.repository;

import com.satansk.summer.site.entity.Book;

public interface BookRepository {
	Book getByIsbn(String isbn);
}
