package com.learning.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.selenium.action.SeleniumActionClass;
import com.selenium.constants.Constants;
import com.selenium.util.LoggerConfig;

public class Links_PartialLinks_8 {
/* 
 * Note: both linkText and partialLinkText Locators are case Sensitive
 * By.linkText("REGISTER") - match based on the exact text (REGISTER) , ignore "REGISTER User" "Register"
 * Note: if more than one link having same text link it will consider the first link only
 * By.partialLinkText("REGISTER") - match based on relative link text (REGISTER, REGISTER User, REGISTEROR page, REGISTER....) ignore (Register, Register User, register....)
 */
	
	public static Logger LOGGER = Logger.getLogger(Links_PartialLinks_8.class);
	public static WebDriver DRIVER = null;
	
	public static void main(String[] args) {
		try{
			LoggerConfig.logger();
			LOGGER.info("ENTER into main - try block");
			linkText();
			LOGGER.info("EXIT from main - try block");			
		}
		catch(Exception e){
			LOGGER.error("ENTER into main - catch block");
			LOGGER.error("Exception is " + e);
			LOGGER.error("EXIT from main - catch block");
		}
		finally{
			DRIVER.quit();
		}
	}

	
	static void linkText(){
		try{
			LOGGER.info("ENTER into linkText() try block");
			//String url = "http://demo.guru99.com/test/newtours/index.php";
			String url = "D:\\My Assignments\\Selenium_UI_AUTOMATION\\Sample Webpages\\Link_PartialLink.html";
			List<String> browsers = new ArrayList<String>();
			int browserIndex = 2;
			browsers.add(Constants.INTERNET_EXPLORER); // 0
			browsers.add(Constants.FIREFOX); // 1
			browsers.add(Constants.GOOGLE_CHROME); // 2	|
			
			DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, url);
			if(DRIVER != null){
				int linkCount = DRIVER.findElements(By.linkText("Register")).size();
				int partialLinkCount = DRIVER.findElements(By.partialLinkText("Register")).size();
				LOGGER.info("Link text present for Register is " + linkCount
						+ " partialLink text present for Register is " + partialLinkCount);  
				//
					LOGGER.info("Link text value found is " + DRIVER.findElements(By.linkText("Register")).toString());
					LOGGER.info("partilLink text value found is " + DRIVER.findElements(By.partialLinkText("Register")).toString());
				/*	INFO    2019-09-20 07:12:27,207 [main] com.learning.main.Links_PartialLinks_8  - Link text present for Register is 1 partialLink text present for Register is 4
					INFO    2019-09-20 07:12:27,363 [main] com.learning.main.Links_PartialLinks_8  - Link text value found is [[[ChromeDriver: chrome on XP (879527d5eb8debe2ea9b2c5063d7ea80)] -> link text: Register]]
					INFO    2019-09-20 07:12:27,425 [main] com.learning.main.Links_PartialLinks_8  - partilLink text value found is [[[ChromeDriver: chrome on XP (879527d5eb8debe2ea9b2c5063d7ea80)] -> partial link text: Register], [[ChromeDriver: chrome on XP (879527d5eb8debe2ea9b2c5063d7ea80)] -> partial link text: Register], [[ChromeDriver: chrome on XP (879527d5eb8debe2ea9b2c5063d7ea80)] -> partial link text: Register], [[ChromeDriver: chrome on XP (879527d5eb8debe2ea9b2c5063d7ea80)] -> partial link text: Register]]*/

				//WebElement link = DRIVER.findElement(By.linkText("Register"));
			/*	<body>
				<a href="#">Register</a> 
				<a href="#">REGISTER</a>
				<a href="#">Registeror</a>
				<a href="#">Register User</a>
				<a href="#">Register Authneticaion</a>
				</body> */
			}
			else{
				LOGGER.error("DRIVER is null");
			}
	}
		catch(Exception e){
			LOGGER.error("Enter into linkText() - catch(Exception e) block");
			LOGGER.error("Exception found is " + e);
			LOGGER.error("Exit into linkText() - catch(Exception e) block");
		}
}
	
} // Class end
