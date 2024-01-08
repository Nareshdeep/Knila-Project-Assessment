package com.task.webbaseclass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.lang.model.element.Element;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.task.utility.MyTestListener;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;

	public static WebDriver broswerlaunch(String browser) throws Throwable {

		try {
			if (browser.equalsIgnoreCase("chrome")) {
				WebDriverManager.chromedriver().setup();
				ChromeOptions options = new ChromeOptions();
				options.addArguments("incognito");
				driver = new ChromeDriver(options);

			} else if (browser.equalsIgnoreCase("gecko")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if (browser.equalsIgnoreCase("edge")) {
				WebDriverManager.edgedriver().setup();
				driver = new EdgeDriver();
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("invalid browser");
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public static void get(String url) {
		driver.get(url);
	}

	public static void userInput(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void eclick(WebElement element) {
		element.click();

	}

	public static void multiple(WebElement element, String value, String options) throws Throwable {
		Select s = new Select(element);
		try {
			if (options.equalsIgnoreCase("by index")) {
				// string integer convert
				int p = Integer.parseInt(value);
				s.selectByIndex(p);

			} else if (options.equalsIgnoreCase("by value")) {
				s.selectByValue(value);
			} else if (options.equalsIgnoreCase("by visibletext")) {
				s.selectByVisibleText(value);
			} else {
				throw new Exception();

			}
		} catch (Exception e) {
			System.out.println("invalid select");

		}

	}

	public static String printValue(WebElement element) {
		String text = element.getText();
		return text;

	}

	public static void action(WebElement element, String options) throws Throwable {
		Actions a = new Actions(driver);
		try {
			if (options.equalsIgnoreCase("click")) {
				a.click(element).perform();
			} else if (options.equalsIgnoreCase("context click")) {
				a.contextClick(element).perform();
			} else if (options.equalsIgnoreCase("double click")) {
				a.doubleClick(element).perform();
			} else if (options.equalsIgnoreCase("move to element")) {
				a.moveToElement(element).perform();
				a.click().perform();
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			System.out.println("invalid mouse action");
		}
	}

	public static void display(WebElement element) {
		boolean d = element.isDisplayed();
		System.out.println(d);
	}
}
