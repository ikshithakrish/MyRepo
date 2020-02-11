package com.learning.main;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import com.selenium.action.SeleniumActionClass;
import com.selenium.constants.Constants;
import com.selenium.util.LoggerConfig;

/*
 * Alert?
Alert is a small message box which displays on-screen notification to give the user some 
kind of information or ask for permission to perform certain kind of operation. 
It may be also used for warning purpose. 

Alert Type:
1. Simple Alert 2. Prompt Alert(provide input) 3. Confirmation Alert

Handle Alerts
1. void dismiss() - cancel
	driver.switchTo().alert().dismiss();
2. void accepet() - ok
	driver.switchTo().alert().accept();
3. String getText() - get alert msg
	driver.switchTo().alert().getText();
4. void sendKeys(String stringToSend)  // send input to alert box
	driver.switchTo().alert().sendKeys("Text input");

 */
public class Alert_Popup_12 {
	public static Logger LOGGER = Logger.getLogger(HtmlTable_13.class);
	public static WebDriver DRIVER = null;
	public static String URL = "http://demo.guru99.com/test/delete_customer.php";
	public static String TEMP_CHILD_WINDOW = "";
	public static void main(String[] args) {
		try{
			LoggerConfig.logger();
			LOGGER.info("Enter into main() try block");
			//popUp();
			toggleBrowserWindows();
			LOGGER.info("Exit from main() try block");
		}
		catch(Exception e){
			LOGGER.warn("Enter into main() catch(Exception e) block");
			LOGGER.error("Exception found in main() " + e );  
			LOGGER.warn("Enter into main() catch(Exception e) block");
		}
		finally{
			//DRIVER.close();
			//DRIVER.quit();
		}	
	}
	
	static void toggleBrowserWindows(){
		try{
			LOGGER.info("Enter into toggleBrowserWindows()");
			URL = "http://demo.guru99.com/popup.php";
			List<String> browsers = new ArrayList<String>();
			int browserIndex = 2;
			browsers.add(Constants.INTERNET_EXPLORER); // 0
			browsers.add(Constants.FIREFOX); // 1
			browsers.add(Constants.GOOGLE_CHROME); // 2	|
			DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, URL);
			DRIVER.manage().window().maximize();
			
			DRIVER.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();	

			// Storing parent window reference into a String Variable
			  String parent = DRIVER.getWindowHandle();
			  LOGGER.info("Parent window--------- " + parent);

			  // Set S1 will store number of windows opened by Webdriver
			  Set<String> s1 = DRIVER.getWindowHandles();

			  // Now we will iterate using Iterator
			  Iterator<String> I1 = s1.iterator();

			  while (I1.hasNext()) {
			   // Create reference for Window B
			   String child_window = I1.next();
			   
			   LOGGER.info("Child window--------- " + child_window);
			   // Here we will compare if parent window is not equal to child window then we
			   // will close

			   if (!parent.equals(child_window)) {
			    // Move Focus from Window A to Window B. Window B is active now
				   TEMP_CHILD_WINDOW = child_window;
			    DRIVER.switchTo().window(child_window);

			    // Complete the set of actions on Window B .
			    LOGGER.info(DRIVER.switchTo().window(child_window).getTitle());
			   }
			  }
			  // Move Focus to Window A. Window A is active now
			  DRIVER.switchTo().window(parent);
			  
			  if(!parent.equals(TEMP_CHILD_WINDOW)){
				  DRIVER.switchTo().window(TEMP_CHILD_WINDOW);
				  DRIVER.findElement(By.name("emailid")).sendKeys("test@test.com");					
					DRIVER.findElement(By.name("btnLogin")).submit();	
			  }
			  DRIVER.switchTo().window(parent);
			LOGGER.info("Exit from toggleBrowserWindows()");
		
		}
		catch(Exception e){
			LOGGER.warn("Enter into toggleBrowserWindows() - catch(Excption e)");
			LOGGER.error("Exception found in toggleBrowserWindows() " + e);
			LOGGER.warn("Exit from toggleBrowserWindows() - catch(Excption e)");
		}
	}
	
	static void popUp(){
		try{
		LOGGER.info("Enter into popUp()");
		
		List<String> browsers = new ArrayList<String>();
		int browserIndex = 2;
		browsers.add(Constants.INTERNET_EXPLORER); // 0
		browsers.add(Constants.FIREFOX); // 1
		browsers.add(Constants.GOOGLE_CHROME); // 2	|
		DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, URL);
		
		//DRIVER.findElement(By.name("cusid")).sendKeys("53920");					
		DRIVER.findElement(By.name("submit")).submit();			
        		
        // Switching to Alert        
       //  Alert alert = DRIVER.switchTo().alert();		
		System.out.println(DRIVER.switchTo().alert().getText());
		DRIVER.switchTo().alert().accept();
		
        // Capturing alert message.    
        //String alertMessage= DRIVER.switchTo().alert().getText();		
        		
        // Displaying alert message		
        //System.out.println(alertMessage);
        // System.out.println(alert.getText());
        
        Thread.sleep(5000);
        		
        // Accepting alert
        //alert.dismiss();
        
//        DRIVER.findElement(By.name("cusid")).sendKeys("53920");					
//		DRIVER.findElement(By.name("submit")).submit();        
//        DRIVER.switchTo().alert().accept();		
//        
//        Thread.sleep(30000);
//        System.out.println(DRIVER.switchTo().alert().getText());
       // DRIVER.switchTo().alert().accept();		 
		LOGGER.info("Exit from popUp()");
	
	}
	catch(Exception e){
		LOGGER.warn("Enter into popuup() - catch(Excption e)");
		LOGGER.error("Exception found in popUp() " + e);
		LOGGER.warn("Exit from popuup() - catch(Excption e)");
	}
	}
	
}
