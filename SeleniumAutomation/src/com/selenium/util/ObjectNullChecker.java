package com.selenium.util;

import org.apache.log4j.Logger;

public class ObjectNullChecker extends Exception {
	/**
	 * Created By: Gokula Krishnan Koori
	 */
	private static final long serialVersionUID = 1L;  // bcz extends Exception ???????
	public static boolean NPE_EXCEPTION_FOUND = false;
	public static Logger LOGGER = Logger.getLogger(ObjectNullChecker.class);
	
	ObjectNullChecker(String Msg){
		super(Msg);
	}

	public static boolean checkNPE(Object obj, String Msg){
		try{
			LoggerConfig.logger(); // write log in external file / console
			if(obj==null || obj==""){
				NPE_EXCEPTION_FOUND = true;
				throw new ObjectNullChecker(Msg);
			}
			else{
				NPE_EXCEPTION_FOUND = false;
			}
			
		}
		catch(ObjectNullChecker e){
			LOGGER.error(e.getMessage());
		}
		return NPE_EXCEPTION_FOUND;
	}
}
