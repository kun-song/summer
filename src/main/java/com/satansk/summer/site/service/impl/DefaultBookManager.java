package com.satansk.summer.site.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.satansk.summer.site.entity.Author;
import com.satansk.summer.site.entity.Book;
import com.satansk.summer.site.entity.Publisher;
import com.satansk.summer.site.repository.AuthorRepository;
import com.satansk.summer.site.repository.BookRepository;
import com.satansk.summer.site.repository.PublisherRepository;
import com.satansk.summer.site.service.BookManager;

@Service
public class DefaultBookManager implements BookManager {
	@Inject
	private AuthorRepository authorRepository;
	@Inject
	private BookRepository bookRepository;
	@Inject
	private PublisherRepository publisherRepository;
	
	@Override
	public List<Author> getAuthors() {
		return this.toList(authorRepository.getAll());
	}

	@Override
	public List<Book> getBooks() {
		return this.toList(bookRepository.getAll());
	}

	@Override
	public List<Publisher> getPublishers() {
		return this.toList(publisherRepository.getAll());
	}

	@Override
	public void saveAuthor(Author author) {
		if (author.getId() < 1) {
			authorRepository.add(author);
		} else {
			authorRepository.update(author);
		}
	}

	@Override
	public void saveBook(Book book) {
		if (book.getId() < 1) {
			bookRepository.add(book);
		} else {
			bookRepository.update(book);
		}
	}

	@Override
	public void savePublisher(Publisher publisher) {
		if (publisher.getId() < 1) {
			publisherRepository.add(publisher);
		} else {
			publisherRepository.update(publisher);
		}
	}

	/**************************** Helper *******************************/
	
	private <E> List<E> toList(Iterable<E> i) {
		List<E> list = new ArrayList<>();
		i.forEach(list::add);
		
		return list;
	}
}
