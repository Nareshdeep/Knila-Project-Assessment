package com.task.webbaseclass;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.task.utility.ConfigurationReader;

public class FlipkartPage extends BaseClass {
	public static WebDriver driver;
	Logger logger = Logger.getLogger("org.openqa.selenium");

	@FindBy(xpath = "//input[@name='q']")
	private WebElement flipkartsearch;

	@FindBy(xpath = "//button[@class='_2iLD__']")
	private WebElement searchbtn;

	@FindBy(xpath = "//div[@id='container']/descendant::a[@target='_blank']")
	private List<WebElement> productbtn;

	@FindBy(xpath = "//button[text()='Add to cart']")
	private WebElement addtocartbtn;

	public FlipkartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void searchProduct(String searchValue) throws Exception {
		System.out.println("Verify whether user can able to search the product");
		logger.log(Level.INFO, "Verify whether user can able to search the product");
		try {
			String url = ConfigurationReader.getInstance().getProperty("url");
			get(url);
			userInput(flipkartsearch, searchValue);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			eclick(searchbtn);

		} catch (Exception e) {
			logger.log(Level.INFO, "Unable to search the product ");
		}

	}

	public void addToCart() throws InterruptedException {

		System.out.println("Verify whether user can able to add the product to the cart");
		logger.log(Level.INFO, "Verify whether user can able to add the product to the cart");

		String PTab = driver.getWindowHandle();
		System.out.println(PTab);
		eclick(productbtn.get(0));
		for (String CTab : driver.getWindowHandles()) {
			if(!CTab.equals(PTab)) {
			driver.switchTo().window(CTab);
			}
		}
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		eclick(addtocartbtn);
		
		// WebDriverWait w=new WebDriverWait(driver, i);
		// w.until(ExpectedConditions.visibilityOfElementLocated(By.name("")));

		// } catch (Exception e) {
		logger.log(Level.INFO, "unable to add to cart");

	}
}