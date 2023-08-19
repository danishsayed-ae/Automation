package AppiumAutomation.MobileApplication;

import javax.lang.model.element.Element;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MiscellaneousActivities extends AppiumConfiguration{
	@Test	
	public void SwipeDemo() throws InterruptedException{
			
			Activity activity = new Activity("io.appium.android.apis", "io.appium.android.apis.preference.PreferenceDependencies");
			driver.startActivity(activity);
			//driver.findElement(AppiumBy.accessibilityId("Preference")).click();
			//driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies")).click();
			driver.findElement(AppiumBy.id("android:id/checkbox")).click();
			//DeviceRotation landScape = new DeviceRotation(0,0,90);
			//driver.rotate(landScape);
			driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
			driver.setClipboardText("Danish");
			driver.findElement(AppiumBy.id("android:id/edit")).sendKeys(driver.getClipboardText());
			driver.pressKey(new KeyEvent(AndroidKey.ENTER));
			driver.findElement(AppiumBy.id("android:id/button1")).click();
			Thread.sleep(3000);
			driver.pressKey(new KeyEvent(AndroidKey.BACK));
			driver.findElement(AppiumBy.accessibilityId("8. Headers")).click();
			Thread.sleep(3000);
			driver.pressKey(new KeyEvent(AndroidKey.HOME));
			
			

		}

	}

