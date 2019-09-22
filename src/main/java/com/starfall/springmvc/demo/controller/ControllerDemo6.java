package com.starfall.springmvc.demo.controller;

import com.starfall.springmvc.response.ApiResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo.controller
 * @className ControllerDemo6
 * @date 2019/9/16 22:36
 * @description 拦截器
 */
@RestController
@RequestMapping("/demo6")
public class ControllerDemo6 {

	/**
	 * 测试单个拦截器
	 * 
	 * @return msg
	 */
	@RequestMapping("/testInterceptor")
	public Map<String, Object> testInterceptor() {
		System.out.println("Controller：testInterceptor");
		return ApiResult.SUCCESS.getMap().add("data", "Controller：testInterceptor");
	}

	/**
	 * 测试多个拦截器
	 * 
	 * @return msg
	 */
	@RequestMapping("/testInterceptors")
	public Map<String, Object> testInterceptors() {
		System.out.println("Controller：testInterceptors");
		return ApiResult.SUCCESS.getMap().add("data", "Controller：testInterceptors");
	}
}