package AppiumAutomation.MobileApplication;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumConfiguration {
	
	//Creating object of the class at global level
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public UiAutomator2Options options;
	
	@BeforeClass
	public void StartAppiumService() throws MalformedURLException
	{
		service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\danis\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		options = new UiAutomator2Options();
		options.setChromedriverExecutable("C:\\Users\\danis\\Drivers\\chromedriver.exe");
		options.setDeviceName("Danish Pixel 6");
		//options.setApp("C://eclipse-workspace//MobileApplication//src//test//java//Resources//ApiDemos-debug.apk");
		options.setApp("C:\\eclipse-workspace\\MobileApplication\\src\\test\\java\\Resources\\General-Store.apk");
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	@AfterClass
	public void StopAppiumService()
	{
		driver.quit();
		service.stop();
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
