package com.trendyol.base;

import java.lang.reflect.Method;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

import com.trendyol.utility.log;

public class AbstractTest {
	
	protected ThreadLocal <AbstractTest> lgn =new ThreadLocal<AbstractTest>();
  
    @BeforeSuite
	
	public void StartSuite (ITestContext ctx ) {
	log.startTestCase();
	
	}
	@AfterMethod
	public void getResult(ITestResult result, Method method) {
		
		String testName= method.getName();
		if (result.getStatus()== ITestResult.FAILURE) {
			log.error("Hata");
			
		}
		else if (result.getStatus()== ITestResult.SUCCESS) {
			log.info("Basarili");
		}
		log.info(testName);
	}
}
