package com.learning.testng;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.action.SeleniumActionClass;
import com.selenium.util.LoggerConfig;

public class atBeforAfterTest {
	WebDriver DRIVER = null;
	String URL = "http://demo.guru99.com/test/newtours/";
	Logger LOGGER = Logger.getLogger(atBeforAfterTest.class);
	
	@BeforeTest  // load before @test starts
	public void loadLogger(){  // call Logger and Launch Browser
		LoggerConfig.logger();	
		DRIVER = SeleniumActionClass.launchURL(2, URL); // Browser index: 0 - IE, 1 - FireFox, 2 - Chrome
	}
	
  @Test
  public void compareTitle() {
	  String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = DRIVER.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @AfterTest   // load after @test ends
  public void closeDriver(){ 
	  DRIVER.close();
	  DRIVER.quit();
  }
}
