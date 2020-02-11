package com.learning.testng;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.selenium.action.SeleniumActionClass;

public class ParallelBrowserExecution {
	WebDriver DRIVER1 = null;
	WebDriver DRIVER2 = null;
	String URL = "http://demo.guru99.com/test/newtours/";
	
  @Test
  public void executeFirst() {
	  DRIVER1 = SeleniumActionClass.launchURL(2, URL); // Browser index: 0 - IE, 1 - FireFox, 2 - Chrome
	  String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = DRIVER1.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  @Test
  public void executeSecond() {
	  DRIVER2 = SeleniumActionClass.launchURL(2, URL); // Browser index: 0 - IE, 1 - FireFox, 2 - Chrome
	  String expectedTitle = "Welcome: Mercury Tours";
      String actualTitle = DRIVER2.getTitle();
      Assert.assertEquals(actualTitle, expectedTitle);
  }
  
  
}
