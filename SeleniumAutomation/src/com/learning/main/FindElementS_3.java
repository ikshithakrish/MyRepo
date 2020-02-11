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

public class FindElementS_3 {

	public static Logger logger = Logger.getLogger(Locators_2.class);
	public static WebDriver DRIVER = null;
	/*
	 * FindElement:
	 * 		1. Returns the first most web element if there are multiple web elements found with the same locator 
	 *		 2. Throws exception NoSuchElementException if there are no elements matching the locator strategy 
	 * 		3. It will only find one web element
	 * 		4. Not Applicable
	 * FindElements:
	 * 		1. Returns a list of web elements 
	 * 		2. Returns an empty list if there are no web elements matching the locator strategy 
	 *		 3. It will find a collection of elements whose match the locator strategy. 
	 *		 4. Each Web element is indexed with a number starting from 0 just like an array 
	 */
	
	public static void main(String[] args) {

		try{
			LoggerConfig.logger(); // write log in external file / console
			logger.info("Enter into main() try block");
			
			List<String> browsers = new ArrayList<String>();
			int browserIndex = 2;
			String url = "http://demo.guru99.com/test/newtours/";
			browsers.add(Constants.INTERNET_EXPLORER); // 0
			browsers.add(Constants.FIREFOX); // 1
			browsers.add(Constants.GOOGLE_CHROME); // 2	|
			
			DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, url);
			if(DRIVER != null){	
				//List<WebElement> elements = DRIVER.findElements(By.name("name"));
				logger.info("****" +DRIVER.findElement(By.cssSelector("a")).getText()); //****  (first anchor tag not having text)
				List<WebElement> anchorElements = DRIVER.findElements(By.cssSelector("a"));  // looking for anchor tags
			   logger.info("Number of elements:" +anchorElements.size());

			    for (int i=0; i<anchorElements.size();i++){
			    	logger.info(anchorElements.get(i).getText() + " link href is " + anchorElements.get(i).getAttribute("href") + "and style is " + anchorElements.get(i).getAttribute("style"));
			    	
			    	/*
			    	 * INFO    2019-09-18 20:56:45,586 [main] com.learning.main.Locators_2  - Number of elements:46
						INFO    2019-09-18 20:56:45,731 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/newtours/#and style is border: medium none;
						INFO    2019-09-18 20:56:45,851 [main] com.learning.main.Locators_2  - Demo Site link href is http://demo.guru99.com/test/newtours/#and style is font-size: 32px;
						INFO    2019-09-18 20:56:45,970 [main] com.learning.main.Locators_2  - Selenium link href is http://demo.guru99.com/test/newtours/#and style is 
						INFO    2019-09-18 20:56:46,095 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/flash-testing.htmland style is 
						INFO    2019-09-18 20:56:46,469 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/radio.htmland style is 
						INFO    2019-09-18 20:56:46,599 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/table.htmland style is 
						INFO    2019-09-18 20:56:46,755 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/link.htmland style is 
						INFO    2019-09-18 20:56:46,911 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/ajax.htmland style is 
						INFO    2019-09-18 20:56:47,036 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/block.htmland style is 
						INFO    2019-09-18 20:56:47,158 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/delete_customer.phpand style is 
						INFO    2019-09-18 20:56:47,516 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/yahoo.htmland style is 
						INFO    2019-09-18 20:56:47,626 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/tooltip.htmland style is 
						INFO    2019-09-18 20:56:47,767 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/upload/and style is 
						INFO    2019-09-18 20:56:47,892 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/login.htmland style is 
						INFO    2019-09-18 20:56:48,017 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/social-icon.htmland style is 
						INFO    2019-09-18 20:56:48,141 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/autoit.htmland style is 
						INFO    2019-09-18 20:56:48,266 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/facebook.htmland style is 
						INFO    2019-09-18 20:56:48,375 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/guru99home/and style is 
						INFO    2019-09-18 20:56:48,500 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/guru99home/scrolling.htmland style is 
						INFO    2019-09-18 20:56:48,641 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/image_upload/and style is 
						INFO    2019-09-18 20:56:48,765 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/cookie/selenium_aut.phpand style is 
						INFO    2019-09-18 20:56:48,891 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/drag_drop.htmland style is 
						INFO    2019-09-18 20:56:49,016 [main] com.learning.main.Locators_2  -  link href is http://demo.guru99.com/test/and style is 
						INFO    2019-09-18 20:56:49,239 [main] com.learning.main.Locators_2  - Insurance Project link href is http://demo.guru99.com/insurance/v1/index.phpand style is 
						INFO    2019-09-18 20:56:49,364 [main] com.learning.main.Locators_2  - Agile Project link href is http://demo.guru99.com/Agile_Project/Agi_V1/and style is 
						INFO    2019-09-18 20:56:49,505 [main] com.learning.main.Locators_2  - Bank Project link href is http://demo.guru99.com/V1/index.phpand style is 
						INFO    2019-09-18 20:56:49,629 [main] com.learning.main.Locators_2  - Security Project link href is http://demo.guru99.com/Security/SEC_V1/index.phpand style is 
						INFO    2019-09-18 20:56:49,754 [main] com.learning.main.Locators_2  - Telecom Project link href is http://demo.guru99.com/telecom/index.htmland style is 
						INFO    2019-09-18 20:56:49,910 [main] com.learning.main.Locators_2  - Payment Gateway Project link href is http://demo.guru99.com/payment-gateway/index.phpand style is 
						INFO    2019-09-18 20:56:50,053 [main] com.learning.main.Locators_2  - New Tours link href is http://demo.guru99.com/test/newtours/and style is 
						INFO    2019-09-18 20:56:50,183 [main] com.learning.main.Locators_2  - Home link href is http://demo.guru99.com/test/newtours/index.phpand style is margin-left: 5px; color: rgb(0, 0, 238); text-decoration: underline;
						INFO    2019-09-18 20:56:50,354 [main] com.learning.main.Locators_2  - Flights link href is http://demo.guru99.com/test/newtours/reservation.phpand style is margin-left: 5px; color: rgb(0, 0, 238); text-decoration: underline;
						INFO    2019-09-18 20:56:50,479 [main] com.learning.main.Locators_2  - Hotels link href is http://demo.guru99.com/test/newtours/support.phpand style is margin-left: 5px; color: rgb(0, 0, 238); text-decoration: underline;
						INFO    2019-09-18 20:56:50,604 [main] com.learning.main.Locators_2  - Car Rentals link href is http://demo.guru99.com/test/newtours/support.phpand style is margin-left: 5px; color: rgb(0, 0, 238); text-decoration: underline;
						INFO    2019-09-18 20:56:50,760 [main] com.learning.main.Locators_2  - Cruises link href is http://demo.guru99.com/test/newtours/index.phpand style is margin-left: 5px; color: rgb(0, 0, 238); text-decoration: underline;
						INFO    2019-09-18 20:56:50,931 [main] com.learning.main.Locators_2  - Destinations link href is http://demo.guru99.com/test/newtours/support.phpand style is margin-left: 5px; color: rgb(0, 0, 238); text-decoration: underline;
						INFO    2019-09-18 20:56:51,073 [main] com.learning.main.Locators_2  - Vacations link href is http://demo.guru99.com/test/newtours/support.phpand style is margin-left: 5px; color: rgb(0, 0, 238); text-decoration: underline;
						INFO    2019-09-18 20:56:51,229 [main] com.learning.main.Locators_2  - SIGN-ON link href is http://demo.guru99.com/test/newtours/login.phpand style is color: rgb(0, 0, 238); text-decoration: underline;
						INFO    2019-09-18 20:56:51,369 [main] com.learning.main.Locators_2  - REGISTER link href is http://demo.guru99.com/test/newtours/register.phpand style is color: rgb(0, 0, 238); text-decoration: underline;
						INFO    2019-09-18 20:56:51,494 [main] com.learning.main.Locators_2  - SUPPORT link href is http://demo.guru99.com/test/newtours/support.phpand style is color: rgb(0, 0, 238); text-decoration: underline;
						INFO    2019-09-18 20:56:51,619 [main] com.learning.main.Locators_2  - CONTACT link href is http://demo.guru99.com/test/newtours/support.phpand style is color: rgb(0, 0, 238); text-decoration: underline;
						INFO    2019-09-18 20:56:51,744 [main] com.learning.main.Locators_2  - your destination link href is http://demo.guru99.com/test/newtours/index.phpand style is color: rgb(0, 0, 238); text-decoration: underline;
						INFO    2019-09-18 20:56:51,868 [main] com.learning.main.Locators_2  - featured vacation destinations link href is http://demo.guru99.com/test/newtours/index.phpand style is color: rgb(0, 0, 238); text-decoration: underline;
						INFO    2019-09-18 20:56:51,993 [main] com.learning.main.Locators_2  - Register here link href is http://demo.guru99.com/test/newtours/register.phpand style is color: rgb(0, 0, 238); text-decoration: underline;
						INFO    2019-09-18 20:56:52,135 [main] com.learning.main.Locators_2  - Business Travel @ About.com link href is http://businesstravel.about.com/mbody.htm?PM=78_101_T&cob=homeand style is color: rgb(0, 0, 238); text-decoration: underline;
						INFO    2019-09-18 20:56:52,244 [main] com.learning.main.Locators_2  - Salon Travel link href is https://www.tripadvisor.in/and style is color: rgb(0, 0, 238); text-decoration: underline;
			    	 */
			    }
				
			    DRIVER.close();
			    DRIVER.quit();
			}

	
	    

	}
		catch(Exception e){
			
		}

	}
	}
