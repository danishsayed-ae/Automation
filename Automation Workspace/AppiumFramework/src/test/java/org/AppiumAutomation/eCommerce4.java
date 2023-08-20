package org.AppiumAutomation;

import java.sql.Driver;
import java.time.Duration;
import java.util.Calendar;
import java.util.List;
import java.util.Set;

import org.AppiumAutomation.pageObjects.android.FormPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class eCommerce4 extends AppiumConfiguration{
	@Test
	public void FillForm() throws InterruptedException
	{
		//creating object of the "FormPage" class and passing the argument as driver
		FormPage formPage = new FormPage(driver);
		formPage.setCountrySelection("Argentina");
		formPage.setNameField("Lubna Sayed");
		formPage.setGender("Female");
		formPage.submitForm();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='ADD TO CART']")).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		//wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/counterText")), "resource-id", "com.androidsample.generalstore:id/counterText"));
		driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();	
		Thread.sleep(2000);
		wait.until(ExpectedConditions.attributeContains(driver.findElement(By.id("com.androidsample.generalstore:id/toolbar_title")), "text", "Cart"));
		List<WebElement> productPrices = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
		int count = productPrices.size();
		double totalSum = 0;
		for (int i=0; i<count; i++)
		{
			String amountString = productPrices.get(i).getText();
			double price = Double.parseDouble(amountString.substring(1));
			totalSum = totalSum + price;
			
		}
		String displaySum = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
		double formattedSum = CalculateAmount(displaySum);
		Assert.assertEquals(totalSum, formattedSum);
		
		WebElement ele = driver.findElement(By.id("com.androidsample.generalstore:id/termsButton"));
		LongPressAction(ele);
		String TOC = driver.findElement(By.id("com.androidsample.generalstore:id/alertTitle")).getText();
		Assert.assertEquals(TOC, "Terms Of Conditions");
		driver.findElement(By.id("android:id/button1")).click();
		driver.findElement(AppiumBy.className("android.widget.CheckBox")).click();
		driver.findElement(By.id("com.androidsample.generalstore:id/btnProceed")).click();
		Thread.sleep(6000);
		Set <String> context = driver.getContextHandles();
		for (String ContextName: context)
		{
			System.out.println(ContextName);
		}
		driver.context("WEBVIEW_com.androidsample.generalstore");
		driver.findElement(By.name("q")).sendKeys("Danish Sayed");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.context("NATIVE_APP");
//		this a comment written to learn GitHub

		
		
		
	}

}
