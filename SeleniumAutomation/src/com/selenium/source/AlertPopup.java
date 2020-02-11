package com.selenium.source;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class AlertPopup {

	public static void main(String[] args) {

		try{
		System.setProperty("webdriver.ie.driver","D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\IEDriverServer.exe");
		WebDriver driver = new InternetExplorerDriver();
	
        
        // Alert Message handling
                    		
        driver.get("http://demo.guru99.com/test/delete_customer.php");			
                            		
     	      	
        driver.findElement(By.name("cusid")).sendKeys("53920");					
        driver.findElement(By.name("submit")).submit();			
        		
        // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage);	
        Thread.sleep(5000);
        		
        // Accepting alert		
        alert.accept();	
        
        //alert.dismiss();        
        // driver.switchTo().alert().sendKeys("Text");   // to pass value to alert box
        
        driver.close();
        driver.quit();
		}
		catch(Exception e){
			System.out.println("Exception found...." + e);
		}
		
		
	}

}
