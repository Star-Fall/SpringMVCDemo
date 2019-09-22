package com.starfall.springmvc.demo.bean;

import java.io.Serializable;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo1.bean
 * @className Address
 * @date 2019/9/4 22:41
 * @description Address
 */
public class Address implements Serializable {
	private static final long serialVersionUID = 2824358958436724926L;
	private String province;
	private String city;

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "Address{" + "province='" + province + '\'' + ", city='" + city + '\'' + '}';
	}
}
