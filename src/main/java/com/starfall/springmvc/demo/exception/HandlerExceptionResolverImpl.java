package com.starfall.springmvc.demo.exception;

import com.starfall.springmvc.response.ApiResult;
import com.starfall.springmvc.response.ApiResultMap;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo.exception
 * @className HandlerExceptionResolverImpl
 * @date 2019/9/21 21:54
 * @description HandlerExceptionResolver:基于HandlerExceptionResolver接口的全局异常处理类
 */
@Component
public class HandlerExceptionResolverImpl implements HandlerExceptionResolver {
	/**
	 * 异常处理方法
	 * 
	 * @param request
	 *            HttpServletRequest
	 * @param response
	 *            HttpServletResponse
	 * @param handler
	 *            Object
	 * @param ex
	 *            Exception
	 * @return ModelAndView
	 */
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		/**
		 * 方式一：正常返回ModelAndView
		 */
		// ModelAndView modelAndView = new ModelAndView();
		// modelAndView.setViewName("error.jsp");
		// modelAndView.addObject("exception", ex.getMessage());

		/**
		 * 方式二：返回JSON，格式化JSP页面，变相返回JSON
		 */
		// ApiResultMap<String, Object> map = ApiResult.ERROR.getMap(ex.getMessage());
		// JSONObject jsonObject = new JSONObject(map);
		// ModelAndView modelAndView = new ModelAndView();
		// modelAndView.setViewName("error.jsp");
		// modelAndView.addObject("exception", jsonObject);

		/**
		 * 方式三：返回JSON，使用MappingJackson2JsonView对象
		 */
		ApiResultMap<String, Object> map = ApiResult.ERROR.getMap(ex.getMessage()).add("otherMsg",
				"HandlerExceptionResolverImpl");
		ModelAndView modelAndView = new ModelAndView(new MappingJackson2JsonView(), map);
		return modelAndView;
	}
}