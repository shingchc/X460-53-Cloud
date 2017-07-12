package edu.uci.cc;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;


public class SecurityFilter implements Filter
{
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException
    {
		if (req instanceof HttpServletRequest)
		{
	        UserService userService = UserServiceFactory.getUserService();
	        User user = userService.getCurrentUser();

	        if (user != null)
	        {
	            HttpSession httpSession = ((HttpServletRequest)req).getSession(true);
	            httpSession.setAttribute("user", user);
	        }

	        filterChain.doFilter(req, resp);
		}
    }

    public void init(FilterConfig filterConfig)
    {
    }

    public void destroy() {}
}