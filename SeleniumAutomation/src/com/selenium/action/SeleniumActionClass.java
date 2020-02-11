package com.selenium.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.selenium.constants.Constants;
import com.selenium.util.GetClassName;
import com.selenium.util.LoggerConfig;
import com.selenium.util.ReadProperties;

public class SeleniumActionClass {
	
	public static WebDriver DRIVER = null;	
	//public static boolean IS_BROWSER_LAUNCHED = false;
	
	//public static Logger logger = Logger.getLogger(SeleniumActionClass.class);
	public static Logger logger = Logger.getLogger(new GetClassName().getClassName());
	public static String CONFIG_FILE_PATH = null; 

	public static WebDriver launchURL(List<String> details, int browserIndex, String url){ // Browser, URL
		
		try{
			logger.info("Enter into launchURL(List<String> details, int browserIndex) try block");
			LoggerConfig.logger();
			CONFIG_FILE_PATH = "src\\com\\selenium\\properties\\config.properties";
			Properties propertiesFile = ReadProperties.readPropertiesFile(CONFIG_FILE_PATH);
			
		if( details.get(browserIndex).equalsIgnoreCase("INTERNET_EXPLORER") ){
			logger.info("Launch IE Browser");			
			System.setProperty(propertiesFile.getProperty(Constants.IE_WEBDRIVER), propertiesFile.getProperty(Constants.IE_DRIVER_PATH));
			DRIVER = new InternetExplorerDriver();
			DRIVER.get(url);
			logger.info("launch URl: "+ url);
		}
		else if( details.get(browserIndex).equalsIgnoreCase("GOOGLE_CHROME") ){
			logger.info("Launch chrome Browser");
			System.setProperty(propertiesFile.getProperty(Constants.CHROME_WEBDRIVER), propertiesFile.getProperty(Constants.CHROME_DRIVER_PATH));
			DRIVER = new ChromeDriver();			
			DRIVER.get(url);
			logger.info("launch URl: "+ url);
		} 
		else if(details.get(browserIndex).equalsIgnoreCase("FIREFOX") ){
			logger.info("Launch Firefox Browser");
			System.setProperty(propertiesFile.getProperty(Constants.FIREFOX_WEBDERIVER), propertiesFile.getProperty(Constants.FIREFOX_DRIVER_PATH));
			DRIVER= new FirefoxDriver();
			DRIVER.get(url);
			logger.info("launch URl: "+ url);
		}
		//IS_BROWSER_LAUNCHED = true;
		
		logger.info("Exit from launchURL(List<String> details, int browserIndex) try block"); 
		
		}
		catch(Exception e){
			logger.error("Exter into launchURL(List<String> details, int browserIndex) catch block");
			//IS_BROWSER_LAUNCHED = false;
			logger.error("Exception found is "+ e);
			logger.error("Exit from launchURL(List<String> details, int browserIndex) catch block");
		}
		
		
		//logger.info("Browser launched ?" + IS_BROWSER_LAUNCHED);
		return DRIVER;
	}
	
	
public static WebDriver launchURL(int browserIndex, String url){ // Browser, URL
		List<String> selectBrowser = new ArrayList<String>();
		selectBrowser.add(Constants.INTERNET_EXPLORER); // 0
		selectBrowser.add(Constants.FIREFOX); // 1
		selectBrowser.add(Constants.GOOGLE_CHROME); // 2	|
		try{
			logger.info("Enter into launchURL(List<String> details, int browserIndex) try block");
			LoggerConfig.logger();
			CONFIG_FILE_PATH = "src\\com\\selenium\\properties\\config.properties";
			Properties propertiesFile = ReadProperties.readPropertiesFile(CONFIG_FILE_PATH);
			
		if( selectBrowser.get(browserIndex).equalsIgnoreCase("INTERNET_EXPLORER") ){
			logger.info("Launch IE Browser");			
			System.setProperty(propertiesFile.getProperty(Constants.IE_WEBDRIVER), propertiesFile.getProperty(Constants.IE_DRIVER_PATH));
			DRIVER = new InternetExplorerDriver();
			DRIVER.get(url);
			logger.info("launch URl: "+ url);
		}
		else if( selectBrowser.get(browserIndex).equalsIgnoreCase("GOOGLE_CHROME") ){
			logger.info("Launch chrome Browser");
			System.setProperty(propertiesFile.getProperty(Constants.CHROME_WEBDRIVER), propertiesFile.getProperty(Constants.CHROME_DRIVER_PATH));
			DRIVER = new ChromeDriver();			
			DRIVER.get(url);
			logger.info("launch URl: "+ url);
		} 
		else if(selectBrowser.get(browserIndex).equalsIgnoreCase("FIREFOX") ){
			logger.info("Launch Firefox Browser");
			System.setProperty(propertiesFile.getProperty(Constants.FIREFOX_WEBDERIVER), propertiesFile.getProperty(Constants.FIREFOX_DRIVER_PATH));
			DRIVER= new FirefoxDriver();
			DRIVER.get(url);
			logger.info("launch URl: "+ url);
		}
		//IS_BROWSER_LAUNCHED = true;
		
		logger.info("Exit from launchURL(List<String> details, int browserIndex) try block"); 
		
		}
		catch(Exception e){
			logger.error("Enter into launchURL(List<String> details, int browserIndex) catch block");
			//IS_BROWSER_LAUNCHED = false;
			logger.error("Exception found is "+ e);
			logger.error("Exit from launchURL(List<String> details, int browserIndex) catch block");
		}
		
		
		//logger.info("Browser launched ?" + IS_BROWSER_LAUNCHED);
		return DRIVER;
	}



}
