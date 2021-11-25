package com.swaglabs.pom;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;

import com.swaglabs.generics.BaseMethod;

public class SwaglabsInventoryPage extends BaseMethod {
	public WebDriver driver;
	@FindBy(xpath = "//select")
	private WebElement sort;
	@FindBy(xpath = "//div[@class='inventory_item_name']")
	private List<WebElement> items_name;
	@FindBy(xpath = "//div[@class='inventory_item_price']")
	private List<WebElement> items_price;
	@FindBy(xpath = "//*[@class='btn btn_primary btn_small btn_inventory']")
	private List<WebElement> addtocart;
	@FindBy(xpath = "//*[@class='btn btn_secondary btn_small btn_inventory']")
	private List<WebElement> remove;
	@FindBy(xpath = "//*[@class='shopping_cart_badge']")
	private WebElement cartcount;
	@FindBy (xpath = "//*[@id=\"shopping_cart_container\"]/a")
	private WebElement gotoyourcart;
	@FindBy (xpath = "//*[@id=\"header_container\"]/div[2]/span")
	private WebElement yourcart;
	
	
	

	public SwaglabsInventoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public List<String> getItemsByName() { // method to fetch names of items
		List<WebElement> items = items_name; // storing Web elements in List
		List<String> itemsByName = new ArrayList<String>();
		for (WebElement e : items)
			itemsByName.add(e.getText()); // fetching names of items and storing it in list
		return itemsByName;
	}

	public List<Double> getItemsByPrice() { // method to fetch price of items
		List<WebElement> items = items_price; // storing Web elements in List

		List<Double> itemsByPrice = new ArrayList<Double>();
		for (WebElement e : items)
			itemsByPrice.add(Double.parseDouble((e.getText()).substring(1))); // fetching prices of items and storing it
																				// in list
		return itemsByPrice;
	}

	public void sortAlphaAtoZ() { // method to sort alphabetically A to Z
		List<String> items = getItemsByName();
		Collections.sort(items); // sorting items by name
		List<String> itemsInAtoZOrder = items; // storing in list in order AtoZ
		waitExplicit(driver, sort);
		selectvisibelvalue(sort, "az"); // clicking on sort by A to Z
		waitExplicit(driver, items_name);
		List<String> itemsAfterSorting = getItemsByName(); // storing items after performing click operation
		Assert.assertTrue(itemsInAtoZOrder.equals(itemsAfterSorting));
		Reporter.log("Sorted items A to Z" , true);
	}

	public void sortAlphaZtoA() { // method to sort alphabetically Z to A
		List<String> items = getItemsByName();
		Collections.sort(items); // sorting items by name
		Collections.reverse(items); // reversing items by name
		List<String> itemsInZtoAOrder = items; // storing in list in order ZtoA
		waitExplicit(driver, sort);
		selectvisibelvalue(sort, "za"); // clicking on sort by Z to A
		waitExplicit(driver, items_name);
		List<String> itemsAfterSorting = getItemsByName(); // storing items after performing click operation
		Assert.assertTrue(itemsInZtoAOrder.equals(itemsAfterSorting));
		Reporter.log("Sorted items Z to A" , true);
	}

	public void sortPriceHitoLo() { // method to sort by Price High to Low
		List<Double> items = getItemsByPrice();
		Collections.sort(items);
		Collections.reverse(items);
		List<Double> itemsInHitoLoOrder = items; // storing in list in order Hi to Lo
		waitExplicit(driver, sort);
		selectvisibelvalue(sort, "hilo"); // clicking on sort by Hi to lo
		waitExplicit(driver, items_price);
		List<Double> itemsAfterSorting = getItemsByPrice(); // storing items after performing click operation

		Assert.assertTrue(itemsInHitoLoOrder.equals(itemsAfterSorting));
		Reporter.log("Sorted items by price High to Low" , true);
	}

	public void sortPriceLotoHi() { // method to sort by Price Low to High
		List<Double> items = getItemsByPrice();
		Collections.sort(items);
		List<Double> itemsInLotoHiOrder = items; // storing in list in order Lo to Hi to
		waitExplicit(driver, sort);
		selectvisibelvalue(sort, "lohi"); // clicking on sort by Lo to Hi
		waitExplicit(driver, items_price);
		List<Double> itemsAfterSorting = getItemsByPrice(); // storing items after performing click operation
		Assert.assertTrue(itemsInLotoHiOrder.equals(itemsAfterSorting));
		Reporter.log("Sorted items by price Low to High" , true);
	}

	public void addToCart(String item) {
		boolean check = false;
		waitExplicit(driver, addtocart);
		for (WebElement e : addtocart) {
			if (e.getAttribute("id").contains(item)) // checking for item in list
				e.click(); // clicking on respective items addtocart
		}
		waitExplicit(driver, remove);
		for (WebElement e : remove) {
			if (e.getAttribute("id").contains(item)) // checking whether respective product added to cart
				check = true;
		}

		Assert.assertTrue(check && cartcount.isDisplayed()); // checking product added and cart count displayed
		Reporter.log("Product added to cart successfully" , true);
	}
	
	public void goToYourCart() {
		
		waitExplicit(driver,gotoyourcart);
		gotoyourcart.click();                 //clicking on cart to move to your cart section
		waitExplicit(driver,yourcart);
		Assert.assertTrue(yourcart.isDisplayed());
		Reporter.log("On YourCart Page" , true);

		
	}

}
