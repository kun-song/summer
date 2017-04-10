package com.satansk.summer.site.servlet;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

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
}
