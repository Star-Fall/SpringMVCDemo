package com.starfall.springmvc.demo.controller;

import com.starfall.springmvc.demo.bean.ParamBean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo1.controller
 * @className ControllerDemo1
 * @date 2019/8/18 23:50
 * @description 测试RequestMapping、请求参数
 */
@RestController
@RequestMapping(path = "/demo1")
public class ControllerDemo1 {

	@RequestMapping(value = "/testRestGet", method = RequestMethod.GET)
	// @GetMapping(value = "/testRestGet")
	public String testRestGet() {
		return "testRestGet";
	}

	@RequestMapping(value = "/testRestPost", method = RequestMethod.POST)
	public String testRestPost() {
		return "testRestPost";
	}

	@RequestMapping(value = "/testRestDelete", method = RequestMethod.DELETE)
	public String testRestDelete() {
		return "testRestDelete";
	}

	@RequestMapping(value = "/testRestPut", method = RequestMethod.PUT)
	public String testRestPut() {
		return "testRestPut";
	}

	@RequestMapping(value = "/testRequestMapping1", params = { "param0", "param1!=122", "!p" })
	public String testRequestMapping1(String param0, String param1) {
		return "testRequestMapping1 params = {" + param0 + "," + param1 + "}";
	}

	@RequestMapping(value = "/testRequestMapping2", headers = { "Accept=*/*", "X-Requested-With=XMLHttpRequest" })
	public String testRequestMapping2() {
		return "testRequestMapping2";
	}

	@RequestMapping(value = "/testRequestMapping3", consumes = { "application/json" })
	public String testRequestMapping3() {
		return "testRequestMapping3";
	}

	@RequestMapping(value = "/testRequestMapping4", produces = { "text/plain;charset=UTF-8" })
	public String testRequestMapping4() {
		return "testRequestMapping4 中文信息";
	}

	@RequestMapping(value = { "/testPathVariable/{param}", "/testPathVariable/" }, method = RequestMethod.GET)
	public String testPathVariable(@PathVariable(required = false) String param) {
		return "testPathVariable param = " + param;
	}

	@RequestMapping(value = "/testPathVariable/{param1}/{param2}", method = RequestMethod.GET)
	public String testPathVariable(@PathVariable("param1") String param1, @PathVariable("param2") Integer param2) {
		return "testPathVariable param1 = " + param1 + " , param2 = " + param2;
	}

	@RequestMapping(value = "/testRequestParam0", method = RequestMethod.GET)
	public String testRequestParam1(String param1, Integer param2, BigDecimal param3) {
		return "testRequestParam param = {" + param1 + "," + param2 + "," + param3 + "}";
	}

	@RequestMapping(value = "/testRequestParam1", method = RequestMethod.GET)
	public String testRequestParam2(@RequestParam(name = "param1", defaultValue = "defaultParam1") String param1,
			@RequestParam(name = "paramInt") Integer param2) {
		return "testRequestParam param = {" + param1 + "," + param2 + "}";
	}

	@RequestMapping(value = "/testRequestHeader")
	public String testRequestHeader(@RequestHeader("Content-Type") String contentType,
			@RequestHeader("User-Agent") String userAgent) {
		return "testRequestHeader \n ContentType = " + contentType + "\n User-Agent =" + userAgent;
	}

	@RequestMapping("/testCookieValue")
	public String testCookieValue(@CookieValue("JSESSIONID") String JSESSIONID) {
		return "testCookieValue JSESSIONID = " + JSESSIONID;
	}

	@RequestMapping(value = "/testRequestBody", method = RequestMethod.POST)
	public String testRequestBody(@RequestBody ParamBean paramBean) {
		return "testRequestBody param : " + paramBean.toString();
	}

	@RequestMapping(value = "/testPojo", method = RequestMethod.GET)
	public String testPojo(ParamBean paramBean) {
		return "testPojo param : " + paramBean.toString();
	}

	@RequestMapping(value = "/testServletAPI")
	public String testServletAPI(HttpServletRequest request, HttpServletResponse response) {
		// 1、使用API作为参数
		// 2、获取请求对象
		HttpServletRequest request2 = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		// 3、使用SpringMVC的web工具类实现session的读写，需要先获取请求对象
		HttpServletRequest request3 = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes())
				.getRequest();
		WebUtils.setSessionAttribute(request3, "test2", "sessionValue2");
		WebUtils.getSessionAttribute(request, "test2");
		return "testServletAPI";
	}

}
