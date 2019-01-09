package com.haeyoum.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	private SimpleDateFormat format;
	
	public String convertDate(Date date) {
		format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}
	public String convertDayTime(Date date) {
		format = new SimpleDateFormat("MM-dd / HH:mm");
		return format.format(date);
	}
	public String convertDay(Date date) {
		format = new SimpleDateFormat("dd");
		return format.format(date);
	}
	public String convertTime(Date date) {
		format = new SimpleDateFormat("HH:mm");
		return format.format(date);
	}
	
	public Date convertString(String birthday) {
		format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			return format.parse(birthday);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}
	
}
