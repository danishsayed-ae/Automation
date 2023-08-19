package org.AppiumAutomation.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AndroidActions {
	
	AndroidDriver driver;
	
	//creating a constructor
	public AndroidActions (AndroidDriver driver)
	{
		this.driver=driver;
	}
	
	public void LongPressAction(WebElement PeopleName)
	{
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", ImmutableMap.of("elementId",((RemoteWebElement)PeopleName).getId(),"duration",3000));
	}
	
	public void ScrollTillElement()
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
	}
	
	public void ScrollTillEnd()
	{
		boolean canScrollMore;
		do {
			canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
				    "left", 100, "top", 100, "width", 200, "height", 200,
				    "direction", "down",
				    "percent", 3.0
				));
		} while (canScrollMore);
	}
	
	public void scrollToText(String text)
	{
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\""+text+"\"))"));
	}
	
	public void SwipeAction(WebElement Element,String direction)
	{
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement)Element).getId(),
			    "direction", direction,
			    "percent", 0.75
			));
	}
	
	public double CalculateAmount(String amount)
	{
		double price = Double.parseDouble(amount.substring(1));
		return price;
	}

}
