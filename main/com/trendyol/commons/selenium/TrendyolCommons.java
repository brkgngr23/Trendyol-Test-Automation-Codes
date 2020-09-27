package com.trendyol.commons.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.trendyol.basepage.SeleniumAbstractPage;

public class TrendyolCommons extends SeleniumAbstractPage {
	
	public TrendyolCommons (WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}
	
}