package com.satansk.summer.site.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.satansk.summer.site.entity.Author;
import com.satansk.summer.site.entity.Book;
import com.satansk.summer.site.entity.Publisher;

@WebServlet(
		name = "entityServlet",
		urlPatterns = "/entities",
		loadOnStartup = 1
		)
public class EntityServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	private final Random random;
	
	@PersistenceContext
	private EntityManager manager;
	
	public EntityServlet() {
		
		try {
			this.random = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		if (id == null) {
			resp.getWriter().write("id can't be empty!");
			return;
		}
		
		Publisher publisher = (Publisher) this.manager
				.createQuery("select p from Publisher p where p.id = :id")
				.setParameter("id", id)
				.getSingleResult();
		
		resp.getWriter().write(publisher.toString());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Publisher publisher = new Publisher();
			publisher.setName("MIT Press");
			publisher.setAddress("chunxi road");
			
			manager.persist(publisher);
			
			Author author = new Author();
			author.setName("Kyle");
			author.setEmailAddress("satansk@hotmail.com");
			
			manager.persist(author);
			
			Book book = new Book();
			book.setIsbn("" + this.random.nextInt(Integer.MAX_VALUE));
			book.setTitle("Java Cookbook");
			book.setAuthor("Kyle");
			book.setPublisher("MIT Press");
			book.setPrice(50);
			
			manager.persist(book);
			
			// 重定向至 doGet
			resp.sendRedirect(req.getContextPath() + "/entities");
			
		} catch (Exception e) {
			e.printStackTrace();
			resp.getWriter().write(e.getMessage());
		} finally {
			if (manager != null && manager.isOpen()) {
				manager.close();
			}
		}
	}
}
