package com.swaglabs.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

	
	
	public SwaglabsHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	
	
	public boolean logoCheck() {
		
	return	loginlogo.isDisplayed();
	}
	
	public void login(String usrname , String pwd) {
		username.sendKeys(usrname);
		password.sendKeys(pwd);
		loginBtn.click();
	}
	
	

}
