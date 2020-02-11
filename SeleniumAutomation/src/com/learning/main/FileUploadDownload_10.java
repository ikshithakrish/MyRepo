package com.learning.main;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.selenium.constants.Constants;
import com.selenium.util.ReadProperties;

public class FileUploadDownload_10 {

	// ref: https://www.swtestacademy.com/download-file-in-selenium/
	// also refer; https://www.toolsqa.com/selenium-webdriver/how-to-download-files-using-selenium/
	
	public static Logger LOGGER = Logger.getLogger(FileUploadDownload_10.class);
	public static String CONFIG_FILE_PATH = "src\\com\\selenium\\properties\\config.properties";
	public static Properties propertiesFile = ReadProperties.readPropertiesFile(CONFIG_FILE_PATH);
	
	public static WebDriver DRIVER = null;
	public static String URL = "https://www.apache.org/dyn/closer.lua/logging/log4j/2.12.1/apache-log4j-2.12.1-bin.zip";
	
	public static void main(String[] args) {  // main - BEGIN
	try{ // try - BEGIN
	LOGGER.info("Enter into main - try block");	
	
	
	fileDownload();
	LOGGER.info("Exit from main - try block");
	} // try - END
	catch(Exception e){  //catch(Exception e) - BEGIN 
		LOGGER.warn("Enter into main - catch(Exception e) block");	
		LOGGER.warn("Exit from main - catch(Exception e) block");	
	} //catch(Exception e) - END
	} // main - END

	
	static void fileUpload(){
		
	}
	
	static void fileDownload(){
		LOGGER.info("Enter into fileDownload()");		
		System.setProperty(propertiesFile.getProperty(Constants.CHROME_WEBDRIVER), propertiesFile.getProperty(Constants.CHROME_DRIVER_PATH));
		//DRIVER = new ChromeDriver();			
		
		
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		//Disable download prompt in chrome browser - BEGIN
		chromePrefs.put("profile.default_content_settings.popups", 0);
		//chromePrefs.put("download.default_directory", System.getProperty("user.dir"));
		chromePrefs.put("download.default_directory", "C:\\Users\\BusyBee\\Downloads\\Mp3 Collections\\Pending\\Test");		 
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		//Disable download prompt in chrome browser - END
		DRIVER = new ChromeDriver(options);
		DRIVER.get(URL);
		
		//DRIVER.navigate().to("https://www.thinkbroadband.com/download");
		DRIVER.findElement(By.xpath("/html/body/div/p[7]/a[1]")).click();;
		
		// Check the file in the downloaded folder
		//File folder = new File(System.getProperty("user.dir"));
		File folder = new File(System.getProperty("C:\\Users\\BusyBee\\Downloads\\Mp3 Collections\\Pending\\Test"));
		 		//List the files on that folder
		File[] listOfFiles = folder.listFiles();
		boolean found = false;
		File f = null;
		     //Look for the file in the files
		     // You should write smart REGEX according to the filename
		     for (File listOfFile : listOfFiles) {
		         if (listOfFile.isFile()) {
		              String fileName = listOfFile.getName();
		               System.out.println("File " + listOfFile.getName());
		               if (fileName.matches("5MB.zip")) {
		                   f = new File(fileName);
		                   found = true;
		                }
		            }
		        }
		LOGGER.info("Exit from fileDownload()");
	}
	
}
