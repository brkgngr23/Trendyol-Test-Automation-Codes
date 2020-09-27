package com.trendyol.basepage;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.trendyol.data.GetData;
import com.trendyol.utility.log;

public class SeleniumAbstractPage extends AbstractBase {
	public WebDriver driver;
	
	
	public SeleniumAbstractPage(WebDriver driver) {
		this.driver=driver;
		}
	
	public void navigateTo(String url) {
		try {
			driver.get(GetData.url);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
			log.info("Web application launched");
			
		}
		catch (Exception e) {
			
			log.error("Error ");
		}
		
	}
	
	public void click(WebElement element) {
		
		String elemText="";
		try {
			elemText=element.getText();
			element.click();
			log.info("Click Button :" + elemText);
			}
		
		catch (Exception e){
			
			log.error("Error while clicking element :" + e);
			
		}
	}
	
	public boolean isElementExist (List <WebElement> elem) {
		
		return isElementExist(elem,15);
	}
	
	public boolean isElementExist (List <WebElement> elem,int timeSeconds) {
		
		driver.manage().timeouts().implicitlyWait(timeSeconds, TimeUnit.SECONDS);
		boolean isExist = !elem.isEmpty();
		return isExist;
		
	}
	
	public void sendKeys(WebElement element, String text) {
		sendKeys (element,text,false);
		
	}
	
	public void sendKeys (WebElement element, String text, boolean pressEnter) {
		
		String elemText = null; 
		try {
			
			if(element.isEnabled()) {
				elemText = element.getText();
				element.clear();
				element.sendKeys(text);
				if (pressEnter) {
					wait(1000);
					element.sendKeys(Keys.ENTER);
				}
				
			}
			log.info("Value : " + text + " - SendKeys : " + elemText);
		}
		catch (Exception e) {
			log.error("Error while filling field :" + e);
		}
		
	}

	@SuppressWarnings("finally")
	public String getTextOfElement(WebElement elem) {
		String text =null;
		try {
			text=elem.getText();
		}
		finally {
			return text;
		}
	}
	
}