package com.task.webbaseclass;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.task.utility.ConfigurationReader;
import com.task.utility.WebUtilityClass;

public class OpenMRSPage extends BaseClass {
	public static WebDriver driver;
	Logger logger = Logger.getLogger("org.openqa.selenium");

	@FindBy(xpath = "//div[@class='gender-age col-auto']/span[2]")
	WebElement ageValue;

	@FindBy(xpath = "//h3[text()='General Actions']/parent::ul/child::li")
	List<WebElement> startVisit;

	@FindBy(xpath = "//div[@id='quick-visit-creation-dialog']/descendant::button[@class='confirm right']")
	WebElement visitConfirmBtn;

	@FindBy(xpath = "//ul[@id='breadcrumbs']/li[2]/a")
	WebElement nameLink;

	@FindBy(xpath = "//input[@type='checkbox']")
	List<WebElement> checkBox;

	@FindBy(id = "mergeVisitsBtn")
	WebElement mergeBtn;

	@FindBy(xpath = "//input[@class='cancel']")
	WebElement cancelBtn;

	@FindBy(xpath = "//table[@class=' table-condensed']/tbody/tr/td[@class='day disabled']")
	WebElement calBtn;

	@FindBy(xpath = "(//div[@class='dialog-content form']/button[text()='Cancel'])[2]")
	WebElement calCancelBtn;

	@FindBy(xpath = "//div[@class='float-sm-right']/span")
	WebElement patientId;

	@FindBy(id = "delete-reason")
	WebElement deleteReason;

	@FindBy(xpath = "//input[@id='delete-reason']/parent::div//button[@class='confirm right']")
	WebElement deleteConfirmBtn;

	@FindBy(xpath = "//input[@id='patient-search']")
	WebElement PatientSearch;

	@FindBy(xpath = "//td[@class='dataTables_empty']")
	WebElement patientSearchAfterDelete;

	@FindBy(id = "username")
	WebElement username;

	@FindBy(id = "loginButton")
	WebElement loginBtn;

	@FindBy(id = "password")
	WebElement password;

	@FindBy(xpath = "//ul[@id='sessionLocation']/li")
	List<WebElement> locations;

	@FindBy(xpath = "//a[contains(@id,'registerPatient')]")
	WebElement patient;

	@FindBy(name = "givenName")
	WebElement giveName;

	@FindBy(id = "next-button")
	WebElement nextBtn;

	@FindBy(xpath = "//option[text()='Male']")
	WebElement genderMaleBtn;

	@FindBy(name = "birthdateDay")
	WebElement birthDate;

	@FindBy(name = "birthdateMonth")
	WebElement birthMonth;

	@FindBy(name = "birthdateYear")
	WebElement birthyear;

	@FindBy(id = "address1")
	WebElement address;

	@FindBy(name = "phoneNumber")
	WebElement phoneNumber;

	@FindBy(xpath = "//input[@value='Confirm']")
	WebElement confirmBtn;

	@FindBy(id = "start-visit-with-visittype-confirm")
	WebElement startVistConfirmbtn;

	@FindBy(xpath = "//input[@name='cityVillage']")
	WebElement city;

	@FindBy(xpath = "//input[@name='stateProvince']")
	WebElement state;
	@FindBy(xpath = "//input[@name='country']")
	WebElement country;
	@FindBy(xpath = "//input[@name='postalCode']")
	WebElement postalCode;

	@FindBy(name = "familyName")
	WebElement familyName;

	@FindBy(xpath = "//i[@class='icon-vitals']/parent::a")
	WebElement captureVitals;

	@FindBy(xpath = "//span[@id='height']/input")
	WebElement height;

	@FindBy(xpath = "//span[@id='weight']/input")
	WebElement weight;

	@FindBy(xpath = "//span[@id='calculated-bmi']")
	WebElement bmi;

	@FindBy(id = "save-form")
	WebElement saveForm;

	@FindBy(xpath = "//div[@id='dataCanvas']//p[1]")
	WebElement heightText;

	@FindBy(xpath = "//div[@id='dataCanvas']//p[2]")
	WebElement weightText;

	@FindBy(xpath = "//div[@id='dataCanvas']//p[3]")
	WebElement bmiText;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement submitBtn;

	@FindBy(xpath = "//a[text()=' End Visit']")
	WebElement endVist;

	@FindBy(xpath = "//div[@id='end-visit-dialog']/descendant::button[@class='confirm right']")
	WebElement endVistConfirmBtn;

	@FindBy(xpath = "//div[@class='dz-default dz-message ng-binding']")
	WebElement file;

	@FindBy(xpath = "//h3[text()='Caption']/following-sibling::textarea")
	WebElement caption;

	@FindBy(xpath = "//button[@class='confirm ng-binding']")
	WebElement uploadFile;

	@FindBy(xpath = "//ul[@id='breadcrumbs']/li[2]/a")
	WebElement link;

	@FindBy(xpath = "//h3[text()='Recent Visits']/ancestor::div[1]/following-sibling::div//li")
	WebElement recentVisit;

	@FindBy(xpath = "(//h3[text()='Current Visit Actions']/parent::ul/child::li[1])[2]")
	WebElement endVistUpload;

	@FindBy(xpath = "//div[@id='end-visit-dialog']/descendant::button[@class='confirm right']")
	WebElement endVistConfirmBtnUpload;

	@FindBy(xpath = "//div[@class='visit-actions active-visit']/descendant::a[contains(@id,'attachments')]")
	WebElement attachmentLink;

	public OpenMRSPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void signInForData() throws Exception {
		System.out.println("Verify whether user can able to login successfully");
		logger.log(Level.INFO, "Verify whether user can able to login successfully");
		try {
			String url = ConfigurationReader.getInstance().getProperty("url");
			get(url);
			userInput(username, "Admin");
			userInput(password, "Admin123");
			eclick(locations.get(1));
			eclick(loginBtn);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} catch (Exception e) {
			logger.log(Level.INFO, "Unable login ");
		}
		System.out.println("user sucessfully logined the application");
	}

	public void registerPatient() throws Throwable {
		System.out.println("Verify whether user can able to register patient ");

		logger.log(Level.INFO, "Verify whether user can able to register patient");
		try {

			eclick(patient);
			userInput(giveName, "Naresh");
			printValue(giveName);
			userInput(familyName, "Babu");
			printValue(familyName);
			eclick(nextBtn);
			eclick(genderMaleBtn);
			printValue(genderMaleBtn);
			eclick(nextBtn);
			userInput(birthDate, "03");
			printValue(birthDate);
			multiple(birthMonth, "October", "by visibletext");
			printValue(birthMonth);
			userInput(birthyear, "2000");
			printValue(birthyear);
			eclick(nextBtn);
			userInput(address, "131 sivan kovil street");
			printValue(address);
			userInput(city, "chennai");
			printValue(city);
			userInput(state, "tamil state");
			printValue(state);
			userInput(country, "india");
			printValue(country);
			userInput(postalCode, "601102");
			printValue(postalCode);
			eclick(nextBtn);
			userInput(phoneNumber, "8778404542");
			printValue(phoneNumber);
			eclick(nextBtn);
			eclick(nextBtn);
			eclick(confirmBtn);
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		} catch (Exception e) {

			logger.log(Level.INFO, "Unable register patient");
		}
		System.out.println("User sucessfully registered ");
	}

	public void calculateAge() throws Exception {
		System.out.println("Verify whether user can able to calculate the age");
		String sdate = ConfigurationReader.getInstance().getProperty("birthdate");
		String smonth = ConfigurationReader.getInstance().getProperty("birthmonth");
		String syear = ConfigurationReader.getInstance().getProperty("birthyear");

		int years = WebUtilityClass.ageCalculator(Integer.parseInt(syear), Integer.parseInt(smonth),
				Integer.parseInt(sdate));
		String actualyears = String.valueOf(years);
		String ageV = printValue(ageValue);
		if (ageV.contains(actualyears)) {
			logger.log(Level.INFO, "Patient Age is same");
		}
		System.out.println("user sucessfully calculated the age");

	}

	public void patientDashboardPage() {
		System.out.println("Verify whether user can able to enter patientDashboardPage");

		eclick(startVisit.get(0));
		eclick(startVistConfirmbtn);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		System.out.println("User sucessfully entered the patientDashboardPage");
	}

	public void Attachment() throws Throwable {
		System.out.println("Verify whether user can able to Attach the file");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		eclick(attachmentLink);
		Thread.sleep(2000);
		eclick(file);

		Thread.sleep(2000);
		Robot rr = new Robot();
		StringSelection str = new StringSelection("C:\\Users\\deepak kumar\\Downloads\\NareshB.pdf");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);

		rr.keyPress(KeyEvent.VK_CONTROL);
		rr.keyPress(KeyEvent.VK_V);

		rr.keyRelease(KeyEvent.VK_CONTROL);
		rr.keyRelease(KeyEvent.VK_V);

		rr.keyPress(KeyEvent.VK_ENTER);
		rr.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);

		userInput(caption, "Test");
		eclick(uploadFile);
		Thread.sleep(3000);
		eclick(nameLink);
		Thread.sleep(2000);
		String uploadtext = printValue(recentVisit);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		logger.log(Level.INFO, "Able to uplaod the file " + uploadtext);
		System.out.println("User successfully Attached the File");
	}

	public void patientEndVisit() throws Throwable {
		System.out.println("Verify whether user can able to click PatientEndVisit");
		eclick(endVistUpload);
		eclick(endVistConfirmBtn);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("User successfully clicked the PatientEndVisit");
	}

	public void capturePatientVitals() throws Throwable {
		System.out.println("Verify whether user can able to capturePatientVitals ");

		eclick(startVisit.get(0));
		eclick(startVistConfirmbtn);
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		eclick(captureVitals);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		userInput(height, "150");
		eclick(nextBtn);
		userInput(weight, "64");
		eclick(nextBtn);
		String actualBmi = printValue(bmi);
		eclick(nextBtn);
		eclick(saveForm);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		double calculateBMI = WebUtilityClass.calculateBMI(64, 150);

		Thread.sleep(2000);

		String height = printValue(heightText);

		String weight = printValue(weightText);
		String actualBmi1 = printValue(bmiText);

		System.out.println("The Height of the patient is " + height);
		System.out.println("The Weight of the patient is " + weight);

		System.out.println("the BMI " + actualBmi1);
		eclick(submitBtn);
		eclick(endVist);
		eclick(endVistConfirmBtn);
		Thread.sleep(2000);
		action(nameLink, "move to element");
		Thread.sleep(2000);
		System.out.println("User successfully capturePatientVitals");

	}

	public void mergePatientVisits() {
		System.out.println("Verify whether user can able to mergePatientVisits ");
		eclick(startVisit.get(2));
		for (WebElement web : checkBox) {
			eclick(web);
		}

		eclick(mergeBtn);
		eclick(cancelBtn);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		eclick(startVisit.get(1));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		display(calBtn);

		eclick(calCancelBtn);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("User successfully mergedPatientVisits");

	}

	public void deletePatient() throws Throwable {
		System.out.println("Verify whether user can able to deletePatient");

		String Id = printValue(patientId);
		System.out.println("The patient Id " + Id);

		eclick(startVisit.get(7));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		userInput(deleteReason, "this for test purpose");

		eclick(deleteConfirmBtn);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		userInput(PatientSearch, Id);

		Thread.sleep(3000);

		String va = printValue(patientSearchAfterDelete);
		System.out.println(va);
		System.out.println("User successfully deleted the patient details");
	}

}
