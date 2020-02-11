package com.learning.main;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.log4testng.Logger;

import com.selenium.action.SeleniumActionClass;
import com.selenium.constants.Constants;
import com.selenium.util.LoggerConfig;

public class DesiredCapabilities_15 {
	public static WebDriver DRIVER = null;
	static String URL = "https://www.guru99.com/";
	public static Logger LOGGER = Logger.getLogger(DesiredCapabilities_15.class);

	public static void main(String[] args) {
		System.out.println("**********");
		LoggerConfig.logger();
LOGGER.info("Enter into xPathFinder()");		
		
		List<String> browsers = new ArrayList<String>();
		int browserIndex = 2;
		browsers.add(Constants.INTERNET_EXPLORER); // 0
		browsers.add(Constants.FIREFOX); // 1
		browsers.add(Constants.GOOGLE_CHROME); // 2	|
		
		DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, URL);
		
		Capabilities browserInfo = ((RemoteWebDriver) DRIVER).getCapabilities();
		LOGGER.info("Browser Name: " + browserInfo.getBrowserName() + " Version: " + browserInfo.getVersion() + " Platform: " + browserInfo.getPlatform());
		// Browser Name: chrome Version: 79.0.3945.117 Platform: WINDOWS
		System.out.println("**********  Browser Name: " + browserInfo.getBrowserName() + " Version: " + browserInfo.getVersion() + " Platform: " + browserInfo.getPlatform());
		DRIVER.close();
		DRIVER.quit();
	}

}
