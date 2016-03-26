package com.ats.core.generic.util;

import java.math.BigDecimal;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * ConversionUtil.java, Used as a utility to handle Data conversion
 *
 * @author Ali Saleh <Ali@ats-ware.com>
 * @since Aug 13, 2014
 **/

public class ConversionUtil {

	/**
	 * Get integer value from string, or null otherwise
	 * 
	 * @param intValue
	 * @return
	 */
	public static Integer integerFromString(String intValue) {
		Integer in = null;
		try {
			in = Integer.parseInt(intValue);
		} catch (NumberFormatException e) {
			// Nothing important to catch
		}

		return in;
	}

	/**
	 * Get calendar day of the week from string
	 * 
	 * @param day
	 * @param locale
	 * @return
	 */
	public static int parseDayOfWeek(String day, Locale locale) {
		SimpleDateFormat dayFormat = new SimpleDateFormat("E", locale);
		int dayOfWeek = 0;
		try {
			Date date = dayFormat.parse(day);
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return dayOfWeek;
	}

	public static int convertJavaToSqlType(Class<?> returnType) {
		
		if (returnType == boolean.class || returnType == Boolean.class) {
			return Types.NUMERIC;
		}
		if (returnType == long.class || returnType == Long.class) {
			return Types.NUMERIC;
		}

		if (returnType == int.class || returnType == Integer.class) {
			return Types.NUMERIC;
		}

		if (returnType == short.class || returnType == Short.class) {
			return Types.NUMERIC;
		}

		if (returnType == double.class || returnType == Double.class) {
			return Types.NUMERIC;
		}

		if (returnType == float.class || returnType == Float.class) {
			return Types.NUMERIC;
		}

		return Types.VARCHAR;
	}

	public static Object convertSqlToJavaType(Object result, Class<?> returnType) {

		if (result.getClass() == BigDecimal.class) {// number
			BigDecimal number = (BigDecimal) result;

			if (returnType == boolean.class || returnType == Boolean.class) {
				return (number.intValue() == 1);
			}
			if (returnType == long.class || returnType == Long.class) {
				return number.longValue();
			}

			if (returnType == int.class || returnType == Integer.class) {
				return number.intValue();
			}

			if (returnType == short.class || returnType == Short.class) {
				return number.shortValue();
			}

			if (returnType == double.class || returnType == Double.class) {
				return number.doubleValue();
			}

			if (returnType == float.class || returnType == Float.class) {
				return number.floatValue();
			}
		}

		return result.toString();
	}
	//
	// public static Object convertSqlToJavaType(Object result, Class<?> returnType) {
	//
	// if (result.getClass() == BigDecimal.class) {// number
	// BigDecimal number = (BigDecimal) result;
	//
	// if (returnType == boolean.class || returnType == Boolean.class) {
	// return (number.intValue() == 1);
	// }
	// if (returnType == long.class || returnType == Long.class) {
	// return number.longValue();
	// }
	//
	// if (returnType == int.class || returnType == Integer.class) {
	// return number.intValue();
	// }
	//
	// if (returnType == short.class || returnType == Short.class) {
	// return number.shortValue();
	// }
	//
	// if (returnType == double.class || returnType == Double.class) {
	// return number.doubleValue();
	// }
	//
	// if (returnType == float.class || returnType == Float.class) {
	// return number.floatValue();
	// }
	// }
	//
	// return result.toString();
	// }

}
