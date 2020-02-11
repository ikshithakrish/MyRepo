package com.selenium.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

public class ReadProperties {
	public static Logger logger = Logger.getLogger(ReadProperties.class);

	public static Properties readPropertiesFile(String filePath) {
		Properties prop = new Properties();
		LoggerConfig.logger(); // to write logs into the configured logger
		try {
			logger.info("Enter into readPropertiesFile()");
			FileInputStream readPropertyFile = new FileInputStream(filePath);
			prop.load(readPropertyFile);
			logger.info("Exit from readPropertiesFile()");
		} catch (IOException e) {
			logger.info("Exception found in readPropertiesFile() - catch() " + e);
		}
		return prop;
	}

}
