package org.AppiumAutomation.pageObjects.android;

import org.AppiumAutomation.utils.AndroidActions;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogue extends AndroidActions{
	

	AndroidDriver driver;
	
	//creating a constructor of form page to give it knowledge about driver
	public ProductCatalogue(AndroidDriver driver)
	{
		super(driver);//by using super the child class will start using parent class constructor
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	

}
