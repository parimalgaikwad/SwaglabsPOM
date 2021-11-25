package com.swaglabs.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.swaglabs.generics.BaseMethod;

public class YourCartPage extends BaseMethod {

	public WebDriver driver;
	@FindBy(xpath = "//button[@id=\"checkout\"]")
	private WebElement checkout;
	@FindBy(xpath = "//div[@class='cart_item_label']/a/div")
	private List<WebElement> itemsincartNames;
	@FindBy(xpath = "//div[@class=\"inventory_item_price\"]")
	private List<WebElement> itemsincartPrice;
	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
	private WebElement checkoutinfo;

	public YourCartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}



	public void checkPesenceOfItemInCart(String product) {
		boolean check = false;
		List<String> itemsincart = new ArrayList<String>();
		waitExplicit(driver, itemsincartNames);
		for (WebElement e : itemsincartNames) {
			itemsincart.add(e.getText()); // storing names of items present in cart in list
		}
		System.out.println(itemsincart);
		for (String s : itemsincart) {
			if (s.contains(product)) // checkiing presence of product
				check = true;
		}
		Assert.assertTrue(check);
	}

	public void checkout() {
		waitExplicit(driver, checkout);
		checkout.click();
		waitExplicit(driver, checkoutinfo);
		Assert.assertTrue(checkoutinfo.isDisplayed());
		Reporter.log("Clicked on checkout successfully" , true);

	}

}
