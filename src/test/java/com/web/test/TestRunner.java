package com.web.test;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.task.utility.ConfigurationReader;
import com.task.webbaseclass.BaseClass;
import com.task.webbaseclass.FlipkartPage;

public class TestRunner {

	public static WebDriver driver;

	@BeforeTest(alwaysRun = true)
	public void setUp() throws Throwable {
		String property = ConfigurationReader.getInstance().getProperty("browser");
		driver = BaseClass.broswerlaunch(property);
	}

	@Test
	public void tc001() throws Throwable {
		FlipkartPage testPlayer = new FlipkartPage(driver);

		try {
			testPlayer.searchProduct("poco x5 pro");
			testPlayer.addToCart();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			driver.quit();
		}

	}

}
