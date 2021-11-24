package com.swaglabs.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.swaglabs.generics.AutoConstant;
import com.swaglabs.generics.BaseOpenBrowser;
import com.swaglabs.pom.SwaglabsHomePage;
import com.swaglabs.pom.SwaglabsInventoryPage;
@Listeners(com.swaglabs.generics.Listeners.class)

public class SwaglabsTest extends BaseOpenBrowser implements AutoConstant {
	@Test
	public void doLogoCheck() {
		SwaglabsHomePage hp = new SwaglabsHomePage(driver);
		Assert.assertTrue(hp.logoCheck());
	}

	@Test
	public void doLoginWithRightCreds() {
		SwaglabsHomePage hp = new SwaglabsHomePage(driver);
		hp.login(std_user, password);
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

	}

	@Test
	public void doLoginWithWrongCreds() {
		SwaglabsHomePage hp = new SwaglabsHomePage(driver);
		hp.login(locked_user, password);
		Assert.assertEquals("https://www.saucedemo.com/inventory.html", driver.getCurrentUrl());

	}
	
	@Test
	public void doSortAlphaZtoA() throws Exception {
		SwaglabsInventoryPage ip = new SwaglabsInventoryPage(driver);
		SwaglabsHomePage hp = new SwaglabsHomePage(driver);
		hp.login(std_user, password);
		ip.sortAlphaZtoA();
		Assert.assertTrue(sortedZtoA.equals(ip.getItemsByName()));
	}
	@Test
	public void doSortPriceHitoLo() throws Exception {
		SwaglabsInventoryPage ip = new SwaglabsInventoryPage(driver);
		SwaglabsHomePage hp = new SwaglabsHomePage(driver);
		hp.login(std_user, password);
		ip.sortPriceHitoLo();
		Assert.assertTrue(sortedHitoLo.equals(ip.getItemsByPrice()));
		
	}
}
