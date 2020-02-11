package com.selenium.util;

public class GetClassName extends SecurityManager {
	public String getClassName(){
		return getClassContext()[1].getName();
	}

}
