package com.starfall.springmvc.demo.controller;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.starfall.springmvc.demo.bean.Employee;
import com.starfall.springmvc.demo.bean.User;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo1.controller
 * @className ControllerDemo3
 * @date 2019/9/4 22:18
 * @description 数据绑定、数据转换、数据格式化、数据校验
 */
@RestController
@RequestMapping("/demo3")
public class ControllerDemo3 extends BaseController {

	@RequestMapping(value = "/testBinder", method = RequestMethod.POST)
	public String testBinder(User user) {
		return user.toString();
	}

	/**
	 * 测试Converter类型转换器，只需要DateConverter，删除InitBinder注解（两者都存在也可以）
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/testConverter", method = RequestMethod.GET)
	public String testConverter(User user) {
		return user.toString();
	}

	/**
	 * 测试InitBinder注解，只需要InitBinder，删除Converter类型转换器（两者都存在也可以）<br>
	 * BindingResult用于接收数据处理失败信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(value = "/testInitBinder", method = RequestMethod.GET)
	public String testInitBinder(User user, BindingResult result) {
		String msg = "";
		if (result.getErrorCount() > 0) {
			msg = "\n";
			for (FieldError fieldError : result.getFieldErrors()) {
				msg = msg + fieldError.getField() + "：" + fieldError.getDefaultMessage();
				System.out.println(fieldError.getField() + "：" + fieldError.getDefaultMessage());
			}
		}
		return user.toString() + msg;
	}

	/**
	 * 测试Formatting相关注解，只需要Formatting，删除Converter类型转换器、InitBinder注解（三者都存在也可以）
	 * 
	 * @param employee
	 * @param result
	 *            BindingResult用于接收数据处理失败信息
	 * @return
	 */
	@RequestMapping(value = "/testFormatting")
	public String testFormatting(Employee employee, BindingResult result) {
		String msg = "";
		if (result.getErrorCount() > 0) {
			msg = "\n";
			for (FieldError fieldError : result.getFieldErrors()) {
				msg = msg + fieldError.getField() + "：" + fieldError.getDefaultMessage();
				System.out.println(fieldError.getField() + "：" + fieldError.getDefaultMessage());
			}
		}
		return employee.toString() + msg;
	}
}
