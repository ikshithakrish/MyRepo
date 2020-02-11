package com.learning.action;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.selenium.util.LoggerConfig;

public class SeleniumActions {
	
	public final static String IE_WEBDRIVER = "webdriver.ie.driver";
	public final static String IE_DRIVER_PATH = "D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\IE Version 11\\IEDriverServer.exe";
	
	public final static String CHROME_WEBDRIVER = "webdriver.chrome.driver";	
	public final static String CHROME_DRIVER_PATH = "D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\ChromeVersion 75.0.3770.142 (Official Build) (32-bit)\\chromedriver.exe";
	
	public static boolean BROWSER_LAUNCHED = false;
	
	public final static String URL = "http://demo.guru99.com/test/newtours/";
	public static WebDriver DRIVER = null;
	
	public static Logger logger = Logger.getLogger(SeleniumActions.class);

	public static boolean launchURL(List<String> details){ // Browser, URL
		try{
			LoggerConfig.logger(); // write log in external file / console
		if( details.get(0).equalsIgnoreCase("IE") ){
			System.out.println("Enter into IE");
			System.setProperty(IE_WEBDRIVER, IE_DRIVER_PATH);
			DRIVER = new InternetExplorerDriver();
		}
		else if( details.get(0).equalsIgnoreCase("CHROME") ){
			logger.info("Enter into chorme");
			System.setProperty(CHROME_WEBDRIVER, CHROME_DRIVER_PATH);
			DRIVER = new ChromeDriver();
		}		
        
		
        DRIVER.get(details.get(1));
        
        BROWSER_LAUNCHED = true;
		}
		catch(Exception e){
			BROWSER_LAUNCHED = false;
		}
	
		return true;
	}
	
	public static boolean clickAction(List<String> details){
		try{
			if(details.get(2).equals("byXpath")){				
				// DRIVER.findElement(By.xpath(details.get(3))).click();
				if(DRIVER.findElements(By.xpath(details.get(3))) != null){
					DRIVER.findElement(By.xpath(details.get(3))).click(); // DRIVER.findElement(By.xpath("//div/div/div/div[1]/div/div/a/img")).click();
				}									
			}
			else if(details.get(2).equals("byId")){
				if(DRIVER.findElements(By.id(details.get(3))) != null){
				DRIVER.findElement(By.id(details.get(3))).click(); // DRIVER.findElement(By.xpath("//div/div/div/div[1]/div/div/a/img")).click();
			}
		}
		}
		catch(Throwable e){
			System.out.println("Exception found in clickAction(List)--- " + e);
		}
		
		return true;
	}
	
	public static boolean elementExist(List<String> details){
		//if(DRIVER.findElements(details.get(2)))
		return true;
	}
	
	public static void sessionEnd(WebDriver driver){
		try{
			LoggerConfig.logger(); // write log in external file / console
			logger.info("Driver in try block **** "+ driver);
			if(driver != null ){
				driver.close();
				driver.quit();
				}
				else{
					logger.info("Webdriver is null");
				}
		}
		catch(Exception e){
			logger.info("Driver in catch block **** "+ driver);
			logger.error("Exception in sessionEnd(***) " + e);
		}
		
	}
}
