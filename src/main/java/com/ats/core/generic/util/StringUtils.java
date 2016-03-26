package com.ats.core.generic.util;

import java.beans.Introspector;

import com.google.common.base.CaseFormat;

/**
 * 
 * StringUtilities.java
 * 
 * @author Wa'el Abu Rahmeh <waburahmeh@ats-ware.com>
 * @since Feb 26, 2015
 */

public class StringUtils {

	public static boolean isEmpty(String data) {
		if (data == null || data.trim().length() == 0) {
			return true;
		}
		return false;
	}

	public static boolean isNotEmpty(String data) {
		if (isEmpty(data)) {
			return false;
		}
		return true;
	}

	// convert from UTF-8 -> internal Java String format
	public static String convertFromUTF8(String s) {
		String out = null;
		try {
			out = new String(s.getBytes("ISO-8859-1"), "UTF-8");
		} catch (java.io.UnsupportedEncodingException e) {
			return s;
		}
		return out;
	}

	// convert from internal Java String format -> UTF-8
	public static String convertToUTF8(String s) {
		String out = null;
		try {
			out = new String(s.getBytes("UTF-8"), "ISO-8859-1");
		} catch (java.io.UnsupportedEncodingException e) {
			return s;
		}
		return out;
	}

	public static void validateNumber(String input) {
		if (isEmpty(input)) {
			throw new NumberFormatException();
		}
		try {
			Double.parseDouble(input);
		} catch (NumberFormatException e) {
			throw new NumberFormatException("Not a valid Number");
		}
	}

	public static String clearSpaces(String str) {
		return str.replaceAll("\\s","");
	}
	
	public static String lowerFirst(String str){
		return Introspector.decapitalize(str);
	}
	
	public static String toLowerCamelCase(String str){
		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);
	}
	public static String toUpperUnderscore(String str){
//		return CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, str);
		return CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, str); // returns "constantName"
	}
	
	public static String getTextStyleClass(String value) {
		if (StringUtils.isNotEmpty(value) && value.contains("::")) {
			String[] splitted = value.split("::");
			return "<span class='" + splitted[1] + "'>" + splitted[0] + "</span>";
		}

		return value;
	}

}
