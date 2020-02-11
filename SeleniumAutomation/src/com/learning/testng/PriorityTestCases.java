package com.learning.testng;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.util.GetClassName;
import com.selenium.util.LoggerConfig;

/*
 priority: 0 and without priority are consider as same category
 @Test     ==  @Test(priority = 0) 
 @Test (priority = 3.1)   -- decimal values not allowed, cannot convert double to int 
 */
public class PriorityTestCases {
	public static Logger LOGGER = Logger.getLogger(new GetClassName().getClassName());
	
	@BeforeTest
	public void config(){
		LoggerConfig.logger();
	}

@Test (priority = -1)
public void a1_negative(){
	LOGGER.info("Priority - (-1) : a1_negative()--------");
}

@Test (priority = -2)
public void a2b_negative(){
	LOGGER.info("Priority - (-2) : a2b_negative()--------");
}

@Test (priority = -2)
public void a2a_negative(){
	LOGGER.info("Priority - (-2) : a2a_negative()--------");
}
	
  @Test (priority = 3) 
  public void a1() {
	  LOGGER.info("Priority - 3 : a1()--------");
  }
 
  /*
  @Test (priority = 3.1) // C.T Error cannot convert double to int
  public void a1() {
	  System.out.println("Priority - 3 : a1()--------");
  }
  */
  
  @Test (priority = 1, alwaysRun = true)  // this execute 1st
  // what is alwaysRun -- > true / false?????  
  public void c1() {
	  LOGGER.info("Priority - 1 : c1()--------");
  }
  
  @Test
  public void ab() {
	  LOGGER.info("no priority: ab()--------");
  }
  
  @Test(priority = 5)
  public void a2() {
	  System.out.println("Priority - 5 : a2()--------");
  }  
  
  @Test(priority = 0) 
  public void a4() {
	  LOGGER.info("Priority - 0 : a4()--------");
  }
  
  @Test
  public void aa() {
	  LOGGER.info("no priority: aa()--------");
  }
  
  @Test(priority = 2)  
  public void b1() {
	  LOGGER.info("priority - 2 : b1()--------");
  }
  
}

/*   OUTPUT: 
Priority - (-2) : a2a_negative()--------
Priority - (-2) : a2b_negative()--------
Priority - (-1) : a1_negative()--------
Priority - 0 : a4()--------
no priority: aa()--------
no priority: ab()--------
Priority - 1 : c1()--------
priority - 2 : b1()--------
Priority - 3 : a1()--------
Priority - 5 : a2()--------
PASSED: a2a_negative
PASSED: a2b_negative
PASSED: a1_negative
PASSED: a4
PASSED: aa
PASSED: ab
PASSED: c1
PASSED: b1
PASSED: a1
PASSED: a2

 */ 
