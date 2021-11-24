package com.swaglabs.generics;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class BaseMethod {
	
	public void selectvisibeltext(WebElement element, String text) {
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}

	public void selectvisibelvalue(WebElement element, String value) {
		Select sel = new Select(element);
		sel.selectByValue(value);
	}

	public void selectvisibleindex(WebElement element, int index) {
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	
	public List<String> webelementsToString(List<WebElement> l)
	{ 	List<String> s = new ArrayList<String>();
		for(WebElement e : l)
			s.add(e.getText());
		return s;
	}
	
	public double stringToDouble(String s){
		
		return Double.parseDouble(s.substring(1));
	}

}
