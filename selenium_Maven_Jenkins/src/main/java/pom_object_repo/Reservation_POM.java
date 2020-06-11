package pom_object_repo;

import java.lang.reflect.Field;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constants;


public class Reservation_POM {	
	private WebDriver DRIVER = null;
	public String ACTION_TYPE = null;
	public WebElement ELEMENT = null;
	public List<WebElement> RADIO_BUTTON_WEBELEMENT = null;
	public boolean IS_ELEMENT_EXIST = false;
	
	//POM
	 public By FLIGHTS =  By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a");
	 public By FlightsFinder =  By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img");
	 public By TripType =  By.cssSelector("input[type='radio'][name='tripType']");
	 public By PassangersCount =  By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/b/select");
	 //selectByIndex
	 public By DepartureFrom =  By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[4]/td[2]/select");
	 //selectByValue
	 public By StartMonth =  By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td[2]/select[1]");
	 //selectByIndex
	 public By StartDay =  By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[5]/td[2]/select[2]");
	 //selectByIndex
	 public By ArrivalIn =  By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[6]/td[2]/select");
	 // selectByVisibleText
	 public By ReturningMonth =  By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/select[1]");
	 // selectByIndex
	 public By ReturningDay =  By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[7]/td[2]/select[2]");
	 // selectByIndex
	 public By ServiceClass =  By.cssSelector("input[type='radio'][name='servClass']"); 
	 public By AirLine =  By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[10]/td[2]/select");
	 // selectByVisibleText
	 public By ContinueBooking =  By.xpath("/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[14]/td/input");
	 
	 
	// Page Factory 
	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[2]/td[2]/a")
	 public WebElement FLIGHT_TEST;
	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[1]/td/img")
	public WebElement FlightsFinder1;
	@FindBy(css="input[type='radio'][name='tripType']")  // cssSelector
	public List<WebElement> TripType1;  // cannot implement using java reflector so we go with POM
	@FindBy(xpath="/html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[3]/td[2]/b/select")
	public WebElement PASSANGERS_COUNT1;
	 //selectByIndex
	
//	public Reservation_POM(WebDriver driver) {
//		DRIVER = driver;
//		//This initElements method will create all WebElements
//		PageFactory.initElements(DRIVER, this);
//	}
	//Page Factory ends
	
	//setValues
//	public void setFirstName(String value1) {
//		driver.findElement(flights).sendKeys(value1);
//	}	
	
	//Click
    public void clickLogin(){
//    	if(.findElements(FLIGHTS).size() > 0) {
//            DRIVER.findElement(FLIGHTS).click();
//    	}
//    	else {
//    		//element not found
//    	}
    }
    
    public void clickLogin1(){
    	if(FLIGHT_TEST.isDisplayed()) {
    		FLIGHT_TEST.click();
    	}
    	else {
    		// element not found
    	} 
    }	
    	
    public boolean isLocatorExist(String objectName, String actionType, Object ref, WebDriver driver) throws NoSuchFieldException, IllegalAccessException {
    	Field fieldName = ref.getClass().getField(objectName);
    	System.out.println("Field Name -- " + fieldName);
    	By byLocator = (By) fieldName.get(ref);  //for locators
    	System.out.println("byLocator -- " + byLocator);
    	System.out.println("actionType -- " + actionType);
    	//WebElement element = (WebElement) fieldName.get(this);   // for WebElement
    	if(!actionType.equalsIgnoreCase(Constants.RADIO_BUTTON)){   // if not Radio_Button - BEGIN
			ELEMENT = driver.findElement(byLocator);  // InvocationTargetException and IllegalAccessException needs to be adder for byMethod.invoke(null, "")
			System.out.println("ELEMENT -- " + ELEMENT);
			IS_ELEMENT_EXIST = ELEMENT.isDisplayed();
			System.out.println("IS_ELEMENT_EXIST -- " + IS_ELEMENT_EXIST);
		}
    	else {
    		RADIO_BUTTON_WEBELEMENT = driver.findElements(byLocator);
    		IS_ELEMENT_EXIST = ELEMENT.isDisplayed();
			if(RADIO_BUTTON_WEBELEMENT.size() > 0)
				IS_ELEMENT_EXIST = true;
			else
				IS_ELEMENT_EXIST = false;
    	}    	
    	if(actionType.equalsIgnoreCase("Click")) {
    		ELEMENT.click();
    	}
		return IS_ELEMENT_EXIST;
    }

    public boolean isElementExist(String objectName, String actionType, WebDriver driver) throws NoSuchFieldException, IllegalAccessException {
    	
    	DRIVER = driver;
		//This initElements method will create all WebElements
		PageFactory.initElements(DRIVER, this);
		
    	Field fieldName = this.getClass().getField(objectName);
    	//By byLocator = (By) fieldName.get(this);  //for locators
    	//WebElement webElement = (WebElement) fieldName.get(this);   // for WebElement
    	WebElement webElement = (WebElement) fieldName.get(this);
    	webElement.click();
    	
    	//java.lang.reflect.Field field = panel.getClass().getDeclaredField("foundBy");
    	Field field1 = webElement.getClass().getDeclaredField("FLIGHT_TEST");
    	field1.setAccessible(true);
    	//String foundBy = field1.get(element).toString();
    	String findBy = field1.get(this).toString();
    	System.out.println("findby type is " + findBy);
    	
//    	if(! actionType.equalsIgnoreCase(Constants.RADIO_BUTTON)){   // if not Radio_Button - BEGIN
////			ELEMENT = DRIVER.findElement(byLocator);  // InvocationTargetException and IllegalAccessException needs to be adder for byMethod.invoke(null, "")
////			IS_ELEMENT_EXIST = ELEMENT.isDisplayed();
//    		IS_ELEMENT_EXIST = webElement.isDisplayed();
//		}
//    	else {    		
//    		//RADIO_BUTTON_WEBELEMENT = webElement.findElements(by); //
//    		IS_ELEMENT_EXIST = ELEMENT.isDisplayed();
//			if(RADIO_BUTTON_WEBELEMENT.size() > 0)
//				IS_ELEMENT_EXIST = true;
//			else
//				IS_ELEMENT_EXIST = false;
//    	}
		return IS_ELEMENT_EXIST;
    }
    
    //Get the page title 
//    public String getLoginTitle(){
//    	return driver.findElement(firstName).getText();
//    }
    
}
