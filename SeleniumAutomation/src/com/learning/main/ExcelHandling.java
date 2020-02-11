package com.learning.main;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.selenium.action.SeleniumActionClass;
import com.selenium.constants.Constants;
import com.selenium.util.FileHandling;
import com.selenium.util.LoggerConfig;
import com.selenium.util.SeleniumActions;

public class ExcelHandling {
	
	public static Logger LOGGER = Logger.getLogger(ExcelHandling.class);
	
	public static String EXCEL_FILE = null;
	public static String SHEET_NAME = null;
	//public static String ELEMENT_NAME = null;
	public static WebDriver DRIVER = null;
	public static String URL = null;
	
	public static int BROWSER_INDEX = 0;
	public static int ROW_NUMBER = 0;
	public static int COLUMN_NUMBER = 0;
	
	public static List<String> SINGLE_ROW_DATA = null;
	public static List<String>[] ALL_ROW_DATA  = null;   // store all data for the respective ROW(s) (i.e., t)
	
	
	public static void main(String[] args) {
		LoggerConfig.logger(); // write log in external file / console
		EXCEL_FILE = "D:\\My Assignments\\Selenium_UI_AUTOMATION\\FileHandling\\Excel\\TestAutomation.xlsx";
		SHEET_NAME = "Registration";
		//ELEMENT_NAME = "Test_Uname";
		
		//Launch Browser - BEGIN
		List<String> browsers = new ArrayList<String>();
		BROWSER_INDEX = 2;
		String URL = "http://demo.guru99.com/test/newtours/";
		browsers.add(Constants.INTERNET_EXPLORER); // 0
		browsers.add(Constants.FIREFOX); // 1
		browsers.add(Constants.GOOGLE_CHROME); // 2			
		DRIVER = SeleniumActionClass.launchURL(BROWSER_INDEX, URL); // Browser index: 0 - IE, 1 - FireFox, 2 - Chrome
		if(DRIVER != null){	// if Driver !=null - BEGIN
			// ALL_ROW_DATA - contains row(s) data in array of arrayList
			ALL_ROW_DATA = FileHandling.readRowData(EXCEL_FILE, SHEET_NAME); // String filePath, String sheetNameParam
			if(ALL_ROW_DATA.length > 0){  // if ALL_ROW_DATA.length > 0   - BEGIN
				LOGGER.info("Array Length is " + ALL_ROW_DATA.length);
				for(ROW_NUMBER = 0; ROW_NUMBER< ALL_ROW_DATA.length; ROW_NUMBER++){  // for ROW_NUMBER - BEGIN 
					LOGGER.info(ALL_ROW_DATA[ROW_NUMBER]);
					SINGLE_ROW_DATA = ALL_ROW_DATA[ROW_NUMBER];
					LOGGER.info("this row has "+SINGLE_ROW_DATA.size()+ "columns and the data contains: " + SINGLE_ROW_DATA.get(0));
					SeleniumActions.optionType(DRIVER, SINGLE_ROW_DATA);
				}  // for ROW_NUMBER - END
			} // if ALL_ROW_DATA.length > 0   - END
		}   // if Driver !=null - END	
//			else{   // else Driver =null - BEGIN	
//				LOGGER.warn("DRIVER is null");
//		}    // else Driver =null - BEGIN
		//Launch Browser - END	
	
		
	}  // main() - END

}
