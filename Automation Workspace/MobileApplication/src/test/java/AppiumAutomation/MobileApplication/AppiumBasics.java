package AppiumAutomation.MobileApplication;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumBasics extends AppiumConfiguration{
	@Test	
	public void WifiSettings() throws MalformedURLException
		{
			
			//Type of locators xpath, id, accessibility id, classname, androidUIautomator
			driver.findElement(AppiumBy.accessibilityId("Preference")).click();
			driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
			driver.findElement(AppiumBy.id("android:id/checkbox")).click();
			driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
			String alertTitle = driver.findElement(By.id("android:id/alertTitle")).getText();
			Assert.assertEquals(alertTitle, "WiFi settings");
			driver.findElement(AppiumBy.id("android:id/edit")).sendKeys("123456");
			driver.findElement(AppiumBy.id("android:id/button1")).click();
			
		}

	}

