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

/*
 * Listeners - interface which change the behavior of testNG
 * Can Customize the reports and logs
 * Many Listeners are available  to change the testNG behavior
 */
public class TestNG_Listeners {
	
  @Test  // load before @test starts
	public void loadLogger(){  // call Logger and Launch Browser
		
	}
}
