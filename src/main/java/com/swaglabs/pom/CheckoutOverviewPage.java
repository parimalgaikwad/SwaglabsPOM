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

public class CheckoutOverviewPage extends BaseMethod{

	public WebDriver driver;
	@FindBy(xpath = "//div[@class='cart_item_label']/a/div")
	private List<WebElement> itemsincartNames;
	@FindBy(xpath = "//div[@class=\"inventory_item_price\"]")
	private List<WebElement> itemsincartPrice;
	@FindBy(xpath = "//div[@class='summary_subtotal_label']")
	private WebElement subtotal;
	@FindBy (xpath="//button[@id='finish']")
	private WebElement finish;

	public CheckoutOverviewPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void verifySubtotal() {

		double cartTotal = 0;
		List<Double> price = new ArrayList<Double>();
		for (WebElement e : itemsincartPrice) {
			price.add(Double.parseDouble(e.getText().substring(1)));       // fetching price from text
		}
		for (Double d : price) {
			cartTotal = cartTotal + d;                                   // summing all prices
		}
		Reporter.log("Total sum of items :"+cartTotal,true);
		String s = subtotal.getText();										//storing subtotal in string
		double total = Double.parseDouble(s.substring((s.indexOf("$") + 1)));  //fetching subtotal from string
		Reporter.log("subTotal from cart :"+total , true);

		Assert.assertEquals(total, cartTotal);
		Reporter.log("SubTotal and sum of price of items mathced" , true);
	}

	
	public void verifyFinish() {
		
		waitExplicit(driver , finish);	
			finish.click();
		
		
	}
}
