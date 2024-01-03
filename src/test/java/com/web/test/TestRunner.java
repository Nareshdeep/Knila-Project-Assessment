package com.web.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.task.utility.ConfigurationReader;
import com.task.utility.MyTestListener;
import com.task.webbaseclass.BaseClass;
import com.task.webbaseclass.OpenMRSPage;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestRunner {

	public static WebDriver driver;

	@BeforeTest(alwaysRun = true)
	public void setUp() throws Throwable {
		String property = ConfigurationReader.getInstance().getProperty("browser");
		driver = BaseClass.broswerlaunch(property);
	}
	@Test
	public  void tc001() throws Throwable {
		OpenMRSPage testPlayer = new OpenMRSPage(driver);
		try {
	
		testPlayer.signInForData();
		testPlayer.registerPatient();
		testPlayer.calculateAge();
		testPlayer.patientDashboardPage();
		testPlayer.Attachment();
		testPlayer.patientEndVisit();
		testPlayer.capturePatientVitals();
		testPlayer.mergePatientVisits();
		testPlayer.deletePatient();
		}catch (Exception e) {
			testPlayer.screenshot();
		}finally {
			
		}
		
	}

}
