package com.learning.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import com.selenium.action.SeleniumActionClass;
import com.selenium.constants.Constants;

/*  
 * MRI(Bookmarklet to find elements) - http://www.westciv.com/mri/
 *  reference url ---- https://www.guru99.com/
 *  xPath - xml Path (syntax / language to find the webelement in a webpage using HTML DOM structure)
 *  Syntax: //tagName[@attribute='value']
 *    // - select current node, tagName - particula Node, @ - Select attribute, attribute - node attribute name, value - respective attribute value
 *    XPath Locators - id, classname, name, linktext, xpath, cssSelector
 *    XPath types - 1. Absolute XPath 2. Relative XPath
 *    	1. Absolute XPath: begins with single slash(starts from the root node (<html>), Disadv: any changes in the path need to modify
 *    			Example: /html/body/div[1]/section/div[1]/div/div/div/div[1]/div/div/div/div/div[3]/div[1]/div/h4[1]/b
 *    	2. Relative XPath: begins with double slash, can find the element from any where from the webpage
 *     			 Example: //*[@class='featured-box']//*[text()='Testing']
 *    XPath Axes
 *        AxesMethods to find dynamic or find the element without locators(id, class name...)
 *        Commonly useing Axes Methods like child, parent, ancestor, sibling, preceding, self, etc.
 *        1. Basic XPath: 
		           Xpath=//input[@name='uid']
		           Xpath=//input[@type='text']				
					Xpath=	//label[@id='message23']
					Xpath=	//input[@value='RESET']
					Xpath=//*[@class='barone']
					Xpath=//a[@href='http://demo.guru99.com/']
					Xpath= //img[@src='//cdn.guru99.com/images/home/java.png']
 *        2.  Contains()
			         Xpath=//*[contains(@type,'sub')]    -- usign this user can find the type as submit
			         Xpath=//*[contains(@name,'btn')]   -- usign this user can find the type as btnLogin
			         Xpath=//*[contains(@id,'message')]	-- message is partial so it can find more than one element have id as message1 / message2 /messageSuccess
			         Xpath=//*[contains(text(),'here')]       -- <a>login-here</a>
					Xpath=//*[contains(@href,'guru99.com')] -- <a href="http://guru99.com/home"
			3. Using OR & AND: 
					Xpath=//*[@type='submit' or @name='btnReset']     -- either any/all condition is true result will be true else false
					Xpath=//input[@type='submit' and @name='btnLogin']  -- all the conditions shoule be true then result will be true else false
         	4. Start-with function:
         	Xpath=//label[starts-with(@id,'message')]  - find the ids like Id=" message12" / Id=" message12343" / Id=" messagesuccess"
         	5. Text()
         	Xpath=//td[text()='UserID']	-- check with exact text match  -- Ex: <td id="data1"> UserId </td>
         	6. XPath Axes Method: (helps to find the complex or dynamic elements)
         	6.a. following - selects all the elements in the current node
         	Xpath=//*[@type='text']//following::input
         	Xpath=//*[@type='text']//following::input[1]  -- select only first element in this 
         	Xpath=//*[@type='text']//following::input[2]  -- select only second element in this
         	6.b. Ancestor: Select all the acestor(GrandParent, Parent, etc.) of the current node
         	Xpath=//*[text()='Enterprise Testing']//ancestor::div
         	Xpath=//*[text()='Enterprise Testing']//ancestor::div[1]  -- select first div in this selection
         	6.c. child - find all the children elements of the current node
         	Xpath=//*[@id='java_technologies']/child::li
         	Xpath=//*[@id='java_technologies']/child::li[3] -- -- select third div in this selection
         	 6.d. preceding
         	 Xpath=//*[@type='submit']//preceding::input
         	 Xpath=//*[@type='submit']//preceding::input[1]
         	 6.e. Following-sibling  - find the element after the current node
			xpath=//*[@type='submit']//following-sibling::input
			6.f. Parent - select parent of current node
			Xpath=//*[@id='rt-feature']//parent::div
			6.g. Self - Selects current node (select itself)
			Xpath =//*[@type='password']//self::input
			6.h. Descendant  // down under the node????
			Xpath=//*[@id='rt-feature']//descendant::a
			
			
 */
public class Xpath_11 {

	public static Logger LOGGER = Logger.getLogger(Xpath_11.class);
	public static WebDriver DRIVER = null;
	public static String URL = "https://www.guru99.com/";
	
	public static void main(String[] args) {
		try{ // try - BEGIN
			LOGGER.info("Enter into main - try block");	
			
			
			xPathFinder();
			LOGGER.info("Exit from main - try block");
			} // try - END
			catch(Exception e){  //catch(Exception e) - BEGIN 
				LOGGER.warn("Enter into main - catch(Exception e) block");	
				LOGGER.warn("Exit from main - catch(Exception e) block");	
			} //catch(Exception e) - END

		finally{
			DRIVER.close();
			DRIVER.quit();
		}
	}
	
	static void xPathFinder(){
		LOGGER.info("Enter into xPathFinder()");		
		
		List<String> browsers = new ArrayList<String>();
		int browserIndex = 2;
		browsers.add(Constants.INTERNET_EXPLORER); // 0
		browsers.add(Constants.FIREFOX); // 1
		browsers.add(Constants.GOOGLE_CHROME); // 2	|
		
		DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, URL);
		
		//DRIVER = new ChromeDriver();
		//DRIVER.get(URL);
		Actions subMenuActions = new Actions(DRIVER);
		WebElement tempElement1 = DRIVER.findElement(By.xpath("//a[@href='/angularjs-tutorial.html']"));
		Action subMenuSelection = subMenuActions.moveToElement(tempElement1).build(); 
		subMenuSelection.perform();
		
		//*[contains(@type,'sub')]
		tempElement1 = DRIVER.findElement(By.xpath("//*[contains(@type,'Search for your')]"));
		Action subMenuSelection1 = subMenuActions.moveToElement(tempElement1).doubleClick(tempElement1).build(); 
		subMenuSelection1.perform();
		LOGGER.info("Exit from xPathFinder()");
	}


}
