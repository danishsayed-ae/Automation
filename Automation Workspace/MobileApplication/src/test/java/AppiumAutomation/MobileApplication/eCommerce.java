package AppiumAutomation.MobileApplication;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce extends AppiumConfiguration{
	@Test
	public void FillForm() throws InterruptedException
	{
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bahrain\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Bahrain']")).click();
		//driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Lubna Sayed");
		//driver.hideKeyboard();
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		Thread.sleep(3000);
		
		String toastMessage = driver.findElement(By.xpath("//android.widget.Toast")).getAttribute("name");
		Assert.assertEquals(toastMessage, "Please enter your name");
	}

}
