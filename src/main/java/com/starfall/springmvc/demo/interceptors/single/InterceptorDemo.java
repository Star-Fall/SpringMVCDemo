package com.starfall.springmvc.demo.interceptors.single;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo.interceptors
 * @className InterceptorDemo
 * @date 2019/9/17 22:42
 * @description 拦截器demo
 */
public class InterceptorDemo implements HandlerInterceptor {
	/**
	 * 在请求处理之前执行，该方法主要是用于准备资源数据的
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @param handler
	 *            Object
	 * @return true
	 * @throws Exception
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("[InterceptorDemo] preHandle");
		return true;
	}

	/**
	 * 在请求处理之后，并且在DispatcherServlet视图渲染之前调用。
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @param handler
	 *            Object
	 * @param modelAndView
	 *            ModelAndView
	 * @throws Exception
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("[InterceptorDemo] postHandle");
	}

	/**
	 * 在整个请求结束之后，在DispatcherServlet 渲染了对应的视图之后调用。
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @param handler
	 *            Object
	 * @param ex
	 *            Exception
	 * @throws Exception
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("[InterceptorDemo] afterCompletion");
	}
}