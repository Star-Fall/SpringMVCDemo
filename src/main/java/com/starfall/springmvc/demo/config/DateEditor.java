package com.starfall.springmvc.demo.config;

import java.beans.PropertyEditorSupport;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author StarFall
 * @project SpringMVCDemo
 * @package com.starfall.springmvc.demo.config
 * @className DateEditor
 * @date 2019/9/7 21:03
 * @description 基于传统的PropertyEditor来实现日期类型的数据绑定
 */
public class DateEditor extends PropertyEditorSupport {

	/**
	 * Date日期转字符串，用于获取bean的属性值
	 * 
	 * @return 字符串格式的日期
	 */
	@Override
	public String getAsText() {
		Date date = (Date) getValue();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
		String text = format.format(date);
		return text;
	}

	/**
	 * 字符串转Date日期，用于设置bean的属性值
	 * 
	 * @param text
	 *            字符串格式的日期
	 * @throws IllegalArgumentException
	 */
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
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
		setValue(date);
	}
}
