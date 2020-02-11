package com.selenium.util;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.selenium.action.SeleniumActionClass;
import com.selenium.constants.Constants;

public class Test {

	public static void main(String[] args) {
		String CONFIG_FILE_PATH = "src\\com\\selenium\\properties\\config.properties";
		//SeleniumActionClass.launchURL(2, "https://google.com");
		Properties propertiesFile = ReadProperties.readPropertiesFile(CONFIG_FILE_PATH);
		System.setProperty(propertiesFile.getProperty(Constants.IE_WEBDRIVER), propertiesFile.getProperty(Constants.IE_DRIVER_PATH));
		WebDriver DRIVER = new InternetExplorerDriver();
		DRIVER.get("https://google.com");

	}

}
