package com.learning.main;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomReport {
	public static String ACTUAL_PATH = "D:\\My Assignments\\Selenium_UI_AUTOMATION\\Reports";
	public static String REPORT_PATH = null;
	public static boolean IS_FOLDER_CREATED = false;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		folderCreation();
		fileCreation();
	}
	
	static boolean folderCreation(){		
		DateFormat df = new SimpleDateFormat("MMM dd,yyyy (HH.mm.ss)");
		Date dateobj = new Date();				
		String folderName = "\\Report_"+df.format(dateobj);
		System.out.println(folderName);	
		REPORT_PATH = ACTUAL_PATH+folderName;
		// mkdir - create single dir and  mkdirs - create sub directories  both return boolean values
		if(new File(REPORT_PATH).mkdir()){  
		new File(REPORT_PATH + "\\others\\screenshot").mkdirs();  
		new File(REPORT_PATH + "\\others\\logs").mkdirs();
		IS_FOLDER_CREATED = true;
		}
		else{
			System.out.println("Unable to create folder");		
			IS_FOLDER_CREATED = false;
		}
		return IS_FOLDER_CREATED;
	}
	
	static void fileCreation(){
		
	}

}
