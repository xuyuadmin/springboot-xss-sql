package com.xuyu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import com.xuyu.httprequest.XssHttpServletRequestWrapper;


@WebFilter(filterName = "xssFilter", urlPatterns = "/*")
public class XssFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// 程序防止XSS攻击原理
		// 1. 使用过滤器拦截所有参数
		HttpServletRequest req = (HttpServletRequest) request;
		// 2.重新getParameter方法
		XssHttpServletRequestWrapper xssHttpServletRequestWrapper = new XssHttpServletRequestWrapper(req);
		// 放行程序，继续往下执行
		chain.doFilter(xssHttpServletRequestWrapper, response);
	}

	public void destroy() {

	}

}
