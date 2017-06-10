package com.satansk.summer.site.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/10
 *
 * 1. 过滤器作用：
 * 		（1）拦截 Request & Response
 * 		（2）检测、修改 Request & Response
 * 		（3）拒绝、重定向、转发 Request
 * 2. 过滤器可以非常灵活的使用，只会受个人经验所限制。
 * 3. 注解实现方式的缺点是：无法实现对过滤器链的排序。
 *
 * 4. SpringBoot 中使用 Filter：
 *     （1）@WebFilter 注解修饰过滤器。
 *     （2）@ServletComponentScan 注解修饰启动类
 */
@Order(1)
@WebFilter(
        filterName = "corsFilter",
        urlPatterns = "/*"
)
public class CorsFilter implements Filter {

    private final static Logger logger = LoggerFactory.getLogger(CorsFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("A Request coming into CorsFilter...");
    }

    /**
     * 1. 若无 chain.doFilter(request, response) 则过滤器链将被中断，剩余过滤器不再生效，直接进入 Servlet 处理。
     * 2. 在 Response 中添加 Access-Control-Allow-Origin 为 *，允许跨域访问。
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 跨域共享设置
        HttpServletResponse res = (HttpServletResponse) servletResponse;

        res.setHeader("Access-Control-Allow-Origin", "*");
        res.setHeader("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE");
        res.setHeader("Access-Control-Max-Age", "3600");
        res.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type, Accept");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        logger.info("A Request coming out CorsFilter...");
    }
}
