package com.selenium.action;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumAction {
	public static WebDriver DRIVER = null;	
	public static WebElement ELEMENT  = null;
	public static Select SELECT_ELEMENT = null; //Drop Down
	
	public static String BY_TYPE = null;
	public static String ATTRIBUTE = null;
	public static String BY_SELECTVALUE = null; // Drop Down
	public static String OPTION_VALUE = null;
	public static String VALUE = null;
	
	public static int INDEX_POSITION  = 0;

	public static boolean STATUS;	
	
	/********* Click Action - BEGIN ************/
	public void clickAction(WebDriver driver, String byType, String attribute){
		DRIVER = driver;
		BY_TYPE = byType;
		ATTRIBUTE = attribute;
		
		if(elementExist(DRIVER, BY_TYPE, ATTRIBUTE)){
			ELEMENT.click();
		}
		else{
			System.out.println("element not found");
		}
		
		
	}
	/*----------------- Click Action - END -----------------*/
	
	/********* passValue Action - BEGIN ************/
	public void passValue(WebDriver driver, String byType, String attribute, String value){
		DRIVER = driver;
		BY_TYPE = byType;
		ATTRIBUTE = attribute;
		VALUE = value;
		if(elementExist(DRIVER, BY_TYPE, ATTRIBUTE)){
			ELEMENT.sendKeys(VALUE);
		}
		else{
			System.out.println("input text not found");
		}
	}
	/*----------------- passValue Action - END -----------------*/
	
	/********* Select Action - BEGIN ************/
	public void selectAction(WebDriver driver, String byType, String attribute, String bySelectTYPE, String optionValue){
		DRIVER = driver;
		BY_TYPE = byType;
		ATTRIBUTE = attribute;
		BY_SELECTVALUE = bySelectTYPE;
		OPTION_VALUE = optionValue;
		if(elementExist(DRIVER, BY_TYPE, ATTRIBUTE)){
			SELECT_ELEMENT = new Select(ELEMENT);
			if(BY_SELECTVALUE.equalsIgnoreCase("selectByIndex"))
			{ // if selectByIndex - BEGIN 
				int index = Integer.parseInt(OPTION_VALUE);
				SELECT_ELEMENT.selectByIndex(index);
			} // if selectByIndex - END
			else if(BY_SELECTVALUE.equalsIgnoreCase("selectByVisibleText"))
			{ // else if selectByVisibleText - BEGIN
				SELECT_ELEMENT.selectByVisibleText(OPTION_VALUE);
			} // else if selectByVisibleText - END
			else if(BY_SELECTVALUE.equalsIgnoreCase("selectByValue"))
			{ // else if selectByValue - BEGIN
				SELECT_ELEMENT.selectByValue(OPTION_VALUE);
			} // else if selectByValue - END
		}
		else{
			System.out.println("element not found");
		}
		
		
	}
	/*----------------- Select Action - END -----------------*/
	
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
			} // if byName - END
		} // if elementExist - BEGIN	
		else{ // else elementExist - BEGIN	
			System.out.println("Element not found");
		} // else elementExist - BEGIN	
	}		
	/*------------------------------- radioAction - END -------------------------------*/		

	
	/************** is elementExist? - BEGIN *****************/
	boolean elementExist(WebDriver driver, String byType, String attribute){
		DRIVER = driver;
		BY_TYPE = byType;
		ATTRIBUTE = attribute;
		if(BY_TYPE.equalsIgnoreCase("byXpath"))
		{ // BY_TYPE.equalsIgnoreCase("byXpath") - BEGIN
			if(DRIVER.findElements(By.xpath(ATTRIBUTE)).size() !=0)
			{
				ELEMENT = DRIVER.findElement(By.xpath(ATTRIBUTE));
				STATUS = true;
			}
			else{
				STATUS = false;
			}
		} // BY_TYPE.equalsIgnoreCase("byXpath") - END
		
		else if(BY_TYPE.equalsIgnoreCase("byName"))
		{ // BY_TYPE.equalsIgnoreCase("byXpath") - BEGIN
			if(DRIVER.findElements(By.name(ATTRIBUTE)).size() !=0)
			{
				ELEMENT = DRIVER.findElement(By.name(ATTRIBUTE));
				STATUS = true;
			}
			else{
				STATUS = false;
			}
		} // BY_TYPE.equalsIgnoreCase("byXpath") - END
		
		return STATUS;
	}
	/*----------------- is elementExist? - END -----------------*/
}
