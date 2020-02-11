package com.learning.testng;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.action.SeleniumActionClass;
import com.selenium.util.LoggerConfig;


public class Multiple_Test1 {
	Logger LOGGER = Logger.getLogger(Multiple_Test1.class);
	WebDriver DRIVER = null;
	String URL = "http://demo.guru99.com/test/newtours/";
	int count = 0;
	
	@BeforeTest
	public void loadLogger(){
		LoggerConfig.logger();	
	}
	
  @Test
  public void m1() {
	  try{		  
		  
		  LOGGER.info("a1() executed at count " + count++ );
		  LOGGER.info("Enter into m1() - try block");	  
		  DRIVER = SeleniumActionClass.launchURL(2, URL); // Browser index: 0 - IE, 1 - FireFox, 2 - Chrome
		  String expectedTitle = "Welcome: Mercury Tours";
	      String actualTitle = DRIVER.getTitle();
	      Assert.assertEquals(actualTitle, expectedTitle);
	      DRIVER.close();
		  LOGGER.info("Exit from m1()  - try block");
	  }
	  catch(Exception e){
		  LOGGER.error("Enter into m1() - catch(Exception e) block");
		  LOGGER.error("Exception found is " + e);
		  LOGGER.error("Enter into m1() - catch(Exception e) block");
	  }
  }
  
  @Test
  public void a1(){
	  Assert.fail();
	  LOGGER.info("a1() executed at count " + count++ );
  }
  
  
  @Test
  public void c1(){
	  Assert.assertTrue(true);
	  LOGGER.info("c1() executed at count " + count++ );
  }
  
  
  @Test
  public void b1(){
	  LOGGER.info("b1() executed at count " + count++ );
  }
}
