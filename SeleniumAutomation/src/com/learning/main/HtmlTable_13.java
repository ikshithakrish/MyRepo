package com.learning.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.action.SeleniumActionClass;
import com.selenium.constants.Constants;
import com.selenium.util.LoggerConfig;

public class HtmlTable_13 {

	public static Logger LOGGER = Logger.getLogger(HtmlTable_13.class);
	public static WebDriver DRIVER = null;
	public static String URL = "http://demo.guru99.com/test/web-table-element.php";
	public static void main(String[] args) {
		try{
			LoggerConfig.logger();
			LOGGER.info("Enter into main() try block");
			dynamicHtmlTable();
			LOGGER.info("Exit from main() try block");
		}
		catch(Exception e){
			LOGGER.warn("Enter into main() catch(Exception e) block");
			LOGGER.error("Exception found in main() " + e );  
			LOGGER.warn("Enter into main() catch(Exception e) block");
		}
		finally{
			DRIVER.close();
			DRIVER.quit();
		}
	}
	
	static void dynamicHtmlTable(){

LOGGER.info("Enter into dynamicHtmlTable()");		
		
		List<String> browsers = new ArrayList<String>();
		int browserIndex = 2;
		browsers.add(Constants.INTERNET_EXPLORER); // 0
		browsers.add(Constants.FIREFOX); // 1
		browsers.add(Constants.GOOGLE_CHROME); // 2	|
		
		/* Note:   both are working fine
					in Firefox getting the xpath as --  //div[1]/div[3]/div[1]/table/......
					in chrome getting the xpath as -- //*[@id='leftcontainer']/table/....... 					
		*/
		
		DRIVER = SeleniumActionClass.launchURL(browsers, browserIndex, URL);
		List<WebElement> rows = DRIVER.findElements(By.xpath("//div[1]/div[3]/div[1]/table/tbody/tr/td[1]"));
		List<WebElement> columns = DRIVER.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[1]/td"));
		int rowSize = rows.size();
		int columnSize = columns.size();
		LOGGER.info("row Count is " + rowSize + " column count is " + columnSize);	// row Count is 26 column count is 5		
		// fetch table header
		int headerCount = DRIVER.findElements(By.xpath("//div[1]/div[3]/div[1]/table/thead/tr/th")).size();
		for(int i = 1 ; i <= headerCount ; i ++){
			// LOGGER.info(DRIVER.findElement(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th[" + i + "]")).getText());
			System.out.print(DRIVER.findElement(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th[" + i + "]")).getText() + " -- ");
			// Company -- Group -- Prev Close (Rs) -- Current Price (Rs) -- % Change --
		}
		
		// fetch all the data in (row X column)
		for(int i = 1 ; i <= rowSize; i++){
			for(int j = 1 ; j<=columnSize; j++){
				// LOGGER.info(DRIVER.findElement(By.xpath("//div[1]/div[3]/div[1]/table/tbody/tr["+ i + "]/td[" + j + "]")).getText()  );
				System.out.print(DRIVER.findElement(By.xpath("//div[1]/div[3]/div[1]/table/tbody/tr["+ i + "]/td[" + j + "]")).getText() + " -- ");
			}
			System.out.println();
		}
		/*  (note: the content in this page is keep on changing every time (dynamic)
		 GRUH Finance Li -- A -- 115.3 -- 293.5 -- + 9.5 --
		 NCC -- A -- 143.2 -- 627.3 -- + 8.5 -- 
		YES Bank Ltd. -- A -- 643.7 -- 334.8 -- + 6 -- 
		Kajaria Ceramics -- A -- 305.5 -- 588.3 -- + 3.8 -- 
		Gujarat Narmada Vall -- A -- 383.3 -- 372.5 -- + 6.4 -- 
		Power Finance Co -- A -- 320.6 -- 866.4 -- + 2 -- 
		IL&FS Transportation -- A -- 376.6 -- 424.1 -- + 4.6 -- 
		Coffee Day Enterpris -- A -- 215.8 -- 485 -- + 4.9 -- 
		Punj. NationlBak -- A -- 109.6 -- 34.6 -- + 9.2 -- 
		YES Bank Ltd. -- A -- 326.5 -- 702.6 -- + 5.4 -- 
		LIC Housing Fi -- A -- 217.8 -- 216.1 -- + 2.3 -- 
		Kirloskar Oil Engine -- A -- 674.9 -- 819 -- + 8.8 -- 
		Gujarat Narmada Vall -- A -- 276.2 -- 699.8 -- + 2 -- 
		Hero MotoCorp -- A -- 540.7 -- 849.7 -- + 2.6 -- 
		Cera Sanitaryware L -- A -- 799 -- 51 -- + 3.2 -- 
		Kirloskar Oil Engine -- A -- 291.5 -- 999.9 -- + 5.8 -- 
		Chennai Petro. -- A -- 864 -- 767.4 -- + 9.1 -- 
		Coffee Day Enterpris -- A -- 519.5 -- 213 -- + 3.6 -- 
		Hind. Petrol -- A -- 366.9 -- 798.7 -- + 2.5 -- 
		Rashtriya Chemicals -- A -- 799.7 -- 611.1 -- + 3.7 -- 
		Welspun Corp -- A -- 214.1 -- 701.8 -- + 2 -- 
		Power Finance Co -- A -- 95 -- 80.4 -- + 2.6 -- 
		Vakrangee -- A -- 961.9 -- 751.2 -- + 4.9 -- 
		Marico Ltd. -- A -- 776.5 -- 76.7 -- + 7.3 -- 
		Ajanta Pharma Lt -- A -- 45.6 -- 618.7 -- + 5 -- 
		Dewan Housing -- A -- 742.8 -- 306.2 -- + 8.6 --
		 */
		
		LOGGER.info("Exit from dynamicHtmlTable()");
	}

}
