package com.swaglabs.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.swaglabs.generics.BaseMethod;

public class SwaglabsHomePage extends BaseMethod{
	
	public WebDriver driver;
	@FindBy(xpath="//div[@class='login_logo']")
	private WebElement loginlogo;
	@FindBy(xpath = "//input[@id='user-name']")
	private WebElement username;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy (xpath = "//input[@id='login-button']")
	private WebElement loginBtn;
	@FindBy (xpath = "//div[@class='app_logo']")
	private WebElement applogo;//

	
	
	public SwaglabsHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	public void logoCheck() {
		waitExplicit(driver , loginlogo);
	Assert.assertTrue(loginlogo.isDisplayed());
	}
	
	public void login(String usrname , String pwd) {
		waitExplicit(driver , username);
			username.sendKeys(usrname);     // typing user name
		waitExplicit(driver , password);	
			password.sendKeys(pwd);			// typing password
		waitExplicit(driver , loginBtn);	
			loginBtn.click();				// clicking on Login button
			waitExplicit(driver ,applogo);				
		Assert.assertTrue(applogo.isDisplayed());
	}
	
	

}
