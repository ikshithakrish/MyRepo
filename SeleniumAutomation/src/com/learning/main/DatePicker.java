package com.learning.main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.action.SeleniumActionClass;
import com.selenium.constants.Constants;

public class DatePicker {
	public static WebDriver DRIVER = null;
	public static String URL = null;
	public static void main(String[] args) {
		try{
		//calenderType1(); //call calender type1
		calenderType2();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
	
	public static void calenderType1(){  //input box for both data & time
		/*
		 * So to handle this type of control first we will fill date without separating with delimiter, 
		 * i.e. if date is 09/25/2013, then we will pass 09252013 to the input box. 
		 * Once done, we will shift focus from date to time by pressing 'tab' & fill time.
		If we need to fill 02:45 PM , we will pass it a '0245PM' to the same input box. 
		 */
		URL = "http://demo.guru99.com/popup.php";
		List<String> browsers = new ArrayList<String>();
		int browserIndex = 2;
		browsers.add(Constants.INTERNET_EXPLORER); // 0
		browsers.add(Constants.FIREFOX); // 1
		browsers.add(Constants.GOOGLE_CHROME); // 2	|
		DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, URL);
		
		DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		DRIVER.get("http://demo.guru99.com/test/");
        //Find the date time picker control
        WebElement dateBox = DRIVER.findElement(By.xpath("//form//input[@name='bdaytime']"));
        //Fill date as mm/dd/yyyy as 09/25/2013
        dateBox.sendKeys("09252013");
        //Press tab to shift focus to time field
        dateBox.sendKeys(Keys.TAB);
        //Fill time as 02:45 PM
        dateBox.sendKeys("0245PM");
        DRIVER.quit();
	}
	
	public static void calenderType2() throws Exception{
		URL = "http://demo.guru99.com/popup.php";
		List<String> browsers = new ArrayList<String>();
		int browserIndex = 2;
		browsers.add(Constants.INTERNET_EXPLORER); // 0
		browsers.add(Constants.FIREFOX); // 1
		browsers.add(Constants.GOOGLE_CHROME); // 2	|
		DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, URL);
		String dateTime ="12/07/2014 2:00 PM";
        DRIVER.manage().window().maximize();        
        DRIVER.get("http://demos.telerik.com/kendo-ui/datetimepicker/index");        
        DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);        
        //button to open calendar
        WebElement selectDate = DRIVER.findElement(By.xpath("//span[@aria-controls='datetimepicker_dateview']"));        
    selectDate.click();
    //button to move next in calendar
    WebElement nextLink = DRIVER.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-next')]"));
    //button to click in center of calendar header
    WebElement midLink = DRIVER.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-fast')]"));
    //button to move previous month in calendar
    WebElement previousLink = DRIVER.findElement(By.xpath("//div[@id='datetimepicker_dateview']//div[@class='k-header']//a[contains(@class,'k-nav-prev')]"));
        //Split the date time to get only the date part
        String date_dd_MM_yyyy[] = (dateTime.split(" ")[0]).split("/");
        //get the year difference between current year and year to set in calander
        int yearDiff = Integer.parseInt(date_dd_MM_yyyy[2])- Calendar.getInstance().get(Calendar.YEAR);
        midLink.click();
        if(yearDiff!=0){
            //if you have to move next year
            if(yearDiff>0){
                for(int i=0;i< yearDiff;i++){
                    System.out.println("Year Diff->"+i);
                    nextLink.click();
                }
            }
            //if you have to move previous year
            else if(yearDiff<0){
                for(int i=0;i< (yearDiff*(-1));i++){
                    System.out.println("Year Diff->"+i);
                    previousLink.click();
                }
            }
        }        
        Thread.sleep(1000);
        //Get all months from calendar to select correct one
        List<WebElement> list_AllMonthToBook = DRIVER.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
        list_AllMonthToBook.get(Integer.parseInt(date_dd_MM_yyyy[1])-1).click();
        Thread.sleep(1000);
        //get all dates from calendar to select correct one
        List<WebElement> list_AllDateToBook = DRIVER.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class,'k-other-month'))]"));
        list_AllDateToBook.get(Integer.parseInt(date_dd_MM_yyyy[0])-1).click();
        ///FOR TIME
        WebElement selectTime = DRIVER.findElement(By.xpath("//span[@aria-controls='datetimepicker_timeview']"));
        //click time picker button
        selectTime.click();
        //get list of times
        List<WebElement> allTime = DRIVER.findElements(By.xpath("//div[@data-role='popup'][contains(@style,'display: block')]//ul//li[@role='option']"));
        dateTime = dateTime.split(" ")[1]+" "+dateTime.split(" ")[2];
     //select correct time
        for (WebElement webElement : allTime) {
            if(webElement.getText().equalsIgnoreCase(dateTime))
            {
                webElement.click();
            }
        }
        DRIVER.quit();
	}
}
