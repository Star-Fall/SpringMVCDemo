package com.starfall.springmvc.demo.controller;

import com.starfall.springmvc.demo.bean.Employee;
import com.starfall.springmvc.response.ApiResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo.controller
 * @className ControllerDemo4
 * @date 2019/9/8 16:55
 * @description 测试JSON
 */
@RestController
@RequestMapping("/demo4")
public class ControllerDemo4 extends BaseController {

	@RequestMapping("/testJSON")
	public Map<String, Object> testJSON() throws Exception {
		if (1 == 1) {
			throw new IndexOutOfBoundsException("JSON 异常");
		}
		List<Employee> list = new ArrayList<>();
		list.add(new Employee(1, "Tome", new Date(), 1000d));
		list.add(new Employee(2, "Tome2", new Date(), 1000d));
		list.add(new Employee(3, "Tome3", new Date(), 1000d));
		list.add(new Employee(4, "张三", new Date(), 1000d));
		list.add(new Employee(5, "李四", new Date(), 1000d));
		return ApiResult.SUCCESS.getMap().add("list", list);
	}
}
