package com.ats.core.generic.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * PatternMatcherUtil.java, Used as a utility for pattern matching
 *
 * @author Ali Saleh <Ali@ats-ware.com>
 * @since Aug 13, 2014
 **/

public class PatternMatcherUtil {

	public static boolean isDatePart(String query) {
		Pattern pattern;
		Matcher matcher;

		final String DATE_PART_PATTERN = "(\\d*[^\\w]*\\d*)*";

		pattern = Pattern.compile(DATE_PART_PATTERN);
		matcher = pattern.matcher(query);

		return matcher.matches();
	}

	public static boolean isArabicText(String query) {
		query = query.replace(" ", "");// remove white spaces because its not Arabic !!!
		Pattern pattern;
		Matcher matcher;

		final String ARABIC_PATTERN = "(\\p{InArabic}+)";

		pattern = Pattern.compile(ARABIC_PATTERN);
		matcher = pattern.matcher(query);

		return matcher.matches();
	}

	public static boolean isValidEmail(String email) {
		Pattern pattern;
		Matcher matcher;

		final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

		pattern = Pattern.compile(EMAIL_PATTERN);
		matcher = pattern.matcher(email);

		return matcher.matches();
	}

}
