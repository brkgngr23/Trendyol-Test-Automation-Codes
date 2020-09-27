package com.trendyol.test.selenium.trendyol;

import java.io.IOException;

import org.testng.annotations.Test;

import com.trendyol.pages.selenium.trendyol.Trendyol;

public class TrendyolLoginTest extends Trendyol {

@Test
public void Trendyol_Login() throws InterruptedException, IOException {
	startTest().login().UrunArama("bilgisayar")
	.UrunSec()
	.SepetimUrunFiyatKarsilastir()
	.SepetimUrunAdetArtir();
}

}