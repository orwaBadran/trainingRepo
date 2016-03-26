package com.ats.core.generic.util;

import org.apache.log4j.Logger;

public class ATSLogger {

	Logger logger;

	public ATSLogger(String name) {
		logger = Logger.getLogger(name);
	}

	@SuppressWarnings("rawtypes")
	public ATSLogger(Class clazz) {
		logger = Logger.getLogger(clazz);
	}

	public void log(String msg) {
		logger.info(msg);
	}

	public void error(String msg, Object... params) {
		StringBuilder logMsg = new StringBuilder(msg);
		for (Object object : params) {
			logMsg.append("\n");
			logMsg.append(object);
		}

		logger.error(logMsg.toString());
	}

	public void error(Exception ex, Object... params) {
		error(ex.getMessage(), params);
	}

}
