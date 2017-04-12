package com.satansk.summer.site.servlet;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.security.sasl.AuthorizeCallback;
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
	
	@SuppressWarnings("unused")
	private final Random random;
	private EntityManagerFactory factory;
	
	public EntityServlet() {
		
		try {
			this.random = SecureRandom.getInstanceStrong();
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalStateException(e);
		}
	}

	@Override
	public void destroy() {
		super.destroy();
		this.factory.close();
	}

	@Override
	public void init() throws ServletException {
		super.init();
		/**
		 * 1. 获取 persistence.xml 文件中配置的名为 EntityMappings 的持久化单元。
		 * 2. 为该持久化单元创建一个 EntityManagerFactory。
		 */
		this.factory = Persistence.createEntityManagerFactory("EntityMappings");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		
		try {
			manager = this.factory.createEntityManager();
			transaction = manager.getTransaction();
			
			// 开始事务
			transaction.begin();
			
			CriteriaBuilder builder = manager.getCriteriaBuilder();
			
			// 查询 Publisher 表
			CriteriaQuery<Publisher> q1 = builder.createQuery(Publisher.class);
			List<Publisher> publishers = manager.createQuery(q1.select(q1.from(Publisher.class))).getResultList();
			
			// 查询 Author 表
			CriteriaQuery<Author> q2 = builder.createQuery(Author.class);
			List<Author> authors = manager.createQuery(q2.select(q2.from(Author.class))).getResultList();
			
			// 查询 Book 表
			CriteriaQuery<Book> q3 = builder.createQuery(Book.class);
			List<Book> books = manager.createQuery(q3.select(q3.from(Book.class))).getResultList();
			
			// 提交事务
			transaction.commit();
			
			// 响应请求
			resp.getWriter().write(publishers.get(0).toString());
			
		} catch(Exception e) {
			
			// 回滚事务
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			
			e.printStackTrace();
			// 异常堆栈作为响应返回
			resp.getWriter().write(e.getMessage());
		} finally {
			
			// 关闭 EntityManager
			if (manager != null && manager.isOpen()) {
				manager.close();
			}
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		EntityManager manager = null;
		EntityTransaction transaction = null;
		
		try {
			manager = this.factory.createEntityManager();
			transaction = manager.getTransaction();
			
			// 开始事务
			transaction.begin();
			
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
			
			// 提交事务
			transaction.commit();
			
			// 重定向至 doGet
			resp.sendRedirect(req.getContextPath() + "/entities");
			
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			
			e.printStackTrace();
			resp.getWriter().write(e.getMessage());
		} finally {
			if (manager != null && manager.isOpen()) {
				manager.close();
			}
		}
	}
}
