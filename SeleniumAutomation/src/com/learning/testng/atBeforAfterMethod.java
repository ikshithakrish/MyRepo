package com.learning.testng;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.action.SeleniumActionClass;
import com.selenium.util.LoggerConfig;

public class atBeforAfterMethod {
	WebDriver DRIVER = null;
	String URL = "http://demo.guru99.com/test/newtours/";
	Logger LOGGER = Logger.getLogger(atBeforAfterMethod.class);
	
	 @AfterTest   // load only once after @test ends
	  public void closeDriver(){ 
		  DRIVER.close();
		  DRIVER.quit();
	  }
	 
	 @BeforeMethod  // load every time before a new @test starts
	 public void getPageTitle(){
		 String expectedTitle = "Welcome: Mercury Tours";
	      String actualTitle = DRIVER.getTitle();
	      LOGGER.info("HOME Page title " + actualTitle);
	      Assert.assertEquals(actualTitle, expectedTitle);
	 }
	
  @Test(priority = 1)
  public void register() {
	  DRIVER.findElement(By.linkText("REGISTER")).click() ;
      String expected = "Register: Mercury Tours";
      String actual = DRIVER.getTitle();
      LOGGER.info("REGISTER Page title " + actual);
      Assert.assertEquals(actual, expected);
  }
  
  @Test(priority = 0)
  public void support() {
	  DRIVER.findElement(By.linkText("SUPPORT")).click() ;
	  String expected = "Under Construction: Mercury Tours";
	  String actual = DRIVER.getTitle();
      LOGGER.info("Support Page title " + actual);
      Assert.assertEquals(actual, expected);
  }
  
  @AfterMethod  // load every time after a new @test ends
  public void clickLink(){
	  DRIVER.findElement(By.linkText("Home")).click() ;
  } 
  
  @BeforeTest  // load before @test starts
	public void loadLogger(){  // call Logger and Launch Browser
		LoggerConfig.logger();	
		DRIVER = SeleniumActionClass.launchURL(2, URL); // Browser index: 0 - IE, 1 - FireFox, 2 - Chrome
	}
}
