package com.swaglabs.test;

import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.swaglabs.generics.AutoConstant;
import com.swaglabs.generics.BaseOpenBrowser;
import com.swaglabs.pom.CheckoutOverviewPage;
import com.swaglabs.pom.CheckoutYourInfoPage;
import com.swaglabs.pom.SwaglabsHomePage;
import com.swaglabs.pom.SwaglabsInventoryPage;
import com.swaglabs.pom.YourCartPage;

@Listeners(com.swaglabs.generics.Listeners.class)

public class SwaglabsTest extends BaseOpenBrowser implements AutoConstant {
	@Test
	public void login() {
		SwaglabsHomePage hp = new SwaglabsHomePage(driver);
		hp.logoCheck(); // checks for presence of logo
		hp.login(std_user, password); // checks for login with creds

	}

	@Test
	public void inventory() throws Exception {
		SwaglabsHomePage hp = new SwaglabsHomePage(driver);
		hp.login(std_user, password); // checks for login with creds
		SwaglabsInventoryPage ip = new SwaglabsInventoryPage(driver);
		
		  ip.sortAlphaZtoA(); // checks sorting Z to A 
		  Thread.sleep(8000);
		  
		  ip.sortPriceHitoLo();  // checks sorting High to low 
		  Thread.sleep(8000);
		  ip.sortAlphaAtoZ(); // checks sorting A to Z 
		  Thread.sleep(8000);
		  ip.sortPriceLotoHi(); // checks sorting low to high 
		  Thread.sleep(8000);
		 

		ip.addToCart("jacket");
		Thread.sleep(3000);
		ip.addToCart("backpack");
		Thread.sleep(3000);
		ip.goToYourCart();
		Thread.sleep(5000);
	}

	@Test
	public void yourCart() throws Exception {

		SwaglabsHomePage hp = new SwaglabsHomePage(driver);
		SwaglabsInventoryPage ip = new SwaglabsInventoryPage(driver);
		YourCartPage yp = new YourCartPage(driver);
		hp.login(std_user, password); // login with creds
		ip.addToCart("jacket");
		ip.addToCart("backpack");
		ip.goToYourCart();
		yp.checkPesenceOfItemInCart("Backpack");
		yp.checkout();
	}

	@Test
	public void checkoutInfo() throws Exception {

		SwaglabsHomePage hp = new SwaglabsHomePage(driver);
		SwaglabsInventoryPage ip = new SwaglabsInventoryPage(driver);
		YourCartPage yp = new YourCartPage(driver);
		CheckoutYourInfoPage cp = new CheckoutYourInfoPage(driver);
		hp.login(std_user, password); // login with creds
		ip.addToCart("jacket");
		ip.goToYourCart();
		yp.checkout();
		cp.checkoutInfo();
	}
	@Test
	public void CheckoutOverview() throws Exception {

		SwaglabsHomePage hp = new SwaglabsHomePage(driver);
		SwaglabsInventoryPage ip = new SwaglabsInventoryPage(driver);
		YourCartPage yp = new YourCartPage(driver);
		CheckoutYourInfoPage cp = new CheckoutYourInfoPage(driver);
		CheckoutOverviewPage op = new CheckoutOverviewPage(driver);
		hp.login(std_user, password); // login with creds
		ip.addToCart("jacket");				// adding jacket to cart

		ip.addToCart("backpack");			// adding backpack to cart
		ip.addToCart("light");				
		ip.goToYourCart();
		yp.checkout();
		cp.checkoutInfo();					
		op.verifySubtotal();			//verifying total price of items in cart
	}

}
