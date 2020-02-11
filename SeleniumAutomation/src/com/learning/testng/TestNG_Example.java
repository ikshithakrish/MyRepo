package com.learning.testng;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.action.SeleniumActionClass;
import com.selenium.util.LoggerConfig;

/*
  1. TestNG - TestNextGeneration  (base of Junit)
  2. Implements based on annotations(@)
  3. Can generate report (no. of test cased passed / failed / skipped)
  4. Also can execute the failed test case separately
  5. Main method (public static void main(String a[]) is not required
  6. testng-failed.xml file in test-output folder  -- user can run only the failed test case(s) using this
     Selenium Perspective
	     1. Stand alone selenium cannot generate reports(WebDriver has no native mechanism for generating reports) so that we use TestNG
	     2. Using testNG we can group multiple test cases keep in a single testng.xml
	     3. Also can prioritize the testcase exection (i.e which test case run first, secon,.....))
	      4. Execute the same test case multiple times without loops (can achive this through the keyword "invocation count")
	      5. Can execute multiple test cases on multipel browsers (i.e., Cross browser testing)
	      6. Can easily integrate with tools like maven, Jenkins....
	      7. Annotactions are understandable
   
   Advantage of TestNG Over JUnit   
    1. Annotations are easier to understand
    2. Test cases can be grouped more easily
    3. Parallel testing is possible 
    
    Note: @Test will execute alphabatically -- a1() - first   c1() - third  m1() - fourth and b1() - second
    
 */
public class TestNG_Example {
	Logger LOGGER = Logger.getLogger(TestNG_Example.class);
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
