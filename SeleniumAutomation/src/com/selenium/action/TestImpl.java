package com.selenium.action;
import java.util.List;							

import org.openqa.selenium.By;							
import org.openqa.selenium.WebDriver;							
import org.openqa.selenium.WebElement;							
import org.openqa.selenium.support.ui.Select;							
							
public class TestImpl {							
	public static WebDriver DRIVER = null;						
	public static String BY_TYPE;						
	public static String ATTRIBUTE;						
	public static String VALUE;						
	public static String SELECT_BY;						
	public static String INDEX_VALUE;						
							
	public static int INDEX_POSITION;						
							
	public static  List<WebElement> OPTIONS;						
							
	public static boolean STATUS;						
							
	public static WebElement ELEMENT;						
							
	public static Select SELECT_ELEMENT;						
							
							
	/*************************** submitAction - BEGIN *******************/						
	public void submitAction(WebDriver driver, String byType, String attribute){						
		DRIVER = driver;					
		BY_TYPE = byType;					
		ATTRIBUTE = attribute;					
		if(elementExist(DRIVER, BY_TYPE, ATTRIBUTE)){					
			ELEMENT.submit();				
		}					
		else{					
			System.out.println("Element not found");				
		}					
	}						
	/*------------------------------- submitAction - END -------------------------------*/						
							
							
	/******************** passValueActionn - BEGIN ********************/						
	// Param - findBy, attribute, value						
	public void passValueAction(WebDriver driver, String byType, String attribute, String value){						
		DRIVER = driver;					
		BY_TYPE = byType;					
		ATTRIBUTE = attribute;					
		VALUE = value;					
		if(elementExist(DRIVER, BY_TYPE, ATTRIBUTE)){					
			ELEMENT.sendKeys(value);				
		}					
		else{					
			System.out.println("Element not found");				
		}					
	}						
	/*------------------------------- passValueAction - END -------------------------------*/						
							
	/********************* radioAction - BEGIN *********************/						
	public void radioAction(WebDriver driver, String byType, String attribute, int index){						
		DRIVER = driver;					
		BY_TYPE = byType;					
		ATTRIBUTE = attribute;					
		INDEX_POSITION = index;					
		if(elementExist(DRIVER, BY_TYPE, ATTRIBUTE)){ // if elementExist - BEGIN 					
			if(BY_TYPE.equalsIgnoreCase(BY_TYPE)){ // if byName - BEGIN				
		    	List<WebElement> options = DRIVER.findElements(By.name(ATTRIBUTE));				
			    options.get(INDEX_POSITION).click();
			    System.out.println(options.get(INDEX_POSITION).isSelected());
			} // if byName - END		    		
		} // if elementExist - BEGIN					
		else{ // else elementExist - BEGIN					
			System.out.println("Element not found");				
		} // else elementExist - BEGIN					
	}						
	/*------------------------------- radioAction - END -------------------------------*/						
							
	/*************************** clickAction - BEGIN *******************/						
	public void clickAction(WebDriver driver, String byType, String attribute){						
		DRIVER = driver;					
		BY_TYPE = byType;					
		ATTRIBUTE = attribute;					
		if(elementExist(DRIVER, BY_TYPE, ATTRIBUTE)){					
			ELEMENT.click();				
		}					
		else{					
			System.out.println("Element not found");				
		}					
	}						
	/*------------------------------- clickAction - END -------------------------------*/						
							
	/*************************** selectAction - BEGIN *******************/						
	public void selectAction(WebDriver driver, String byType, String attribute, String selectBy, String indexValue){						
		System.out.println("Entetr select action");					
		//(IE_DRIVER, "name", "passCount", "selectByIndex", "2")					
		DRIVER = driver;					
		BY_TYPE = byType;					
		ATTRIBUTE = attribute;					
		SELECT_BY = selectBy;					
		INDEX_VALUE = indexValue;					
		if(elementExist(DRIVER, BY_TYPE, ATTRIBUTE))					
		{ // if Select Action: elementExist() - BEGIN					
			SELECT_ELEMENT = new Select(ELEMENT);				
			if(SELECT_BY.equalsIgnoreCase("selectByIndex"))				
			{ //if  selectBy.equalsIgnoreCase - BEGIN				
				System.out.println("selectByIndex");			
				int index = Integer.parseInt(INDEX_VALUE);			
				SELECT_ELEMENT.selectByIndex(index);			
			} //if  selectBy.equalsIgnoreCase - END 				
			else if(SELECT_BY.equalsIgnoreCase("selectByVisibleText"))				
			{ // else if  selectBy.equalsIgnoreCase("selectByVisibleText") - BEGIN				
					SELECT_ELEMENT.selectByVisibleText(INDEX_VALUE);		    
			} // else if selectBy.equalsIgnoreCase("selectByVisibleText") - END				
			else if(SELECT_BY.equalsIgnoreCase("selectByValue"))				
			{ // else if  selectBy.equalsIgnoreCase("selectByValue") - BEGIN				
					SELECT_ELEMENT.selectByValue(INDEX_VALUE);		
			} // else if selectBy.equalsIgnoreCase("selectByValue") - END				
		} // if Select Action: elementExist() - END					
		else					
		{ // else Select Action: elementExist() - BEGIN					
			System.out.println("Element not found");				
		} // else Select Action: elementExist() - BEGIN					
	}						
	/*------------------------------- selectAction - END -------------------------------*/						
							
	/*************************** element Exist? - BEGIN **************************/						
	 boolean elementExist(WebDriver driver, String byType, String attribute){						
		 					
		 DRIVER = driver;					
		 BY_TYPE = byType;					
		 ATTRIBUTE = attribute;					
		if(BY_TYPE.equalsIgnoreCase("byxpath")){ // if xpath - BEGIN					
			if(DRIVER.findElements(By.xpath(ATTRIBUTE)).size() != 0){				
				ELEMENT=DRIVER.findElement(By.xpath(ATTRIBUTE));			
				STATUS=true;			
			}				
			else{				
				STATUS=false;			
			}				
		} // if xpath - END					
		else if(BY_TYPE.equalsIgnoreCase("byName")){ // else if xpath - BEGIN					
							
			if(DRIVER.findElements(By.name(ATTRIBUTE)).size() != 0){				
				ELEMENT = DRIVER.findElement(By.name(ATTRIBUTE));			
				STATUS=true;			
			}				
			else{				
				System.out.println("element not found-----");			
				STATUS=false;			
			}				
		}					
		return STATUS; 					
	} // elementExist(WebDriver driver, String byType, String attribute) - END						
	 /*-------------------------------  element Exist? - END -------------------------------*/						
							
	 						
} // class end 							
