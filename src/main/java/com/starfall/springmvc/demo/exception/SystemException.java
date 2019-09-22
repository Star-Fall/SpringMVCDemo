package com.starfall.springmvc.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo.exception
 * @className SystemException
 * @date 2019/9/21 18:35
 * @description SystemException 自定义的异常类,@ResponseStatus用于设置响应状态
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "测试404")
public class SystemException extends Exception {

	private static final long serialVersionUID = -5459963461375545496L;

	public SystemException() {
		super();
	}

	public SystemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public SystemException(String message, Throwable cause) {
		super(message, cause);
	}

	public SystemException(String message) {
		super(message);
	}

	public SystemException(Throwable cause) {
		super(cause);
	}
}
