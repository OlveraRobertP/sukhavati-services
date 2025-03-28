/**
 * 
 */
package com.sukhavati.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author jrobolvp
 *
 */
public class DateFormat {
	private static SimpleDateFormat sdfShort = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat sdfMedium = new SimpleDateFormat("dd 'de' MMM 'de' yyyy");
	private static SimpleDateFormat sdfLong = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat sdfFull = new SimpleDateFormat("yyyy-MM-dd");
	
	public static String toString(Date date, TypeFormatDate type) {
		if(date==null) return null;
		if(TypeFormatDate.SHORT.equals(type)) {
			return sdfShort.format(date);
		}else if(TypeFormatDate.MEDIUM.equals(type)) {
			return sdfMedium.format(date);
		}else if(TypeFormatDate.LONG.equals(type)) {
			return sdfLong.format(date);
		}
		return null;
	}

	public static Date toDate(String date, TypeFormatDate type) throws ParseException {
		if(date==null) return null;
		if(TypeFormatDate.SHORT.equals(type)) {
			return sdfShort.parse(date);
		}else if(TypeFormatDate.MEDIUM.equals(type)) {
			return sdfMedium.parse(date);
		}else if(TypeFormatDate.LONG.equals(type)) {
			return sdfLong.parse(date);
		}else if(TypeFormatDate.FULL.equals(type)) {
			return sdfFull.parse(date.substring(0, 10));
		}
		return null;
	}
}
