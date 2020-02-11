package com.learning.main;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.learning.action.SeleniumActions;

public class LaunchBrowsers { // class open
	
private static final String INTERNET_EXPLORER = "D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\IE Version 11\\IEDriverServer.exe";
private static final String GOOGLE_CHROME = "D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\ChromeVersion 75.0.3770.142 (Official Build) (32-bit)\\chromedriver.exe";
private static final Logger LOGGER = Logger.getLogger(LaunchBrowsers.class.getName()); // import java.util.logging.Logger;
public static final String BY_XPATH = "byXpath";
public static final String BY_ID = "byId";

public static void main(String[] cmdLineArgs){ // main open
	
	List<String> details = new ArrayList<String>();
	//details.add("IE");
	details.add("CHROME");
	 details.add("http://demo.guru99.com/test/newtours/index.php");
	//details.add("https://www.srsbooking.com/");	
	if(SeleniumActions.launchURL(details)){
		System.out.println("Launch Browser");
		// details.add(2, BY_XPATH);
		// details.add(3, "//div/div/div/div[1]/div/div/a");
		//details.add(2, BY_ID);
		//details.add(3, "close");
		//SeleniumActions.clickAction(details); // type="byXpath / byId /byClassName /???"
		
	}
	else{
		System.out.println("Launch Browser failed");
	}
	
	details.clear();
	
	//div/div/div/div[1]/div/div/a/img
	
	
	/*
	 The log levels define the severity of a message. The Level class is used to define which messages should be written to the log.
	The following lists the Log Levels in descending order:
	SEVERE (highest)
	WARNING
	INFO
	CONFIG
	FINE
	FINER
	FINEST
	 */
	
	 
    
	
	
} // main close



} // class close
