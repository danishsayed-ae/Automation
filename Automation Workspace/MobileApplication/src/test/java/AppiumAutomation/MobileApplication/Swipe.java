package AppiumAutomation.MobileApplication;

import javax.lang.model.element.Element;

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

public class Swipe extends AppiumConfiguration{
	@Test	
	public void SwipeDemo() throws InterruptedException{
			driver.findElement(AppiumBy.accessibilityId("Views")).click();			
			driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
			driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
			WebElement FirstImage = driver.findElement(By.xpath("//android.widget.ImageView[1]"));
			Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"), "true");
			//((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			//	    "elementId", ((RemoteWebElement)FirstImage).getId(),
			//	    "direction", "left",
			//	    "percent", 0.75
			//	));
			
			SwipeAction(FirstImage, "left");
			Assert.assertEquals(driver.findElement(By.xpath("//android.widget.ImageView[1]")).getAttribute("focusable"), "false");
			

		}

	}

