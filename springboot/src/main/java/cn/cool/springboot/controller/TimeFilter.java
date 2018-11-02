package cn.cool.springboot.controller;


import javax.servlet.*;
import java.io.IOException;

public class TimeFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        long timeMillis = System.currentTimeMillis();
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.print("耗时" + (System.currentTimeMillis() - timeMillis));
    }

    @Override
    public void destroy() {

    }
}
