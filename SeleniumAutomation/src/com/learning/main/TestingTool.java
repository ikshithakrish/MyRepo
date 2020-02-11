package com.learning.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.selenium.action.SeleniumActionClass;
import com.selenium.constants.Constants;
import com.selenium.util.LoggerConfig;

public class TestingTool {

	public static Logger logger = Logger.getLogger(TestingTool.class);
	
	public static void main(String[] args) {
		//Launch Browser
		try{
			LoggerConfig.logger(); // write log in external file / console
			logger.info("Enter into main() try block");
			List<String> browsers = new ArrayList<String>();
			int browserIndex = 0;
			String url = "https://www.google.com";
			//String url = "http://demo.guru99.com/test/newtours/index.php";
			browsers.add(Constants.INTERNET_EXPLORER); // 0
			browsers.add(Constants.FIREFOX); // 1
			browsers.add(Constants.GOOGLE_CHROME); // 2
			
			SeleniumActionClass.launchURL(browsers, browserIndex, url);
			
			logger.info("Exit from main() try block ");
			
		}
		catch(Exception e){
			logger.error("Enter into main() catch block ");
			logger.error("Exception found in main() is " + e);
			logger.error("Exit from main() catch block ");
		}
		
	}

}
