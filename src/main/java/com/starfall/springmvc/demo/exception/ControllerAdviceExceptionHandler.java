package com.starfall.springmvc.demo.exception;

import com.starfall.springmvc.response.ApiResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import java.util.Map;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo.exception
 * @className ControllerAdviceExceptionHandler
 * @date 2019/9/22 0:08
 * @description ControllerAdvice：@ControllerAdvice+@ExceptionHandler全局异常控制器
 */
@ControllerAdvice
public class ControllerAdviceExceptionHandler {

	/**
	 * 处理ArithmeticException异常
	 * 
	 * @param ex
	 *            ArithmeticException
	 * @return ApiResult
	 */
	@ResponseBody
	@ExceptionHandler({ ArithmeticException.class })
	public Map<String, Object> handleArithmeticException(ArithmeticException ex) {
		return ApiResult.ERROR.getMap(ex.toString()).add("otherMsg",
				"ControllerAdviceExceptionHandler.handleArithmeticException()");
	}

	/**
	 * 处理自定义的SystemException异常
	 *
	 * @param ex
	 *            SystemException
	 * @return ApiResult
	 */
	@ResponseBody
	@ExceptionHandler({ SystemException.class })
	public Map<String, Object> handleSystemException(SystemException ex) {
		return ApiResult.ERROR.getMap(ex.toString()).add("otherMsg",
				"ControllerAdviceExceptionHandler.handleException()");
	}

	/**
	 * 处理文件上传过大异常
	 * 
	 * @param ex
	 *            MaxUploadSizeExceededException
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler({ MaxUploadSizeExceededException.class })
	public Map<String, Object> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex) {
		return ApiResult.ERROR.getMap("文件过大")
				.add("otherMsg", "ControllerAdviceExceptionHandler.handleMaxUploadSizeExceededException()")
				.add("exception", ex.toString());
	}

	/**
	 * 处理 Exception 异常
	 * 
	 * @param ex
	 *            Exception
	 * @return ApiResult
	 */
	@ResponseBody
	@ExceptionHandler({ Exception.class })
	public Map<String, Object> handleException(Exception ex) {
		return ApiResult.ERROR.getMap(ex.toString()).add("otherMsg",
				"ControllerAdviceExceptionHandler.handleException()");
	}
}
