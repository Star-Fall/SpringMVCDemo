package com.starfall.springmvc.demo.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo.util
 * @className DateUtil
 * @date 2019/9/6 23:37
 * @description DateUtil
 */
public class DateUtil {

	public static Date fomatterDate(String text) {
		SimpleDateFormat format = null;
		Date date = null;
		try {
			format = new SimpleDateFormat("yyyy-MM-dd");
			date = format.parse(text);
		} catch (ParseException e) {
			try {
				format = new SimpleDateFormat("yyyyMMdd");
				date = format.parse(text);
			} catch (ParseException e1) {
				try {
					format = new SimpleDateFormat("yyyy/MM/dd");
					date = format.parse(text);
				} catch (ParseException e2) {
					e2.printStackTrace();
				}
			}
		}

		return date;
	}

	public static void main(String[] args) {
		System.out.println(fomatterDate("2019/12-12"));
	}
}
