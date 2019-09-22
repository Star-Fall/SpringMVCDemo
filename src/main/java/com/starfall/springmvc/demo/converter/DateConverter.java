package com.starfall.springmvc.demo.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo.converter
 * @className DateConverter
 * @date 2019/9/6 23:32
 * @description DateConverter：日期转换器，字符串日期根据格式转换为Date
 */
@Component
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String text) {
		Date date = null;
		if (text != null && !"".equals(text.trim())) {
			SimpleDateFormat format = null;
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
						date = null;
					}
				}
			}
		}
		return date;
	}
}
