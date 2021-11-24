package com.swaglabs.pom;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.swaglabs.generics.BaseMethod;

public class SwaglabsInventoryPage extends BaseMethod {
	public WebDriver driver;
	@FindBy(xpath = "//select")
	private WebElement sort;
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private List<WebElement> items_name;
	
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	private List<WebElement> items_price;
	
	public SwaglabsInventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
		
	public List<String> getItemsByName() {
		return webelementsToString(items_name);
	}
	
	public List<Double> getItemsByPrice() {
		List <String>  string = webelementsToString(items_price);
		List<Double> price = new ArrayList<Double>();
		for(String s : string)
			price.add(stringToDouble(s));
		return price;
	}
	
	public void sortAlphaAtoZ() {
		selectvisibelvalue(sort, "az");
	}

	public void sortAlphaZtoA() {
		selectvisibelvalue(sort, "za");
		}
	public void sortPriceHitoLo() {
		selectvisibelvalue(sort, "hilo");
		}
	

}
