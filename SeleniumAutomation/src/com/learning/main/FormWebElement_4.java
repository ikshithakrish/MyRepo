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

public class FormWebElement_4 {
/*
 *     findElement() – finds a single web element and returns as a WebElement object.
    	findElements() – returns a list of WebElement objects matching the locator criteria.
    	
    	Locators
    	By.id(), By.name(), By.xpath(), By.CSSSelector() etc.
    	
    	Note: 
    	login.click() -- click() is applicable for button, link, submit button
    	login.submit() -- submit() is applicable only for submit button / any element inside a form?????
 */
	public static WebDriver DRIVER = null;
	public static Logger logger = Logger.getLogger(FormWebElement_4.class);
	public static void main(String[] args) {
		try{
			LoggerConfig.logger(); // write log in external file / console
			logger.info("Enter into main() try block");
			
			List<String> browsers = new ArrayList<String>();
			int browserIndex = 2;
			//String url = "http://demo.guru99.com/test/ajax.html";
			String url = "http://demo.guru99.com/test/newtours/";
			browsers.add(Constants.INTERNET_EXPLORER); // 0
			browsers.add(Constants.FIREFOX); // 1
			browsers.add(Constants.GOOGLE_CHROME); // 2	|
			
			DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, url);
			if(DRIVER != null){	
				logger.info("findElements..........." + DRIVER.findElements(By.name("userName")));
				// findElements...........[[[ChromeDriver: chrome on XP (7a8d8576445cb3d7752eb66e8499dce7)] -> name: userName]]
				WebElement userName = DRIVER.findElement(By.name("userName"));			
				userName.sendKeys("test1");
				userName.clear();
				WebElement loginSubmit =  DRIVER.findElement(By.cssSelector("input[name=submit][value=Login]"));
				//loginSubmit.click();
				loginSubmit.submit();   // both are working submit & click even its not a submitButton ???????
			}
		}
		catch(Exception e){
			
		}
		finally{
			DRIVER.close();
			DRIVER.quit();
		}

	}

}
