package AppiumAutomation.MobileApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class ScrollPage extends AppiumConfiguration{
	@Test	
	public void Scroll() throws InterruptedException{
			driver.findElement(AppiumBy.accessibilityId("Views")).click();			
			//ScrollTillElement();
			//driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"WebView\"))"));
			//Thread.sleep(2000);
			
			//2nd way using JavaScript
			//boolean canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			//	    "left", 100, "top", 100, "width", 200, "height", 200,
			//	    "direction", "down",
			//	    "percent", 3.0
			//	));
			
			//Alternate way using Do While Loop
			ScrollTillEnd();
			//boolean canScrollMore;
			//do {
			//	canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			//		    "left", 100, "top", 100, "width", 200, "height", 200,
			//		    "direction", "down",
			//		    "percent", 3.0
			//		));
			//} while (canScrollMore);
			

		}

	}

