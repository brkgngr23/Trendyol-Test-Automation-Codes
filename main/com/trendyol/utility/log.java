package com.trendyol.utility;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class log  {
public static final Logger Log = LoggerFactory.getLogger(log.class);
final static Logger logger = LoggerFactory.getLogger(log.class);

public static void startTestCase() {
	 BasicConfigurator.configure(); 
	
	Log.info("*******************************************************************");
	
	Log.info("*******************************************************************");
	
	Log.info("$$$$$$$$$$$$$$$$        START    TEST         $$$$$$$$$$$$$$$$$$$$$");
	
	Log.info("*******************************************************************");
	
	Log.info("*******************************************************************");
	
}

public static void endTestCase(String sTestCaseName) {
	
	Log.info("*******************************************************************");
	
	Log.info("*******************************************************************");
	
	Log.info("XXXXXXXXXXXXXXXXXX   "   +sTestCaseName +     "XXXXXXXXXXXXXXXXXXXX");
	
	Log.info("XXXXXXXXXXXXXXXXXX   "   +"E---N---D" +       "XXXXXXXXXXXXXXXXXXXX");
	
	Log.info("*******************************************************************");
	
	Log.info("*******************************************************************");
	

}

public static void info (String message) {
	Log.info(message);
}

public static void error (String message) {
	Log.error(message);
}
	
}
