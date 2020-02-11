package com.selenium.util;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenShot {
	public static Logger logger = Logger.getLogger(ScreenShot.class);
	
	public static boolean isCaptured;
	public static boolean captureScreen(String path, WebDriver driver){
		try{
			LoggerConfig.logger(); // write log in external file / console
			if((! path.equals("")) || (! path.equals(null)) ){
			TakesScreenshot screenShot =((TakesScreenshot)driver);
			File sourceFile = screenShot.getScreenshotAs(OutputType.FILE);
			File destinationFile = new File(path);
			FileUtils.copyFile(sourceFile, destinationFile);
			logger.info("Captured Screen");
			}
			else{
				logger.error("path is not valid");
			}
		}
		catch(Exception e){
			logger.warn("Exception in screen shot capturing " + e );
			}
		return isCaptured;
	}
}
