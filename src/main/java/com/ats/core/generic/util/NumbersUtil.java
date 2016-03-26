package com.ats.core.generic.util;

import java.math.BigDecimal;

public class NumbersUtil {

	/**
	 *
	 * @param num value to be compared
	 * @param firstVal the smallest value (first value)
	 * @param secondVal the biggest value (Second value)
	 * @return true if number is between two value or equal to anyone of them.
	 */
	public static boolean numberIsBetween(BigDecimal num, BigDecimal firstVal, BigDecimal secondVal) {

		return (num.compareTo(firstVal) == 0 || num.compareTo(firstVal) == -1) && (num.compareTo(secondVal) == 0 || num.compareTo(secondVal) == 1);
	}

}
