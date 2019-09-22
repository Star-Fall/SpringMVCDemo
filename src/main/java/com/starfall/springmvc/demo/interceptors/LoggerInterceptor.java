package com.starfall.springmvc.demo.interceptors;

import org.apache.log4j.Logger;
import org.springframework.core.NamedThreadLocal;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo.interceptors
 * @className LoggerInterceptor
 * @date 2019/9/18 23:24
 * @description 日志拦截器记录操作日志
 */
public class LoggerInterceptor implements HandlerInterceptor {

	private Logger logger = Logger.getLogger(LoggerInterceptor.class);

	/**
	 * 本地线程存储消耗时间变量
	 */
	private ThreadLocal<Long> costTimeThreadLocal = new NamedThreadLocal<>("costTimeThreadLocal");

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		long startTime = System.currentTimeMillis();
		costTimeThreadLocal.set(startTime);
		// logger日志记录
		logger.debug("********************LoggerInterceptor.begin********************");
		logger.debug("Thread.currentThread()：" + Thread.currentThread().getName());
		logger.debug(
				"OpTime:           " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS").format(new Date(startTime)));
		logger.debug("RequestURL:       " + request.getRequestURL());
		logger.debug("RequestMethod:    " + request.getMethod());
		logger.debug("RequestParams:    " + getParamString(request.getParameterMap()));
		if (handler instanceof HandlerMethod) {
			HandlerMethod h = (HandlerMethod) handler;
			logger.debug("ControllerName:   " + h.getBean().getClass().getName());
			logger.debug("ControllerMethod: " + h.getMethod().getName());
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		if (modelAndView != null) {
			logger.debug("ViewName:    " + modelAndView.getViewName());
			logger.debug("ViewStatus:    " + modelAndView.getStatus());
		} else {
			logger.debug("ModelAndView:   " + modelAndView);
		}
		logger.debug("afterCompletion：" + Thread.currentThread().getName());
		logger.debug("响应状态:          " + response.getStatus());
		logger.debug("最大内存:          " + Runtime.getRuntime().maxMemory() / 1024 / 1024 + "m");
		logger.debug("已分配内存:         " + Runtime.getRuntime().totalMemory() / 1024 / 1024 + "m");
		logger.debug("已分配内存中的剩余空间: " + Runtime.getRuntime().freeMemory() / 1024 / 1024 + "m");
		logger.debug("最大可用内存:        " + (Runtime.getRuntime().maxMemory() - Runtime.getRuntime().totalMemory()
				+ Runtime.getRuntime().freeMemory()) / 1024 / 1024 + "m");
		long endTime = System.currentTimeMillis();
		long startTime = costTimeThreadLocal.get();
		logger.debug("耗时:             " + (endTime - startTime) + "ms");
		logger.debug("********************LoggerInterceptor.end********************");
		// 清除本地线程
		costTimeThreadLocal.remove();
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
	}

	/**
	 * 从Map参数获取参数字符串
	 *
	 * @param map
	 *            参数map
	 * @return
	 */
	private String getParamString(Map<String, String[]> map) {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String[]> e : map.entrySet()) {
			sb.append(e.getKey()).append("=");
			String[] value = e.getValue();
			if (value != null && value.length == 1) {
				sb.append(value[0]).append("&");
			} else {
				sb.append(Arrays.toString(value)).append("&");
			}
		}
		if (sb.length() >= 1) {
			if (sb.substring(sb.length() - 1, sb.length()).equals("&")) {
				sb.deleteCharAt(sb.length() - 1);
			}
		}
		return sb.toString();
	}
}
