package com.selenium.source;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Download {

	public static void main(String[] args) {
		System.setProperty("webdriver.firefox.marionette","D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\IEDriverServer.exe");
        String baseUrl = "http://demo.guru99.com/test/yahoo.html";
WebDriver driver = new InternetExplorerDriver();

driver.get(baseUrl);
WebElement downloadButton = driver.findElement(By.id("messenger-download"));
String sourceLocation = downloadButton.getAttribute("href");
String wget_command = "cmd /c C:\\Wget\\wget.exe -P D: --no-check-certificate " + sourceLocation;

try {
Process exec = Runtime.getRuntime().exec(wget_command);
int exitVal = exec.waitFor();
System.out.println("Exit value: " + exitVal);
} catch (Exception ex) {
System.out.println(ex.toString());
}
driver.close();
}
	}


