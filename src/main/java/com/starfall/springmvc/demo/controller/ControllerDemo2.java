package com.starfall.springmvc.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo1.controller
 * @className ControllerDemo2
 * @date 2019/8/27 21:37
 * @description ControllerDemo2 模型数据与视图，对应视图为：main2.jsp
 */
@RequestMapping("/demo2")
@Controller
public class ControllerDemo2 {

	@RequestMapping(value = "/testServletAPI")
	public String testServletAPI(HttpServletRequest request) {
		request.setAttribute("className", "HttpServletResponse response");
		return "main2.jsp";
	}

	@RequestMapping(value = "/testModelAndView")
	public ModelAndView testModelAndView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("time", new Date());
		modelAndView.addObject("map", Arrays.asList("modelAndView", "Jerry", "Mike"));
		modelAndView.addObject("className", modelAndView.getClass().getName());
		modelAndView.setViewName("main2.jsp");
		return modelAndView;
	}

	@RequestMapping("/testMap")
	public String testMap(Map<String, Object> map) {
		map.put("map", Arrays.asList("map", "Jerry", "Mike"));
		map.put("className", map.getClass().getName());
		return "main2.jsp";
	}

	@RequestMapping("/testModel")
	public String testModel(Model model) {
		model.addAttribute("model", Arrays.asList("model", "Jerry", "Mike"));
		model.addAttribute("className", model.getClass().getName());
		return "main2.jsp";
	}

	@RequestMapping("/testModelMap")
	public String testModelMap(ModelMap modelMap) {
		modelMap.addAttribute("modelMap", Arrays.asList("modelMap", "Jerry", "Mike"));
		modelMap.put("className", modelMap.getClass().getName());
		return "main2.jsp";
	}

}