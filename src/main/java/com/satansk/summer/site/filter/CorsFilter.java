package com.satansk.summer.site.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


/**
 * 1. 过滤器作用：
 * 		（1）拦截 Request & Response
 * 		（2）检测、修改 Request & Response
 * 		（3）拒绝、重定向、转发 Request
 * 2. 过滤器可以非常灵活的使用，只会受个人经验所限制。
 * 3. 注解实现方式的缺点是：无法实现对过滤器链的排序。
 */
@WebFilter(
		filterName = "corsFilter",
		urlPatterns = "/*"
		)
public class CorsFilter implements Filter 
{
	private static final Logger logger = LogManager.getLogger(CorsFilter.class);
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException 
	{
		logger.info("init CorsFilter");
	}

	/**
	 * 1. 若无 chain.doFilter(request, response) 则过滤器链将被中断，剩余过滤器不再生效，直接进入 Servlet 处理。
	 * 2. 在 Response 中添加 Access-Control-Allow-Origin 为 *，允许跨域访问。
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException 
	{
		// 跨域共享设置
		HttpServletResponse res = (HttpServletResponse) response;
		
		res.setHeader("Access-Control-Allow-Origin", "*");
		res.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
		res.setHeader("Access-Control-Max-Age", "3600");
		res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");
		
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() 
	{
		logger.info("destroy CorsFilter");
	}
	
}
