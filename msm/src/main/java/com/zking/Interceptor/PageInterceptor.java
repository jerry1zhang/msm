package com.zking.Interceptor;

import com.zking.config.ConfigCode;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //初始化参数
        request.setAttribute("title1", ConfigCode.page_title_1.toString());
        request.setAttribute("title2",ConfigCode.page_title_2.toString());
        request.setAttribute("apple_title",ConfigCode.page_title_1.toString()+ConfigCode.page_title_2.toString());
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
