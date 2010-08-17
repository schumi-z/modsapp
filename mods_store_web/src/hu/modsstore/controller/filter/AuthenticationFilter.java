package hu.modsstore.controller.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {

	private FilterConfig filterConfig;

	@Override
	public void destroy() {
		this.filterConfig = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpSession session = ((HttpServletRequest) request).getSession(false);
		if (session == null) {
			forwardToAdminPage(request, response);
			return;
		}
		if (session.getAttribute("felhasznalo") == null) {
			forwardToAdminPage(request, response);
			return;
		}
		chain.doFilter(request, response);
	}

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.filterConfig = config;
	}

	private void forwardToAdminPage(ServletRequest request,
			ServletResponse response) throws ServletException, IOException {
		filterConfig.getServletContext().getRequestDispatcher("/adminpage.do")
				.forward(request, response);
	}

}
