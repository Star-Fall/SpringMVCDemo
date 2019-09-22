package com.starfall.springmvc.demo.controller;

import com.starfall.springmvc.demo.config.DateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.util.Date;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo.controller
 * @className BaseController
 * @date 2019/9/7 18:23
 * @description BaseController
 */
public class BaseController {

	/**
	 * initBinder 初始化Binder,转换日期格式、字符串去空
	 *
	 * @param binder
	 *            WebDataBinder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
		binder.registerCustomEditor(Date.class, new DateEditor());
	}
	// 注释原因：全局统一异常暂时使用@ControllerAdvice方式
	// /**
	// * BaseController 中定义的异常：全局Controller中处理
	// *
	// * @param ex
	// * Exception
	// * @return ApiResult
	// */
	// @ResponseBody
	// @ExceptionHandler({ Exception.class })
	// public Map<String, Object> handlerException(Exception ex) {
	// ex.printStackTrace();
	// return ApiResult.ERROR.getMap(ex.getMessage()).add("otherMsg",
	// "BaseController.handlerException");
	// }

}
