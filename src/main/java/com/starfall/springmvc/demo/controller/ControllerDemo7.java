package com.starfall.springmvc.demo.controller;

import com.starfall.springmvc.demo.exception.SystemException;
import com.starfall.springmvc.response.ApiResult;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo.controller
 * @className ControllerDemo7
 * @date 2019/9/21 10:31
 * @description 异常处理
 */
@Controller
@RequestMapping("/demo7")
public class ControllerDemo7 extends BaseController {

	/**
	 * 测试@ExceptionHandler注解，包括本Controller中、BaseController中、@ControllerAdvice注释的类中
	 * 
	 * @return ApiResult
	 */
	@ResponseBody
	@RequestMapping("/testExceptionHandler")
	public Map<String, Object> testExceptionHandler() {
		double a = 10 / 0;
		return ApiResult.SUCCESS.getMap();
	}

	/**
	 * 测试@ResponseStatus注解，需要抛出SystemException异常，返回指定的响应Code、reason
	 * 
	 * @param param
	 * @return ApiResult
	 * @throws SystemException
	 */
	@ResponseBody
	@RequestMapping("/testResponseStatus")
	public Map<String, Object> testResponseStatus(String param) throws SystemException {
		if (param == null) {
			throw new SystemException("测试异常注解：@ResponseStatus注解");
		}
		return ApiResult.SUCCESS.getMap();
	}

	/**
	 * 测试@ResponseStatus注解，@ResponseStatus+@ExceptionHandler注释异常处理方法，返回指定响应信息
	 * 
	 * @return ApiResult
	 */
	@ResponseBody
	@RequestMapping("/testResponseStatus2")
	public Map<String, Object> testResponseStatus2() {
		double a = 10 / 0;
		return ApiResult.SUCCESS.getMap();
	}

	/**
	 * 测试HandlerExceptionResolver接口，包括自定义实现类、SimpleMappingExceptionResolver
	 * 
	 * @return ApiResult
	 */
	@ResponseBody
	@RequestMapping("/testHandlerExceptionResolver")
	public Map<String, Object> testHandlerExceptionResolver() {
		double a = 10 / 0;
		return ApiResult.SUCCESS.getMap();
	}

	/**
	 * 测试@ControllerAdvice修饰的全局处理异常类
	 * 
	 * @param param
	 * @return ApiResult
	 */
	@ResponseBody
	@RequestMapping(value = "/testControllerAdvice", method = RequestMethod.GET)
	public Map<String, Object> testControllerAdvice(String param) {
		if (param == null) {
			throw new HttpMessageNotReadableException("test HttpMessageNotReadableException");
		}
		return ApiResult.SUCCESS.getMap();
	}

	/**
	 * 用于测试@ExceptionHandler
	 * 
	 * @param ex
	 *            Exception
	 * @return ApiResult
	 */
	@ResponseBody
	@ExceptionHandler
	public Map<String, Object> handlerException(Exception ex) {
		System.out.println(ApiResult.ERROR.getMap(ex.toString()));
		return ApiResult.ERROR.getMap(ex.toString()).add("otherMsg","ControllerDemo7.handlerException");
	}

	/**
	 * 用于测试@ExceptionHandler 优先级
	 * 
	 * @param ex
	 *            Exception
	 * @return ApiResult
	 */
	@ResponseBody
	@ExceptionHandler({ ArithmeticException.class })
	public Map<String, Object> handlerException2(Exception ex) {
		return ApiResult.ERROR.getMap(ex.toString()).add("otherMsg","ControllerDemo7.handlerException2");
	}

	// 注释原因:有两个相同Exceptionhandler，处理ArithmeticException
	// /**
	// * 用于测试@ExceptionHandler+ @ResponseStatus
	// *
	// * @param ex
	// * Exception
	// * @return ApiResult
	// */
	// @ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "测试404")
	// @ExceptionHandler({ ArithmeticException.class, RuntimeException.class })
	// public Map<String, Object> handlerException3(Exception ex) {
	// return ApiResult.ERROR.getMap(ex.toString());
	// }
}