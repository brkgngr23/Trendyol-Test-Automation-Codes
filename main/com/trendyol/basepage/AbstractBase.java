package com.trendyol.basepage;

import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;
import com.trendyol.utility.log;

public class AbstractBase {
	
	public void Control(boolean statement, String onTrue, String onFalse) {
		
		if(statement ==true) {
			AbstractBase.LogPASS(onTrue);
		}
		else {
			AbstractBase.LogFAIL(onFalse);
			Assert.assertTrue(false);
		}
	}
	
	public static void LogPASS(String massege) {
		
		log(LogStatus.PASS,massege);
		log.info(massege);
		}
	
	public static void LogFAIL(String massege) {
		
		log(LogStatus.FAIL,massege);
		log.info(massege);
		}

	private static void log(LogStatus pass, String massege) {
		}
}
