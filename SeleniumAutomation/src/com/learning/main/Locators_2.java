package com.learning.main;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.learning.action.SeleniumActions;
import com.selenium.action.SeleniumActionClass;
import com.selenium.constants.Constants;
import com.selenium.util.LoggerConfig;
import com.selenium.util.ScreenShot;

public class Locators_2 {
/*
 * Locators - point which GUI elements(textbox, link, button, checkboxes, dropdown...etc)
 */
	public static Logger logger = Logger.getLogger(Locators_2.class);
	public static WebDriver DRIVER = null;
	
	public static void main(String[] args) {
		try{
			LoggerConfig.logger(); // write log in external file / console
			logger.info("Enter into main() try block");
			
			List<String> browsers = new ArrayList<String>();
			int browserIndex = 2;
			String url = "http://demo.guru99.com/test/newtours/";
			browsers.add(Constants.INTERNET_EXPLORER); // 0
			browsers.add(Constants.FIREFOX); // 1
			browsers.add(Constants.GOOGLE_CHROME); // 2	|
			
			DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, url);
			if(DRIVER != null){	
				//DRIVER.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
				DRIVER.manage().window().maximize();
				
				//<a href="register.php" style="color: #0000ee;text-decoration: underline;">REGISTER</a>
				DRIVER.findElement(By.cssSelector("a[href='register.php']")).click();
				ScreenShot.captureScreen("D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\ScreenShots\\Captured\\Home.png", DRIVER);
				
				//<input maxlength="60" name="firstName" size="20">
				DRIVER.findElement(By.cssSelector("input[name='firstName']")).sendKeys("Gokula");
				//<input maxlength="60" name="lastName" size="20">
				DRIVER.findElement(By.name("lastName")).sendKeys("Krishnan");
				//<input maxlength="20" name="phone" size="15">
				DRIVER.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/input")).sendKeys("9999000010");
				//<input name="userName" id="userName" size="35" maxlength="64">
				DRIVER.findElement(By.id("userName")).sendKeys("GK@gmail.com");
				//<input maxlength="60" name="address1" size="40">
				DRIVER.findElement(By.name("address1")).sendKeys("Nehru Nagar");
				//<input maxlength="60" name="city" size="15">
				DRIVER.findElement(By.name("city")).sendKeys("Ramanathapuram");
//				//<input maxlength="40" name="state">
				DRIVER.findElement(By.name("state")).sendKeys("Tamil Nadu");
				//<input maxlength="20" name="postalCode" size="15">
				DRIVER.findElement(By.name("postalCode")).sendKeys("623503");
				/*<select name="country" size="1">
				 * <option value="ALBANIA">ALBANIA</option>
				 * <option value="ALGERIA">ALGERIA</option>
				 * .
				 * .
				 * </select>
				 */
				Select country = new Select(DRIVER.findElement(By.name("country")));
				country.selectByIndex(5);
//				country.selectByValue("ALGERIA"); // <option value="ALGERIA******">ALGERIA</option>
//				country.selectByVisibleText("BOUVET ISLAND"); // <option value="BOUVET ISLAND">BOUVET ISLAND********</option>
				//<input name="email" id="email" size="20" maxlength="60">
				DRIVER.findElement(By.cssSelector("input[name='email'][id='email']")).sendKeys("GK@gmail.com");
				//<input maxlength="60" name="password" size="20" type="password">
				DRIVER.findElement(By.cssSelector("input[name='password'][type='password']")).sendKeys("123");
				//<input maxlength="60" name="confirmPassword" size="20" type="password">
				DRIVER.findElement(By.cssSelector("input[name='confirmPassword'][type='password']")).sendKeys("123");
				ScreenShot.captureScreen("D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\ScreenShots\\Captured\\Register.png", DRIVER);
				DRIVER.findElement(By.cssSelector("input[name='submit'][type='submit']")).click();
				ScreenShot.captureScreen("D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\ScreenShots\\Captured\\PostRegister.png", DRIVER);
				
				//<a href="reservation.php" style="margin-left: 5px;color: #0000ee;text-decoration: underline;">Flights</a>
				DRIVER.findElement(By.linkText("Flights")).click();
				ScreenShot.captureScreen("D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\ScreenShots\\Captured\\FlightBooking.png", DRIVER);
				//<input type="radio" name="tripType" value="oneway">
				if(DRIVER.findElement(By.cssSelector("input[type='radio'][name='tripType'][value='roundtrip']")).isSelected()){
				DRIVER.findElement(By.cssSelector("input[type='radio'][name='tripType'][value='oneway']")).click();
				}
/*				<select name="passCount">
*               <option value="1">1 </option>
*                <option value="2">2 </option>
*                ..
*               </select> */
				Select passengerCount = new Select(DRIVER.findElement(By.name("passCount")));
				passengerCount.selectByIndex(3);
				/*<select name="fromPort">
				*<option value="Acapulco">Acapulco</option>.......
						</select>*/
				Select startingPoint = new Select(DRIVER.findElement(By.name("fromPort")));
				startingPoint.selectByValue("New York");
//				<select name="fromMonth">
//				<option value="1">January
//				</option><option value="2">February	</option>..............</select>
				Select fromMonth = new Select(DRIVER.findElement(By.name("fromMonth")));
				fromMonth.selectByValue("11");
				
				Select fromDay = new Select(DRIVER.findElement(By.name("fromDay")));
				fromDay.selectByValue("23");
				
				Select toPort = new Select(DRIVER.findElement(By.name("toPort")));
				toPort.selectByValue("London");
				
				Select toMonth = new Select(DRIVER.findElement(By.name("toMonth")));
				toMonth.selectByVisibleText("April");
				
				Select toDay = new Select(DRIVER.findElement(By.name("toDay")));
				toDay.selectByValue("29");
				
				//<input name="servClass" type="radio" value="First">
				DRIVER.findElement(By.cssSelector("input[name='servClass'][type='radio']"));
				
				Select airline = new Select(DRIVER.findElement(By.name("airline")));
				airline.selectByVisibleText("Blue Skies Airlines");
				ScreenShot.captureScreen("D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\ScreenShots\\Captured\\FlightBooking.png", DRIVER);
				//<input type="image" name="findFlights" src="images/continue.gif" width="104" height="23" border="0">
				DRIVER.findElement(By.cssSelector("input[type='image'][name='findFlights']")).click();
				
				ScreenShot.captureScreen("D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\ScreenShots\\Captured\\PostFlightBooking.png", DRIVER);
				logger.info("Drivre value is ***** " +DRIVER);
				DRIVER.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		        SeleniumActions.sessionEnd(DRIVER);
			}
			else{
				logger.warn("driver is null");
			}
			logger.info("Exit from main() try block ");			
		}
		catch(Exception e){
			logger.error("Exception in main " + e);
		}

	}

}
