package step_def_REGISTRATION;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import pom_object_repo.Registration_POM;

public class Registration_StepDef {
	
	WebDriver driver = null;

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "D:\\My Assignments\\Selenium_UI_AUTOMATION\\Download\\Chrome\\ChromeDriver 83.0.4103.61\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver();
		
	}
	
	@Given("^Launch the URL \"(.*)\"$")
	public void launchURL(String URL) throws Throwable {
		System.out.println("URL-------------" + URL);
		driver.get(URL);
		driver.manage().window().maximize();
	}
         //User provide the <FIRST_NAME> <LAST_NAME> <PHONE_NO> and <EMAIL_ID>	
	//@When("^User provide the \"(.*)\" \"(.*)\" \"(.*)\" and \"(.*)\"$")
	
	
	//When User provide the <first_Name>
	@When("^User provide the \"(.*)\", \"(.*)\", \"(.*)\" and \"(.*)\"$")
	public void input(String first_Name, String lastName, String phone, String email) throws Throwable {
	
		//System.out.println("First name is " + first_Name);
//		WebElement fname = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/input"));
//		WebElement lname = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/input"));
//		WebElement phone1 = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/input"));
//		WebElement email1 = driver.findElement(By.xpath("//*[@id=\"userName\"]"));
	
		WebElement fname = driver.findElement(Registration_POM.FirstName);
		WebElement lname = driver.findElement(Registration_POM.LastName);
		WebElement phone1 = driver.findElement(Registration_POM.PhoneNo);
		WebElement email1 = driver.findElement(Registration_POM.Email);
		
		
		
		fname.sendKeys(first_Name);
		lname.sendKeys(lastName);
		phone1.sendKeys(phone);
		email1.sendKeys(email);
	}
    
	@And("^Close the browser$")
	public void closeBrowser() throws Throwable{
		driver.close();
		driver.quit();
	}
	
}
