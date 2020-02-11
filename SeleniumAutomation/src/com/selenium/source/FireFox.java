package com.selenium.source;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FireFox {

	public final static String IE_DRIVER = "D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\IEDriverServer.exe";
	public final static String URL = "http://demo.guru99.com/test/newtours/";
	
public static void main(String args[]){
	
	System.setProperty("webdriver.ie.driver", IE_DRIVER);
	//String baseUrl = "http://demo.guru99.com/test/newtours/";
    String expectedTitle = "Welcome: Mercury Tours";
    String actualTitle = "";
    WebDriver driver = new FirefoxDriver();
    driver.get(URL);

    actualTitle = driver.getTitle();
    if (actualTitle.contentEquals(expectedTitle)){
        System.out.println("Test Passed!");
    } else {
        System.out.println("Test Failed");
    }
   
    //close Fire fox
    driver.close();
   
}

}
