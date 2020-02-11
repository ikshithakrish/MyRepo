package com.selenium.util;

import java.util.Properties;

import org.apache.log4j.Logger;

public class ObjectRepo_Reader {
	public static Logger LOGGER = Logger.getLogger(LoggerConfig.class);
	public static final String FILE_PATH = "src\\com\\selenium\\properties\\objectRepository.properties";
	public static String OBJECT_REPO_VALUE = null;
	
	public static String objectRepo_Search(String searchObject){
		try{
			LOGGER.info("ENTER into objectRepo_Search(String searchObject) try block" );
			Properties propertiesFile = ReadProperties.readPropertiesFile(FILE_PATH);
			OBJECT_REPO_VALUE = propertiesFile.getProperty(searchObject);
			LOGGER.info("EXIT from objectRepo_Search(String searchObject) try block" );
		}
		catch(Exception e){
			LOGGER.warn("ENTER into objectRepo_Search(String searchObject) catch block" );
			LOGGER.error("Exception found ---- " + e);
			LOGGER.warn("EXIT from objectRepo_Search(String searchObject) catch block" );
		}		
		return OBJECT_REPO_VALUE;
	}
	
	
}
