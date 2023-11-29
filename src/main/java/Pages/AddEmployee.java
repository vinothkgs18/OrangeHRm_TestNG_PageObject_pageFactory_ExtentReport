package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import BasePage.BasePage;
import extentReports.ExtentListeners;

public class AddEmployee extends BasePage {

	public AddEmployee(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(name = "firstName")
	public WebElement firstName;

	@FindBy(name = "middleName")
	public WebElement middleName;

	@FindBy(name = "lastName")
	public WebElement lastName;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement save;

	@FindBy(xpath = "//p[@class='oxd-text oxd-text--p oxd-text--toast-message oxd-toast-content-text']")
	public WebElement saveMessage;

	@FindBy(xpath = "//span[@class='oxd-switch-input oxd-switch-input--active --label-right']")
	public WebElement createLoginDetail;

	@FindBy(xpath = "//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']")
	public List<WebElement> textbox;

	@FindBy(xpath = "//div[@class='']//input[@class='oxd-input oxd-input--active']")
	public List<WebElement> textbox2;

	@FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
	public List<WebElement> saveButtons;
	
	@FindBy(xpath="//h6[text()='Personal Details']")
	public WebElement personalDetailLabel;
	
	@FindBy(xpath="//label[text()='Nickname']//ancestor::div[@class='oxd-input-group__label-wrapper']//following-sibling::div//input")
	public WebElement nickNames;
	
	@FindBy(xpath="//label[contains(text(),'Driver')]//parent::div//following-sibling::div//input")
	public WebElement DLnumber;

	@FindBy(xpath="//label[contains(text(),'Expiry')]//parent::div//following-sibling::div//input")
	public WebElement DLexpiry;
	
	@FindBy(xpath="//label[contains(text(),'SSN')]//parent::div//following-sibling::div//input")
	public WebElement ssnNumber;
	
	@FindBy(xpath="//label[contains(text(),'SIN')]//parent::div//following-sibling::div//input")
	public WebElement sinNumber;
	
	
	@FindBy(xpath="//label[contains(text(),'Birth')]//parent::div//following-sibling::div//input")
	public WebElement dateOfBirth;
	
	@FindBy(xpath="//label[contains(text(),'Military')]//parent::div//following-sibling::div//input")
	public WebElement military;
	
	
	
	// -----------------------------------------------------------------------------------------------------------------

	public void addingEmp(String firstname, String lastname, String userName, String password, String conform_Password,
			String nickName, String DLNumber, String dlExpire, String ssn, String sin, String dob,
			String militryServices) throws InterruptedException {
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		firstName.sendKeys(firstname);
		ExtentListeners.test.log(Status.INFO, "Entered the first name as " + firstname);
		lastName.sendKeys(lastname);
		ExtentListeners.test.log(Status.INFO, "Entered the last name as " + lastname);
		createLoginDetail.click();
		ExtentListeners.test.log(Status.INFO, "clicked the create Login Detail button");
		textbox.get(1).sendKeys(userName);
		ExtentListeners.test.log(Status.INFO, "Entered the user name as " + userName);
		textbox.get(2).sendKeys(password);
		ExtentListeners.test.log(Status.INFO, "Entered the password  as " + password);
		textbox.get(2).sendKeys(conform_Password);
		ExtentListeners.test.log(Status.INFO, "Entered the conform password as " + conform_Password);
		save.click();
		ExtentListeners.test.log(Status.INFO, "clicked the save button");
		WebDriverWait wait = new WebDriverWait(driver, 60);
		WebElement until = wait.until(ExpectedConditions.visibilityOf(saveMessage));
		ExtentListeners.test.log(Status.INFO, "Employee added successfully " + until.getText());
		wait=new WebDriverWait(driver,20);
		//nickNames.sendKeys(nickName);
		//ExtentListeners.test.log(Status.INFO, "Entered the nick name as " + nickName);
		Thread.sleep(6000);
		DLnumber.sendKeys(DLNumber);
		ExtentListeners.test.log(Status.INFO, "Entered the DL number as " + DLNumber);
		DLexpiry.sendKeys(dlExpire);
		ExtentListeners.test.log(Status.INFO, "Entered the DL expire date as " + dlExpire);
		ssnNumber.sendKeys(ssn);
		ExtentListeners.test.log(Status.INFO, "Entered the SSN number as " + ssn);
		sinNumber.sendKeys(sin);
		ExtentListeners.test.log(Status.INFO, "Entered the SIN number as " + ssn);
		dateOfBirth.sendKeys(dob);
		ExtentListeners.test.log(Status.INFO, "Entered the DOB as " + dob);
		military.sendKeys(militryServices);
		ExtentListeners.test.log(Status.INFO, "Entered the Militry services as " + militryServices);
		saveButtons.get(0).click();
		ExtentListeners.test.log(Status.INFO, "clicked the save button");
		

	}

}
