package com.satansk.summer.site.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Author:  satansk
 * Email:   satansk@hotmail.com
 * Date:    17/6/10
 */
@Order(1)
@WebFilter(
        filterName = "loginFilter",
        urlPatterns = "/*"
)
public class LoginFilter implements Filter {
    @Autowired private final static Logger logger = LoggerFactory.getLogger(LoginFilter.class);
    @Autowired private HttpSession session;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        logger.info("A Request coming into LoginFilter...");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String url = ((HttpServletRequest) servletRequest).getRequestURI();
        // 跳过登录、注册接口
        if (url.contains("register") || url.contains("login")) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 已登录
        if (session.getAttribute("username") != null) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }

        // 未登录
        servletResponse.getWriter().write("login first");
    }

    @Override
    public void destroy() {
        logger.info("A Request coming out LoginFilter...");
    }
}
