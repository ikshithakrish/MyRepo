package com.selenium.util;

import java.io.File;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class LoggerConfig {

	public static Logger logger = Logger.getLogger(LoggerConfig.class);
	public static final String FILE_PATH = "src\\com\\selenium\\properties\\log4j.properties";
	

	/**
	 * logger()
	 * configure to store the logs in the specified file path in log4j.properties
	 */
	
	public static void logger() {
		logger.info("Enter into logger()");
		String log4jConfFile = System.getProperty("user.dir") + File.separator + FILE_PATH;
		logger.info(File.separator); // File.seperator - \ backslash			
		logger.info(log4jConfFile); // D:\My Assignments\Eclipse_Mars\SeleniumAutomation\src\com\selenium\properties\log4j.properties
		PropertyConfigurator.configure(log4jConfFile);
		logger.info("Exit from logger()");
	}

}
