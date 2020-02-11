package com.selenium.source;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.selenium.action.TestImpl;

public class Test {
	public static WebDriver IE_DRIVER = null;
	public final static String IE_DRIVER_SERVER = "D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\IEDriverServer.exe";
	//public final static String IE_DRIVER_SERVER = "D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\chromedriver.exe";
	public final static String URL = "http://demo.guru99.com/test/newtours/index.php";
	public static String XPATH;
	public static final String BY_NAME = "byName";
	public static final String BY_XPATH = "byXpath";
	public static final String SELECT_BY_INDEX = "selectByIndex";
	public static final String SELECT_BY_VISIBLE_TEXT = "selectByVisibleText";
	public static final String SELECT_BY_VALUE = "selectByValue";
	public static TestImpl REF = null;
	public static Test REF_HOME = null;
	
	static String currentTime(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		System.out.println(dateFormat.format(date)); //2016/11/16 12:08:43
		return dateFormat.format(date);

	}
	
	static String totalTime(String startTime, String endTime){
		try{
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date d1 = dateFormat.parse(startTime);
		Date d2 = dateFormat.parse(endTime);

		//in milliseconds
		long diff = d2.getTime() - d1.getTime();

		long diffSeconds = diff / 1000 % 60;
		long diffMinutes = diff / (60 * 1000) % 60;
		long diffHours = diff / (60 * 60 * 1000) % 24;
		long diffDays = diff / (24 * 60 * 60 * 1000);

		System.out.print(diffDays + " days, ");
		System.out.print(diffHours + " hours, ");
		System.out.print(diffMinutes + " minutes, ");
		System.out.println(diffSeconds + " seconds.");
		return diffHours+":"+diffMinutes+":"+diffSeconds;
		}
		catch(Exception e){
			System.out.print("Exception found in totalTime method..."+e);
		}
		
		return null;
	}

	public static void main(String[] args) {

		REF = new TestImpl();
		REF_HOME = new Test();
		String startTime = currentTime();
		System.out.println("Start Time:"+ startTime);

		/*REF_HOME.launchBrowser();
		REF_HOME.launchUrl();

		REF_HOME.homePage();
		REF_HOME.flightsPage();
		REF_HOME.registerPage();
		IE_DRIVER.close(); //iexplorer.exe (browser)
		IE_DRIVER.quit(); // close IEServer.exe
		REF_HOME.launchBrowser();
		REF_HOME.launchUrl("https://www.facebook.com/login/identify?ctx=recover");					
        //click on the "Facebook" logo on the upper left portion		
		IE_DRIVER.findElement(By.cssSelector("a[title=\"Go to Facebook home\"]")).click();					

			//verify that we are now back on Facebook's homepage	
		System.out.println("title is"+IE_DRIVER.getTitle()+"******check space");
		IE_DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if("Facebook - log in or sign up".equals("Facebook – log in or sign up"))
			System.out.println("equal");
		else
			System.out.println("! equal");
			
		if (IE_DRIVER.getTitle().equals("Facebook – log in or sign up")) { // equal
			//if (IE_DRIVER.getTitle().equals("Facebook - log in or sign up")) { !equal							
            System.out.println("We are back at Facebook's homepage");					
        } else {			
            System.out.println("We are NOT in Facebook's homepage");					
        }	
		
		WebElement txtUsername = IE_DRIVER.findElement(By.id("email"));

		Actions builder = new Actions(IE_DRIVER);
		Action seriesOfActions = builder.moveToElement(txtUsername).click().keyDown(txtUsername, Keys.SHIFT).sendKeys(txtUsername, "hello")
			.keyUp(txtUsername, Keys.SHIFT)
			.doubleClick(txtUsername)
			.contextClick()
			.build();
			
		seriesOfActions.perform() ;

			IE_DRIVER.close(); //iexplorer.exe (browser)
			IE_DRIVER.quit(); // close IEServer.exe
			
		// Mouse Click & Keyboard Event: Action Class in Selenium Webdriver 
			/*Handling special keyboard and mouse events are done using the Advanced User Interactions API. 
			 * It contains the Actions and the Action classes that are needed when executing these events. 
			 * The following are the most commonly used keyboard and mouse events provided by the Actions class
			 
			REF_HOME.launchBrowser();
			REF_HOME.launchUrl("http://demo.guru99.com/test/newtours/");	           
	                WebElement link_Home = IE_DRIVER.findElement(By.linkText("Home"));
	                WebElement td_Home = IE_DRIVER.findElement(By.xpath("//html/body/div/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr"));    
	                 
	                Actions builder1 = new Actions(IE_DRIVER);
	                Action mouseOverHome = builder1.moveToElement(link_Home).build();
	                 
	                String bgColor = td_Home.getCssValue("background-color");
	                System.out.println("Before hover: " + bgColor);        
	                mouseOverHome.perform();        
	                bgColor = td_Home.getCssValue("background-color");
	                System.out.println("After hover: " + bgColor);	
	                IE_DRIVER.close(); //iexplorer.exe (browser)
	    			IE_DRIVER.quit(); // close IEServer.exe */
	    			
	    			//How to Upload & Download a File using Selenium Webdriver
					String baseUrl = "http://demo.guru99.com/test/upload/";
					REF_HOME.launchBrowser();
					REF_HOME.launchUrl(baseUrl);

	    	        
	    	        WebElement uploadElement = IE_DRIVER.findElement(By.id("uploadfile_0"));
	    	        // enter the file path onto the file-selection input field
	    	        uploadElement.sendKeys("C:\\Users\\BusyBee\\Desktop\\dums.xls");
	    	        // check the "I accept the terms of service" check box
	    	        IE_DRIVER.findElement(By.id("terms")).click();
	    	        // click the "UploadFile" button
	    	        IE_DRIVER.findElement(By.name("send")).click();
	    	        IE_DRIVER.close(); //iexplorer.exe (browser)*/
	    			IE_DRIVER.quit(); // close IEServer.exe
	    			
		String endTime = currentTime();
		System.out.println("End Time:"+ endTime);
		
		System.out.println("Total time taken "+totalTime(startTime, endTime));

	}

	void launchBrowser() {
		System.setProperty("webdriver.ie.driver", IE_DRIVER_SERVER);
		// WebDriver driver = new InternetExplorerDriver();
		IE_DRIVER = new InternetExplorerDriver();
	}

	void launchUrl() {
		IE_DRIVER.get(URL); // Launch URL
		System.out.println("Launch URL");
		IE_DRIVER.manage().window().maximize();

		IE_DRIVER.navigate().refresh(); // Refresh current page
		System.out.println("Refreshed current page");
	}
	
	void launchUrl(String url) {
		IE_DRIVER.get(url); // Launch URL
		System.out.println("Launch URL");
		IE_DRIVER.manage().window().maximize();
	}

	void homePage() {
		//REF.passValueAction(IE_DRIVER, BY_NAME, "userName", "s");
		REF.passValueAction(IE_DRIVER, BY_NAME, "userName", "Ikshitha KarthigaKrishnan");
		//XPATH = "/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[3]/form/table/tbody/tr[4]/td/table/tbody/tr[3]/td[2]/input";
		//REF.passValueAction(IE_DRIVER, BY_XPATH, XPATH, "1");
	}

	void flightsPage() {
		// XPATH =
		// "/html/body/div[2]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a";
		XPATH = "//a[text()='Flights']"; // <a style="color: rgb(0, 0, 238);
											// text-decoration: underline;
											// margin-left: 5px;"
											// href="reservation.php">Flights</a>
		REF.clickAction(IE_DRIVER, BY_XPATH, XPATH);
		// radioAction(WebDriver driver, String byType, String attribute, int
		// index)
		REF.radioAction(IE_DRIVER, BY_NAME, "tripType", 1);

		// selectAction(WebDriver driver, String byType, String attribute,
		// String selectBy, String indexValue)
		REF.selectAction(IE_DRIVER, BY_NAME, "passCount", SELECT_BY_INDEX, "2"); // index
																					// starts
																					// from
																					// 0,
																					// 1,...n-1
		REF.selectAction(IE_DRIVER, BY_NAME, "fromPort", SELECT_BY_VISIBLE_TEXT, "New York"); // <option
																								// value="New
																								// York">New
																								// York
																								// </option>
																								// --
																								// New
																								// York
																								// </option>
		REF.selectAction(IE_DRIVER, BY_NAME, "fromMonth", SELECT_BY_INDEX, "3");
		REF.selectAction(IE_DRIVER, BY_NAME, "fromDay", SELECT_BY_INDEX, "10");

		REF.selectAction(IE_DRIVER, BY_NAME, "toPort", SELECT_BY_VALUE, "San Francisco"); // <option
																							// value="San
																							// Francisco">San
																							// Francisco</option>
																							// -
																							// value="San
																							// Francisco"
		REF.selectAction(IE_DRIVER, BY_NAME, "toMonth", SELECT_BY_INDEX, "11");
		REF.selectAction(IE_DRIVER, BY_NAME, "toDay", SELECT_BY_INDEX, "20");

		REF.radioAction(IE_DRIVER, BY_NAME, "servClass", 2);
		REF.selectAction(IE_DRIVER, BY_NAME, "airline", SELECT_BY_INDEX, "3"); // <option>Unified
																				// Airlines</option>
		REF.submitAction(IE_DRIVER, BY_NAME, "findFlights");
		IE_DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	void driverConnection() {
		System.setProperty("webdriver.ie.driver", IE_DRIVER_SERVER);
		// WebDriver driver = new InternetExplorerDriver();
		IE_DRIVER = new InternetExplorerDriver();
	}

	void registerPage() {
		XPATH = "//a[@href='register.php']"; // <a style="color: rgb(0, 0, 238);
												// text-decoration: underline;"
												// href="register.php">REGISTER</a>
		REF.clickAction(IE_DRIVER, BY_XPATH, XPATH);
		REF.passValueAction(IE_DRIVER, BY_NAME, "firstName", "Ikshitha");
		REF.passValueAction(IE_DRIVER, BY_NAME, "lastName", "Shree");
		REF.passValueAction(IE_DRIVER, BY_NAME, "phone", "04567232149");
		XPATH = "//input[@name='userName' and @id='userName']"; //
		REF.passValueAction(IE_DRIVER, BY_XPATH, XPATH, "GKIkshi@gmail.com");
		REF.passValueAction(IE_DRIVER, BY_NAME, "address1", "EC");
		REF.passValueAction(IE_DRIVER, BY_NAME, "city", "Bglr");
		REF.passValueAction(IE_DRIVER, BY_NAME, "state", "K");
		REF.passValueAction(IE_DRIVER, BY_NAME, "postalCode", "100");
		REF.selectAction(IE_DRIVER, BY_NAME, "country", SELECT_BY_VALUE, "ANTIGUA AND BARBUDA");
		XPATH = "//input[@name='email' and @id='email']";
		REF.passValueAction(IE_DRIVER, BY_XPATH, XPATH, "133");
		XPATH = "//input[@name='password' and @type='password']"; // <input
																	// name="password"
																	// type="password"
																	// size="20"
																	// maxlength="60">
		REF.passValueAction(IE_DRIVER, BY_XPATH, XPATH, "wel");
		XPATH = "//input[@name='confirmPassword' and @type='password']";
		REF.passValueAction(IE_DRIVER, BY_XPATH, XPATH, "wel");
		XPATH = "//input[@name='submit' and @type='submit' and @src='images/submit.gif']";
		// <input name="submit" width="60" height="23" type="submit"
		// src="images/submit.gif" border="0" value="Submit Query">
		REF.clickAction(IE_DRIVER, BY_XPATH, XPATH);
		IE_DRIVER.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
