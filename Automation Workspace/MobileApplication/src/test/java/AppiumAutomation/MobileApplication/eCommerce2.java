package AppiumAutomation.MobileApplication;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;

public class eCommerce2 extends AppiumConfiguration{
	@Test
	public void FillForm() throws InterruptedException
	{
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Bahrain\"))"));
		driver.findElement(By.xpath("//android.widget.TextView[@text='Bahrain']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField")).sendKeys("Lubna Sayed");
		driver.findElement(By.xpath("//android.widget.RadioButton[@text='Female']")).click();
		driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop")).click();
		driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Air Jordan 9 Retro\"))"));
		
		//this is to dynamically select the product and then add to cart
		int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
		
		for (int a=0;a<count;a++)
		{
			String product = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(a).getText();
			
			if(product.equalsIgnoreCase("Air Jordan 9 Retro"))
			{
				driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(a).click();
			}
		}
		Thread.sleep(1000);
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		String cartProductName = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
		Assert.assertEquals(cartProductName, "Air Jordan 9 Retro");
		
		
		
		
		
		
		
		
		
		
	}

}
