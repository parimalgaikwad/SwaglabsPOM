package com.swaglabs.test;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.swaglabs.generics.AutoConstant;
import com.swaglabs.generics.BaseOpenBrowser;
import com.swaglabs.pom.SwaglabsHomePage;
import com.swaglabs.pom.SwaglabsInventoryPage;
@Listeners(com.swaglabs.generics.Listeners.class)

public class SwaglabsTest extends BaseOpenBrowser implements AutoConstant {
	@Test
	public void login() {
		SwaglabsHomePage hp = new SwaglabsHomePage(driver);
		hp.logoCheck();   				// checks for presence of logo
		hp.login(std_user, password);    // checks for login with creds
		
		
	}

	@Test
	public void inventory() throws Exception {
		SwaglabsHomePage hp = new SwaglabsHomePage(driver);
		hp.login(std_user, password);    // checks for login with creds
		SwaglabsInventoryPage ip = new SwaglabsInventoryPage(driver);
		ip.sortAlphaZtoA();                     // checks sorting Z to A
		Thread.sleep(8000);
		ip.sortPriceHitoLo();					// checks sorting High to low
		Thread.sleep(8000);
		ip.sortAlphaAtoZ();						// checks sorting A to Z	
		Thread.sleep(8000);
		ip.sortPriceLotoHi();					// checks sorting low to high	
		Thread.sleep(8000);
	}
}
