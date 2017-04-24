package com.satansk.summer.site.service;

import java.util.List;

import com.satansk.summer.site.entity.Author;
import com.satansk.summer.site.entity.Book;
import com.satansk.summer.site.entity.Publisher;

public interface BookManager {
	
	List<Author> getAuthors();
	
	List<Book> getBooks();
	
	List<Publisher> getPublishers();
	
	void saveAuthor(Author author);
	
	void saveBook(Book book);
	
	void savePublisher(Publisher publisher);
}
