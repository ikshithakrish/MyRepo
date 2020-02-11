package com.learning.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.action.SeleniumActionClass;
import com.selenium.constants.Constants;
import com.selenium.util.LoggerConfig;

/*
 * Radio and check box index starts from 0
 */
public class Check_Radio_5 {

	public static WebDriver DRIVER = null;
	public static Logger logger = Logger.getLogger(Check_Radio_5.class);
	public static void main(String[] args) {		

		try{
			LoggerConfig.logger(); // write log in external file / console
			logger.info("Enter into main() try block");
			checkRadio();
			
		}
		catch(Exception e){
			logger.warn("Exception found " + e);
		}
		finally{
			logger.warn("Close & Quit driver");
		DRIVER.close();
		DRIVER.quit();
		}
	
	}
	
	
	static void checkRadio(){
		logger.info("Enter into checkRadio()");
		List<String> browsers = new ArrayList<String>();
		int browserIndex = 2;
		String url = "http://demo.guru99.com/test/radio.html";
		browsers.add(Constants.INTERNET_EXPLORER); // 0
		browsers.add(Constants.FIREFOX); // 1
		browsers.add(Constants.GOOGLE_CHROME); // 2	|
		
		DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, url);
		if(DRIVER != null){	
			WebElement radioButton_option2 = DRIVER.findElement(By.id("vfb-7-2"));
			radioButton_option2.click();  // option2 
			DRIVER.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			int radioButtonOption = 0;
			WebElement radioButton = DRIVER.findElements(By.cssSelector("input[type=radio]")).get(radioButtonOption);
			radioButton.click();	 // option 1	
			
			logger.info("Elemetn 1 isDisplayed() ? " + DRIVER.findElements(By.cssSelector("input[type=radio]")).get(0).isDisplayed()); //true
			logger.info("Elemetn 1 isEnabled() ? " + DRIVER.findElements(By.cssSelector("input[type=radio]")).get(0).isEnabled()); //true ??????
			logger.info("Elemetn 1 isSelected() ? " + DRIVER.findElements(By.cssSelector("input[type=radio]")).get(0).isSelected()); //true
			
			logger.info("Elemetn 2  isDisplayed() ?  " + DRIVER.findElements(By.cssSelector("input[type=radio]")).get(1).isDisplayed()); //true
			logger.info("Elemetn 2  isEnabled() ?  " + DRIVER.findElements(By.cssSelector("input[type=radio]")).get(1).isEnabled()); //true  ?????
			logger.info("Elemetn 2  isSelected() ? " + DRIVER.findElements(By.cssSelector("input[type=radio]")).get(1).isSelected()); //false
			
			logger.info("Elemetn 3  isDisplayed() ? " + DRIVER.findElements(By.cssSelector("input[type=radio]")).get(2).isDisplayed()); // true
			logger.info("Elemetn 3 isEnabled() ? "  + DRIVER.findElements(By.cssSelector("input[type=radio]")).get(2).isEnabled()); // true ??????
			logger.info("Elemetn 3  isSelected() ? "  + DRIVER.findElements(By.cssSelector("input[type=radio]")).get(2).isSelected()); // false
			
//			logger.info(DRIVER.findElements(By.cssSelector("input[type=radio]")).get(3).isDisplayed());  //(through catch block) WARN    2019-09-19 18:03:19,203 [main] com.learning.main.Check_Radio_5  - Exception found java.lang.IndexOutOfBoundsException: Index: 3, Size: 3
//			logger.info(DRIVER.findElements(By.cssSelector("input[type=radio]")).get(3).isEnabled());
//			logger.info(DRIVER.findElements(By.cssSelector("input[type=radio]")).get(3).isSelected());
			
			DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement checkBoxElement = null;
			int checkBox_Count = DRIVER.findElements(By.cssSelector("input[type=checkbox]")).size();
			for(int i = 0; i< checkBox_Count; i++){
				checkBoxElement = DRIVER.findElements(By.cssSelector("input[type=checkbox]")).get(i);
				logger.info("checkbox " + (i+1) + "is selected ? " +checkBoxElement.isSelected());
				checkBoxElement.click();
				logger.info("checkbox clicked");
				logger.info("checkbox " + (i+1) + "is enabled ? " +checkBoxElement.isEnabled());
			}
			/*
				INFO    2019-09-19 17:30:24,408 [main] com.learning.main.Check_Radio_5  - checkbox 1is selected ? false
				INFO    2019-09-19 17:30:24,486 [main] com.learning.main.Check_Radio_5  - checkbox clicked
				INFO    2019-09-19 17:30:24,528 [main] com.learning.main.Check_Radio_5  - checkbox 1is enabled ? true
				INFO    2019-09-19 17:30:24,591 [main] com.learning.main.Check_Radio_5  - checkbox 2is selected ? false
				INFO    2019-09-19 17:30:24,669 [main] com.learning.main.Check_Radio_5  - checkbox clicked
				INFO    2019-09-19 17:30:24,701 [main] com.learning.main.Check_Radio_5  - checkbox 2is enabled ? true
				INFO    2019-09-19 17:30:24,995 [main] com.learning.main.Check_Radio_5  - checkbox 3is selected ? false
				INFO    2019-09-19 17:30:25,214 [main] com.learning.main.Check_Radio_5  - checkbox clicked
				INFO    2019-09-19 17:30:25,252 [main] com.learning.main.Check_Radio_5  - checkbox 3is enabled ? true
						*/
			
		}
		else{
			logger.warn("Driver is null");
		}
		logger.info("EXIT from checkRadio()");
	}

}
