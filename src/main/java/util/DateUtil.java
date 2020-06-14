package main.java.util;

import java.text.SimpleDateFormat;

public class DateUtil {

	private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	
	public static SimpleDateFormat getDateFormat() {
		return dateFormat;
	}
	
}
