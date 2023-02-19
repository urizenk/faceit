package com.kot.book.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author yf
 * @create 2022-12-17 19:47
 */
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("请检查登录");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("ok");
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
