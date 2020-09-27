package com.trendyol.pages.selenium.trendyol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.trendyol.commons.selenium.TrendyolCommons;
import com.trendyol.utility.log;

public class PageTrendyolSepetim {
	TrendyolCommons lib;
	public WebDriver driver;
public PageTrendyolSepetim(TrendyolCommons lib) {
	this.lib=lib;
	PageFactory.initElements(this.lib.driver, this);
		
}

@FindBy (how =How.XPATH, using ="//div[contains(@class,'col lg-4')]//ul")
List <WebElement> cntrlUrunDetay;
@FindBy (how =How.XPATH, using ="//dd[@class='total-price']")
WebElement txtSepettekiUrunFiyati;
@FindBy (how =How.XPATH, using ="//button[@class='ty-numeric-counter-button']")
WebElement btnUrunAdetArtir;
@FindBy (how =How.XPATH, using ="//div[@class='pb-counter-container']//button[1]")
WebElement btnUrunAdetAzalt;
@FindBy (how =How.XPATH, using ="//input[@class='counter-content']")
WebElement btnUrunAdet;
@FindBy (how =How.XPATH, using ="//i[@class='i-trash']")
WebElement btnUrunSil;
@FindBy (how =How.XPATH, using ="//button[@class='btn-item btn-remove']")
WebElement btnUrunSilEvet;


public PageTrendyolSepetim SepetimUrunFiyatKarsilastir() throws IOException {
	String sepettekiUrunFiyati=lib.getTextOfElement(txtSepettekiUrunFiyati);
	String urunFiyati;
	FileReader reader= new FileReader(System.getProperty("user.dir") + "/UrunFiyati.txt");
	BufferedReader br = new BufferedReader(reader);
	while ((urunFiyati = br.readLine()) != null) {

		if (urunFiyati.contains(sepettekiUrunFiyati)) {
			
			log.info("Urunun fiyati ile sepetteki fiyat aynidir.");
		}
		
		else {
			log.info("Urunun fiyati ile sepetteki fiyat ayni degil.");
		}
	}
	
	br.close();
	
	return this;
}

public PageTrendyolSepetim SepetimUrunAdetArtir() throws InterruptedException {

	lib.click(btnUrunAdetArtir);
	Thread.sleep(1000);
	
	System.out.println("Value of the button is:- "+ btnUrunAdet.getAttribute("value"));
	String adet= btnUrunAdet.getAttribute("value");
	
	if (adet.contains("2")) {
		
		log.info("Urun Adet Kontrolu Basarili");
	}
	
	else {
		log.info("Urun Adet Kontrolu Basarisiz");
		
	}
	Thread.sleep(1000);
	lib.click(btnUrunAdetAzalt);
	Thread.sleep(1000);
	lib.click(btnUrunSil);
	lib.click(btnUrunSilEvet);
	return this;
}

}