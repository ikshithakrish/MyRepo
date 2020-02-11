package pages;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumGrid {
	// Ref: https://www.browserstack.com/guide/selenium-grid-tutorial
	// http://www.software-testing-tutorials-automation.com/2016/04/running-multiple-nodes-of-selenium-grid.html
	// Hub config: http://www.software-testing-tutorials-automation.com/2016/02/selenium-grid-2-configuration-setup-hub.html
	// Node config in HUB: http://www.software-testing-tutorials-automation.com/2016/03/how-to-configure-selenium-grid-2-node.html
	
	/*
	command to enable HUB
	cd D:\My Assignments\Selenium_UI_AUTOMATION\Selenium Grid\HUB  (selenium-server-standalone-3.141.59.jar is located)
	java -jar selenium-server-standalone-3.141.59.jar -port 4444 -role hub
	
	command to enable NODE(s) - opend another command prompt
	cd D:\My Assignments\Selenium_UI_AUTOMATION\Selenium Grid\HUB
	java -jar selenium-server-standalone-2.52.0.jar -role node -Dwebdriver.ie.driver="D:/IEDriverServer.exe" -Dwebdriver.chrome.driver="D:/chromedriver.exe" -hub http://localhost:4444/grid/register -port 5566
	
	// set webdriver
	D:\My Assignments\Selenium_UI_AUTOMATION\Selenium Grid\HUB>
	One node multiple browser(webdriver) - IE and chrome
	java -Dwebdriver.ie.driver="D:\IEDriverServer.exe" -Dwebdriver.chrome.driver="D:\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://localhost:4444/grid/register -port 5566	
	
	Individual node configure with Individual port
	 Note: cannot configure browser(web browser) separately on the same port (get bind port already exist)
	java -Dwebdriver.ie.driver="D:\IEDriverServer.exe" -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://localhost:4444/grid/register -port 5566
	java -Dwebdriver.chrome.driver="D:\chromedriver.exe" -jar selenium-server-standalone-3.141.59.jar -role webdriver -hub http://localhost:4444/grid/register -port 5567
	URL:
	http://localhost:4444/grid/console
	
	
	// Desiredcapability config of all browsers: https://developers.perfectomobile.com/pages/viewpage.action?pageId=21435360
	// json (node and hub config) : 
	 https://www.seleniumeasy.com/selenium-tutorials/configure-selenium-grid-using-json-config-file
	 https://medium.com/@mustafayol/selenium-grid-running-test-cases-on-a-particular-node-with-json-files-bd734d5fb24e	
	 https://medium.com/maestral-solutions/selenium-grid-setup-the-complete-guide-cf000a2be50f

	*/
	//Note: Hub should be up and running then only node can be accessible
	//how to create bat file
	
	WebDriver chromeDriver = null;
	WebDriver ieDriver = null;
	 String baseUrl = null;
	 String nodeUrl = null;
	  
	 @BeforeTest
	 public void setUp() throws MalformedURLException, InterruptedException {  // import java.net.MalformedURLException;
		 
		 baseUrl = "https://www.google.com/";
		 // nodeUrl = "http://192.168.43.44:4444/wd/hub";
		 nodeUrl = "http://192.168.225.41:4444/wd/hub";  // http://192.168.225.41:4444/wd/hub
		  
		  
		 DesiredCapabilities chromeCapability =  DesiredCapabilities.chrome();
		  chromeCapability.setBrowserName("chrome");
		  chromeCapability.setPlatform(Platform.WINDOWS);
		  
		  ChromeOptions options = new ChromeOptions();
		    options.merge(chromeCapability);
		    
		 
		  chromeDriver = new RemoteWebDriver(new URL(nodeUrl), chromeCapability); // import java.net.URL; and import org.openqa.selenium.remote.RemoteWebDriver;
		  chromeDriver.get(baseUrl);
		  
		  
		  /* Ref for IE Capabilities:  
		  https://codoid.com/exploring-ie-driver-desired-capabilities/
		  https://www.lambdatest.com/blog/desired-capabilities-in-selenium-testing/
		  */
		  
//		  DesiredCapabilities ieCapability = DesiredCapabilities.internetExplorer();
//		  ieCapability.setBrowserName("internet explorer");
//		  ieCapability.setPlatform(Platform.WINDOWS);
//		  
//		  ieDriver = new RemoteWebDriver(new URL(nodeUrl), ieCapability); // import java.net.URL; and import org.openqa.selenium.remote.RemoteWebDriver;
		  
	 }
	
	 @AfterTest	
	 public void afterTest() {
		 chromeDriver.quit();
//		 ieDriver.quit();
	 }
  @Test
  public void gridSelenium() {
	  chromeDriver.get(baseUrl);
//	  ieDriver.get(baseUrl);
  }
  
  
  
  
}
