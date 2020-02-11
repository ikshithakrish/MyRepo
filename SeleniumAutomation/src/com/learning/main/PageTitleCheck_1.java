package com.learning.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.learning.action.SeleniumActions;
import com.selenium.action.SeleniumActionClass;
import com.selenium.constants.Constants;
import com.selenium.util.LoggerConfig;
import com.selenium.util.ScreenShot;

public class PageTitleCheck_1 {

	public static Logger logger = Logger.getLogger(PageTitleCheck_1.class);
	public static WebDriver DRIVER = null;
	
	public static void main(String[] args) {
		
		try{
			LoggerConfig.logger(); // write log in external file / console
			logger.info("Enter into main() try block");
			
			List<String> browsers = new ArrayList<String>();
			int browserIndex = 2;
			String url = "http://demo.guru99.com/test/newtours/";
			browsers.add(Constants.INTERNET_EXPLORER); // 0
			browsers.add(Constants.FIREFOX); // 1
			browsers.add(Constants.GOOGLE_CHROME); // 2	
			
			DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, url);
			if(DRIVER != null){	
				DRIVER.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				DRIVER.manage().window().maximize();  
				String expectedTitle = "Welcome: Mercury Tours";
		        String actualTitle = null;
		     // get the actual value of the title
		        actualTitle = DRIVER.getTitle();
		        if(expectedTitle.equalsIgnoreCase(actualTitle)){
		        	ScreenShot.captureScreen("D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\ScreenShots\\Captured\\1.jpeg", DRIVER);
		        	logger.info("This is the expected page");
		        }
		        else{
		        	logger.warn("this is not a valid page");
		        }
		        DRIVER.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		        SeleniumActions.sessionEnd(DRIVER);
			}
			else{
				logger.warn("driver is null");
			}
			
			//DRIVER.close();
			//Thread.sleep(4000);
			//DRIVER.quit();
			
			logger.info("Exit from main() try block ");
			
		}
		catch(Exception e){
			logger.error("Enter into main() catch block ");
			logger.error("Exception found in main() is " + e);
			logger.error("Exit from main() catch block ");
		}

	}

}
