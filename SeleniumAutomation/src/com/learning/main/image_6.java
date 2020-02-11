package com.learning.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.action.SeleniumActionClass;
import com.selenium.constants.Constants;
import com.selenium.util.LoggerConfig;

public class image_6 {
	public static WebDriver DRIVER= null;
	public static Logger logger = Logger.getLogger(image_6.class);
	public static void main(String[] args) {
		try{
		LoggerConfig.logger();  //write log in external file / console
		logger.info("Enter into Main() try block");
		List<String> browsers = new ArrayList<String>();
		int browserIndex = 2;
		String url = "http://demo.guru99.com/test/newtours/";
		browsers.add(Constants.INTERNET_EXPLORER); // 0
		browsers.add(Constants.FIREFOX); // 1
		browsers.add(Constants.GOOGLE_CHROME); // 2	|
		
		DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, url);
		if(DRIVER != null){
			WebElement imageElement = DRIVER.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img"));
			logger.info("image isDisplayed() ? " + imageElement.isDisplayed()); //true
			logger.info("image isEnabled() ? " + imageElement.isEnabled()); // true
		}
		else{
			logger.error("Driver is null");
		}
		
		logger.info("Exit fromMain() try block");
		}
		catch(Exception e){
			logger.error("Enter into catch(Exception e) block");
			logger.error("Exception found " + e);
			logger.error("Exit catch(Exception e) block");
		}
		finally{
			DRIVER.close();
			DRIVER.quit();
		}
		logger.info("Exit from Main()");
	}

}
