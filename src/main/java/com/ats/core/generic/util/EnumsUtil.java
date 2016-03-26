package com.ats.core.generic.util;

/**
 * EnumsUtil.java, Used as a utility to handle Enumerations
 *
 * @author Ali Saleh <Ali@ats-ware.com>
 * @since Aug 13, 2014
 **/

public class EnumsUtil {

	/**
	 * A common method for all enums since they can't have another base class
	 *
	 * @param <T> Enum type
	 * @param c enum type. All enums must be all caps.
	 * @param string case insensitive
	 * @return corresponding enum, or null
	 */
	public static <T extends Enum<T>> T getEnumFromString(Class<T> c, String string) {
		if (c != null && string != null) {
			try {
				return Enum.valueOf(c, string.trim().toUpperCase());
			} catch (IllegalArgumentException ex) {
			}
		}

		return null;
	}
}
