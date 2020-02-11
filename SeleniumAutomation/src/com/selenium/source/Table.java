package com.selenium.source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Table {
	
	public final static String IE_DRIVER = "D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\IEDriverServer.exe";
	public final static String URL = "http://demo.guru99.com/test/newtours/";
	
	public static void main(String[] args) {
		
		
		System.setProperty("webdriver.ie.driver", IE_DRIVER);
        WebDriver DRIVER = new InternetExplorerDriver();
        DRIVER.get(URL);
		
		String baseUrl = "http://demo.guru99.com/test/newtours/";
		String path = "//table[@width=\"270\"]/tbody/tr[4]/td";
		DRIVER.get(baseUrl);
		String innerText = DRIVER.findElement(By.xpath(path)).getText(); 		
		System.out.println(innerText); 
		DRIVER.close();
		DRIVER.quit();
	}

}
