package com.trendyol.pages.selenium.trendyol;

import java.util.List;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.trendyol.commons.selenium.TrendyolCommons;

public class PageTrendyolAnaSayfa {
	TrendyolCommons lib;
	
public PageTrendyolAnaSayfa(TrendyolCommons lib) {
	this.lib=lib;
	PageFactory.initElements(this.lib.driver, this);
		
}

@FindBy (how =How.XPATH, using ="//input[@placeholder='Aradığınız ürün, kategori veya markayı yazınız']")
WebElement txtUrunAra;
@FindBy (how =How.XPATH, using ="//a[1]//span[1]//b[1]")
WebElement btnUrunAra;
@FindBy (how =How.XPATH, using ="//span[@id='shoppingCart']")
WebElement btnSepetim;

public PageTrendyolUrunler UrunArama(String UrunAdi) throws InterruptedException {
	Thread.sleep(2000);
	lib.sendKeys(txtUrunAra,UrunAdi);
	lib.click(btnUrunAra);
	return new PageTrendyolUrunler(lib);
}

public PageTrendyolSepetim Sepetim() {
	lib.click(btnSepetim);
	return new PageTrendyolSepetim(lib);
}
}

