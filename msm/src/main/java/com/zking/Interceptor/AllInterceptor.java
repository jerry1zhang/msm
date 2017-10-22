package com.zking.Interceptor;

import org.activiti.engine.identity.Group;
import org.activiti.engine.identity.User;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AllInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		User user = (User) request.getSession().getAttribute("User");
		Group group = (Group) request.getSession().getAttribute("Group");
		if(request.getRequestURI().endsWith("/loginPage")||
				request.getRequestURI().endsWith(".js")||
				request.getRequestURI().endsWith(".css")||
				request.getRequestURI().endsWith(".png")||
				request.getRequestURI().endsWith(".otf")||
				request.getRequestURI().endsWith(".eot")||
				request.getRequestURI().endsWith(".ttf")||
				request.getRequestURI().endsWith(".woff")||
				request.getRequestURI().endsWith(".woff2")) {

			return true;

		}else{
			if (user != null && group != null) {
				return true;
			} else {
				response.sendRedirect(request.getContextPath() + "/login/loginPage");
				return false;
			}
		}

	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}

	private void initMenu(HttpServletRequest request){

	}
}
