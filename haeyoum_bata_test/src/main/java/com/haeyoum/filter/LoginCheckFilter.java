package com.haeyoum.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.haeyoum.member.model.User;

public class LoginCheckFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletResponse resp = (HttpServletResponse) response;
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		
		if (!session.isNew()) {
			User user = (User) session.getAttribute("user");
			if (user == null) {
				resp.sendRedirect(req.getContextPath() + "/sign-in");
				return;
			} else if (!user.isLogin()) {
				resp.sendRedirect(req.getContextPath() + "/sign-in");
				return;
			}
		} else {
			resp.sendRedirect(req.getContextPath() + "/sign-in");
			return;
		}

		chain.doFilter(request, response);
	}
	
	@Override
	public void destroy() {

	}
}
