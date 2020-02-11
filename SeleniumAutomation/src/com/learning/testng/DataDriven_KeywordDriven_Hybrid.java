package com.learning.testng;

import java.util.List;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.util.FileHandling;
import com.selenium.util.LoggerConfig;
import com.selenium.util.SeleniumActions;

public class DataDriven_KeywordDriven_Hybrid {
 
	public static Logger LOGGER = Logger.getLogger(DataDriven_KeywordDriven_Hybrid.class);
	public static String EXCEL_FILE = null;
	public static String SHEET_NAME = null;
	
	public static int ROW_NUMBER = 0;
	public static int COLUMN_NUMBER = 0;
	
	public static List<String> SINGLE_ROW_DATA = null;
	public static List<String>[] ALL_ROW_DATA  = null;   // store all data for the respective ROW(s) (i.e., t)
	
  @BeforeTest
  public void beforeTest() {
	  LoggerConfig.logger(); // write log in external file / console
	  EXCEL_FILE = "D:\\My Assignments\\Selenium_UI_AUTOMATION\\FileHandling\\Excel\\FlightsBooking.xlsx";
	  SHEET_NAME = "FlightBooking";
  }
  
  @Test
  public void exection(){
	// ALL_ROW_DATA - contains row(s) data in array of arrayList
				ALL_ROW_DATA = FileHandling.readRowData(EXCEL_FILE, SHEET_NAME); // String filePath, String sheetNameParam
				if(ALL_ROW_DATA.length > 0){  // if ALL_ROW_DATA.length > 0   - BEGIN
					LOGGER.info("Array Length is " + ALL_ROW_DATA.length);
					for(ROW_NUMBER = 0; ROW_NUMBER< ALL_ROW_DATA.length; ROW_NUMBER++){  // for ROW_NUMBER - BEGIN 
						LOGGER.info(ALL_ROW_DATA[ROW_NUMBER]);
						SINGLE_ROW_DATA = ALL_ROW_DATA[ROW_NUMBER];
						LOGGER.info("this row has "+SINGLE_ROW_DATA.size()+ "columns and the data contains: " + SINGLE_ROW_DATA.get(0));
						SeleniumActions.optionType(SINGLE_ROW_DATA);
					}  // for ROW_NUMBER - END
				} // if ALL_ROW_DATA.length > 0   - END
  }

  @AfterTest
  public void afterTest() {
  }

}
