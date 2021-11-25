package com.swaglabs.pom;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.swaglabs.generics.BaseMethod;

public class CheckoutYourInfoPage extends BaseMethod {

	public WebDriver driver;
	@FindBy(xpath = "//input[@id=\"first-name\"]")
	private WebElement firstname;
	@FindBy(xpath = "//input[@id=\"last-name\"]")
	private WebElement lastname;
	@FindBy(xpath = "//input[@id=\"postal-code\"]")
	private WebElement postalcode;
	@FindBy(xpath = "//input[@id=\"continue\"]")
	private WebElement cont;
	@FindBy(xpath = "//*[@id=\"header_container\"]/div[2]/span")
	private WebElement checkoutoverview;

	public CheckoutYourInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public static String getRandomString(int i) {   // method to generate random postalcode
		int j =0;
		String randomstring = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		String string = "";
		Random rnd = new Random();
		while (j < i) { // length of the random string.
			int index = (int) (rnd.nextFloat() * randomstring.length());
			string= string+(randomstring.charAt(index));
			j++;
		}
		return string;

	}


	public static String getRandomNumber(int i) {   // method to generate random postalcode
		int j =0;
		String randomstring = "1234567890";
		String string = "";
		Random rnd = new Random();
		while (j < i) { // length of the random string.
			int index = (int) (rnd.nextFloat() * randomstring.length());
			string= string+(randomstring.charAt(index));
			j++;
		}
		return string;

	}


	public void checkoutInfo() throws Exception {
		waitExplicit(driver, firstname);
		firstname.sendKeys(getRandomString(5));
		Reporter.log("Entered firstname" , true);

		Thread.sleep(5000);
		waitExplicit(driver, lastname);
		lastname.sendKeys(getRandomString(5));
		Reporter.log("Entered Lastname" , true);
		Thread.sleep(5000);

		waitExplicit(driver, postalcode);
		postalcode.sendKeys(getRandomNumber(6));
		Reporter.log("Entered Postalcode" , true);
		Thread.sleep(5000);

		waitExplicit(driver, cont);
		cont.click();
		waitExplicit(driver, checkoutoverview);
		Assert.assertTrue(checkoutoverview.isDisplayed());
		Reporter.log("Entered on Checkoutoverview page succesfully" , true);
	}

}
