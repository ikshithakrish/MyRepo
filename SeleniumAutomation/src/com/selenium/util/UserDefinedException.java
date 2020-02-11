package com.selenium.util;

public class UserDefinedException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	UserDefinedException(String errorMsg){
		System.out.println(errorMsg);
	}
}
