package com.satansk.summer.config;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class Bootstrap implements WebApplicationInitializer {

	public void onStartup(ServletContext container) throws ServletException {
		container.getServletRegistration("default").addMapping("/resouces");
		
		// root context configuration
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootContextConfiguration.class);
		container.addListener(new ContextLoaderListener(rootContext));
		
		// ordinary servlet context configuration
		AnnotationConfigWebApplicationContext webContext = new AnnotationConfigWebApplicationContext();
		webContext.register(WebServletContextConfiguration.class);
		
		ServletRegistration.Dynamic dispatcher = container.addServlet("springWebDispatcher", new DispatcherServlet(webContext));
		dispatcher.setLoadOnStartup(1);
		dispatcher.setMultipartConfig(new MultipartConfigElement(null, 20_971_520L, 41_943_040L, 512_000));
		dispatcher.addMapping("/");
		
		AnnotationConfigWebApplicationContext restContext = new AnnotationConfigWebApplicationContext();
		restContext.register(RestServletContextConfiguration.class);
		
		DispatcherServlet servlet = new DispatcherServlet(restContext);
		servlet.setDispatchOptionsRequest(true);
		dispatcher = container.addServlet("springRestDispatcher", servlet);
		dispatcher.setLoadOnStartup(2);
		dispatcher.addMapping("/rest/*");
		
		
	}

}
