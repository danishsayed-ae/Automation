package AppiumAutomation.MobileApplication;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class BrowserTest extends BrowserAppiumConfiguration{
	@Test
	public void mobileBrowser()
	{
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("Danish Sayed");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
	}

}
