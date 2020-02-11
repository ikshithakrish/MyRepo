package com.learning.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.selenium.action.SeleniumActionClass;
import com.selenium.constants.Constants;
import com.selenium.util.LoggerConfig;

public class MouseKeyboardActions_9 {
/*
 * 1. Mouse and Keyboard actions are done using Advance User Interactions API (contains Actions and Action classes needed for 
 * this implementation.
 *  
 */
	static Logger LOGGER = Logger.getLogger(MouseKeyboardActions_9.class);
	static WebDriver DRIVER = null;
	public static void main(String[] args) {
		try{
			LoggerConfig.logger();
			LOGGER.info("ENTER into main() try block");
			String url = "http://demo.guru99.com/test/newtours/";
			List<String> browsers = new ArrayList<String>();
			int browserIndex = 2;
			browsers.add(Constants.INTERNET_EXPLORER); // 0
			browsers.add(Constants.FIREFOX); // 1
			browsers.add(Constants.GOOGLE_CHROME); // 2	|
			
			DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, url);
			if(DRIVER != null){
				LOGGER.info("Enter into main() - try block");
//				<a href="index.php" style="margin-left: 5px;color: #0000ee;text-decoration: underline;">Home</a>
				WebElement homeLinkElement = DRIVER.findElement(By.linkText("Home"));
				Actions actions = new Actions(DRIVER);
				WebElement rowElement = DRIVER.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]"));
				
				LOGGER.info("bgcolor before in home link " + rowElement.getCssValue("background-color"));
				Action mouseOverHomeLink = actions.moveToElement(homeLinkElement).build();
				mouseOverHomeLink.perform();
				LOGGER.info("bgcolor after in home link " + rowElement.getCssValue("background-color"));
				
				homeLinkElement = DRIVER.findElement(By.linkText("Hotels"));
				rowElement = DRIVER.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[3]"));
				LOGGER.info("bgcolor before in home link " + rowElement.getCssValue("background-color"));
				mouseOverHomeLink = actions.moveToElement(homeLinkElement).build();
				mouseOverHomeLink.perform();
				LOGGER.info("bgcolor after in home link " + rowElement.getCssValue("background-color"));
				
				homeLinkElement = DRIVER.findElement(By.linkText("Flights"));
				rowElement = DRIVER.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]"));
				LOGGER.info("bgcolor before in home link " + rowElement.getCssValue("background-color"));
				mouseOverHomeLink = actions.moveToElement(homeLinkElement).build();
				mouseOverHomeLink.perform();
				LOGGER.info("bgcolor after in home link " + rowElement.getCssValue("background-color"));
				
				homeLinkElement = DRIVER.findElement(By.linkText("Destinations"));
				rowElement = DRIVER.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[6]"));
				LOGGER.info("bgcolor before in home link " + rowElement.getCssValue("background-color"));
				mouseOverHomeLink = actions.moveToElement(homeLinkElement).build();
				mouseOverHomeLink.perform();
				LOGGER.info("bgcolor after in home link " + rowElement.getCssValue("background-color"));
//				
				WebElement userNameElement = DRIVER.findElement(By.name("userName"));
				Action enterUpperCase = actions.keyDown(userNameElement, Keys.SHIFT).sendKeys(userNameElement, "GokulA7krishnan ").keyUp(userNameElement, Keys.SHIFT).doubleClick().contextClick().build();
				// press shift and type letter(enter all as upper case(note: caps on should be disabled) then double click over the text and just click again
				enterUpperCase.perform();
				
				subMenu();  // submenu selection
			}
			else{
				LOGGER.error("DRIVER is null");
			}
			LOGGER.info("EXIT from main() - try block");
	}
		catch(Exception e){
			LOGGER.error("Enter into main() - catch(Exception e) block");
			LOGGER.error("Exception found is " + e);
			LOGGER.error("Exit into main() - catch(Exception e) block");
		}
		finally{
			DRIVER.quit();
		}
}
	
	public static void subMenu(){
		try{
			LOGGER.info("ENTER into subMenu() try block");
			String url = "https://www.barbequenation.com/";
			List<String> browsers = new ArrayList<String>();
			int browserIndex = 2;
			browsers.add(Constants.INTERNET_EXPLORER); // 0
			browsers.add(Constants.FIREFOX); // 1
			browsers.add(Constants.GOOGLE_CHROME); // 2	|
			
			DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, url);
			if(DRIVER != null){
				LOGGER.info("ENter into-------------------------------------");
				//DRIVER.findElement(By.cssSelector("a[class='ubermenu-target ubermenu-item-layout-default ubermenu-item-layout-text_only']")).click();
				int size = DRIVER.findElements(By.cssSelector("a[class='ubermenu-target ubermenu-item-layout-default ubermenu-item-layout-text_only']")).size();
				LOGGER.info("count is --------- " + size); // 11 found
				
				// DRIVER.findElement(By.xpath("/html/body/div[1]/header/div[2]/div/div/nav/nav/ul/li[7]/a")).click();;
				Actions subMenuActions = new Actions(DRIVER);
				WebElement mainMenu = DRIVER.findElement(By.xpath("/html/body/div[1]/header/div[2]/div/div/nav/nav/ul/li[7]/a"));
				Action subMenuSelection = subMenuActions.moveToElement(mainMenu).build(); 
				subMenuSelection.perform();
				WebElement subMenu1 = DRIVER.findElement(By.xpath("/html/body/div[1]/header/div[2]/div/div/nav/nav/ul/li[7]/ul/li[1]/a"));
				subMenuSelection = subMenuActions.moveToElement(subMenu1).build(); 
				subMenuSelection.perform();
				
				WebElement subMenu2 = DRIVER.findElement(By.xpath("//*[@id='menu-item-531']"));
				//subMenu2.click();
				// or
				subMenuSelection = subMenuActions.moveToElement(subMenu2).click().build(); 
				subMenuSelection.perform();
			
			}
		}
		catch(Exception e){
			
		}
		finally{
			DRIVER.quit();
		}
	}
	
	}  // class End


/*
 * 
 1. clickAndHold() 	Clicks (without releasing) at the current mouse location.
2. contextClick() 	Performs a context-click at the current mouse location. (Right Click Mouse Action)
3. doubleClick() 	Performs a double-click at the current mouse location.
4. dragAndDrop(source, target) 	Performs click-and-hold at the location of the source element, moves to the location of the target element, then releases the mouse.
Parameters:
source- element to emulate button down at.
target- element to move to and release the mouse at.
5.dragAndDropBy(source, x-offset, y-offset) 	Performs click-and-hold at the location of the source element, moves by a given offset, then releases the mouse.
Parameters:
source- element to emulate button down at.
xOffset- horizontal move offset.
yOffset- vertical move offset.
6. keyDown(modifier_key) 	Performs a modifier key press. Does not release the modifier key - subsequent interactions may assume it's kept pressed.
Parameters:
modifier_key - any of the modifier keys (Keys.ALT, Keys.SHIFT, or Keys.CONTROL)
7. keyUp(modifier _key) 	Performs a key release.
Parameters:
modifier_key - any of the modifier keys (Keys.ALT, Keys.SHIFT, or Keys.CONTROL)
8. moveByOffset(x-offset, y-offset) 	Moves the mouse from its current position (or 0,0) by the given offset.
Parameters:
x-offset- horizontal offset. A negative value means moving the mouse left.
y-offset- vertical offset. A negative value means moving the mouse down.
9. moveToElement(toElement) 	Moves the mouse to the middle of the element.
Parameters:
toElement- element to move to.
10. release() 	Releases the depressed left mouse button at the current mouse location
sendKeys(onElement, charsequence) 	Sends a series of keystrokes onto the element.
Parameters:
11. onElement - element that will receive the keystrokes, usually a text field
charsequence - any string value representing the sequence of keystrokes to be sent 
 */

