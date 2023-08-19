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

public class LongPress extends AppiumConfiguration{
	@Test	
	public void LongPress(){
			driver.findElement(AppiumBy.accessibilityId("Views")).click();
			driver.findElement(AppiumBy.accessibilityId("Expandable Lists")).click();
			driver.findElement(AppiumBy.accessibilityId("1. Custom Adapter")).click();
			WebElement PeopleName = driver.findElement(By.xpath("//android.widget.TextView[@text='People Names']"));
			LongPressAction(PeopleName);
			String MenuName = driver.findElement(By.id("android:id/title")).getText();
			Assert.assertEquals(MenuName, "Sample menu");
			Assert.assertTrue(driver.findElement(By.id("android:id/title")).isDisplayed());
		}

	}

