package com.selenium.source;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.selenium.action.SeleniumAction;

public class InternetExplorer {

		public final static String IE_DRIVER = "D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\IEDriverServer.exe";
		public final static String URL = "http://demo.guru99.com/test/newtours/";
		public static WebDriver DRIVER;
		public static String XPATH;
		
	static String currentTime(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		return dateFormat.format(date);

	}
		
	public static void main(String args[]){
		
		System.setProperty("webdriver.ie.driver", IE_DRIVER);
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";
        DRIVER = new InternetExplorerDriver();
        DRIVER.get(URL);

        actualTitle = DRIVER.getTitle();
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
        SeleniumAction action = new SeleniumAction();
        /* Action - BEGIN */
        System.out.println("Start time "+currentTime());
        action.passValue(DRIVER, "byName", "userName", "Ikshitha KarthigaKrishnan");        
        XPATH="/html/body/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a";
        action.clickAction(DRIVER, "byXpath", XPATH);
        XPATH="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]";
        action.clickAction(DRIVER, "byXpath", XPATH);
        action.selectAction(DRIVER, "byName", "passCount", "selectByIndex", "2");
        action.selectAction(DRIVER, "byName", "fromPort", "selectByValue", "New York");
        action.selectAction(DRIVER, "byName", "fromMonth", "selectByIndex", "6");
        action.selectAction(DRIVER, "byName", "fromDay", "selectByIndex", "3");
        action.selectAction(DRIVER, "byName", "toPort", "selectByValue", "Frankfurt");
        action.selectAction(DRIVER, "byName", "toMonth", "selectByIndex", "11");
        action.selectAction(DRIVER, "byName", "toDay", "selectByIndex", "23");
        action.radioAction(DRIVER, "byName", "servClass", 2);
        action.selectAction(DRIVER, "byName", "airline", "selectByVisibleText", "Unified Airlines");
        //passCount
        //selectAction(DRIVER, "byName", "passCount", "indexTYPE", "indexvalue")
        /* Action - END */
        DRIVER.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ; // implicit wait for 10 seconds
        System.out.println("End time "+currentTime());
        //close Fire fox
        DRIVER.close();
        
       
	}
}


/*
 * selectebyInde [0,1,2,..n-1]
 */
