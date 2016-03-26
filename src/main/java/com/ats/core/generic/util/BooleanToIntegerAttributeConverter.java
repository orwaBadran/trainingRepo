package com.ats.core.generic.util;

import javax.persistence.AttributeConverter;

/**
 * BooleanToIntegerAttributeConverter.java, Used to convert entity attribute value from integer to boolean and vice versa
 * 
 * @author Mohammad Ghanem (mghanem@ats-ware.com)
 * @since 10/11/2014
 *
 */
public class BooleanToIntegerAttributeConverter implements AttributeConverter<Boolean, Integer> {

	@Override
	public Integer convertToDatabaseColumn(Boolean attribute) {
		return (attribute != null && attribute) ? 1 : 0;
	}

	@Override
	public Boolean convertToEntityAttribute(Integer dbData) {
		return (dbData == null || dbData == 0) ? false : true;
	}

}
