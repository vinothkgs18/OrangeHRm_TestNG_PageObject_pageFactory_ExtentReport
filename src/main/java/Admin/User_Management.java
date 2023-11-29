package Admin;

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

public class User_Management extends BasePage {

	public User_Management(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	@FindBy(xpath="//span[text()='User Management ']")
	public WebElement userManagement;
	
	@FindBy(xpath="//a[text()='Users']")
	public WebElement users;
	
	@FindBy(xpath="//i[@class='oxd-icon bi-plus oxd-button-icon']//parent::button[@type='button']")
	public WebElement addButton;
	
	@FindBy(xpath="//div[@class='oxd-select-text-input']")
	public List<WebElement> dropdownField;
	
	@FindBy(xpath="//span[text()='ESS']")
	public WebElement ess;
	
	@FindBy(xpath="//input[@placeholder='Type for hints...']")
	public WebElement empName;
	
	@FindBy(xpath="//span[text()='Ravi M B']")
	public WebElement sugName;
	
	@FindBy(xpath="//span[text()='Enabled']")
	public WebElement enabled;
	
	@FindBy(xpath="//input[@autocomplete='off']")
	public List<WebElement> credentials;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement save;
	
	@FindBy(xpath="(//input[@class='oxd-input oxd-input--active'])[2]")
	public WebElement searchByUserName;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement searchButton;
	
	@FindBy(xpath="(//div[@role='row'])[2]//child::div[@role='cell'][2]")
	public List<WebElement> tableAllData;
	
	@FindBy(xpath="(//div[@role='row'])//child::div[@role='cell'][2]")
	public List<WebElement> tableAllcolumn;
	
	@FindBy(xpath="//div[@role='row']")
	public List<WebElement> tableAllRows;
	
	@FindBy(xpath="//span[text()='Should be at least 5 characters']")
	public WebElement errorMsgForUserName;
	
	@FindBy(xpath="//p[text()='Successfully Saved']")
	public WebElement successMessage;
	
	public void createNewUser(String EmployeeName, String username, String Password) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait=new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOf(addButton)).click();
		ExtentListeners.test.log(Status.INFO, "Clicked the add button");
		dropdownField.get(0).click();
		wait.until(ExpectedConditions.visibilityOf(ess)).click();
		ExtentListeners.test.log(Status.INFO, "select the ess from drop down");
		empName.sendKeys(EmployeeName);
		ExtentListeners.test.log(Status.INFO, "Entered the emp name as  "+EmployeeName);
		wait.until(ExpectedConditions.visibilityOf(sugName)).click();
		dropdownField.get(1).click();
		wait.until(ExpectedConditions.visibilityOf(enabled)).click();
		ExtentListeners.test.log(Status.INFO, "selected the enabled from drop down");
		credentials.get(0).sendKeys(username);
		ExtentListeners.test.log(Status.INFO, "Enter the user name as"+username);
		Thread.sleep(4000);
		credentials.get(1).sendKeys(Password);
		ExtentListeners.test.log(Status.INFO, "Enter the password as "+Password);
		credentials.get(2).sendKeys(Password);
		ExtentListeners.test.log(Status.INFO, "Enter the conform password as"+Password);
		save.click();
		ExtentListeners.test.log(Status.INFO, "Clicked the save button");
		String text = wait.until(ExpectedConditions.visibilityOf(successMessage)).getText();
		ExtentListeners.test.log(Status.INFO,text+" msg from system");
		
		
	}
	
	public User_Management searchUserByUserName(String userName) throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver,10);
		searchByUserName.sendKeys(userName);
		ExtentListeners.test.log(Status.INFO, "Enter the user name in user name filed");
		Thread.sleep(3000);
		searchButton.click();
		ExtentListeners.test.log(Status.INFO, "Clicked the search button");
		return this;
	}
	
	public int verifySearchResult() throws InterruptedException {
		Thread.sleep(4000);
		int rowCount = tableAllRows.size()-1;
		System.out.println("Table Record count is=  "+rowCount);
		for(int i=0;i<=tableAllRows.size()-1;i++) {
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			String text = tableAllRows.get(i).getText();
			System.out.print(text);
			System.out.println("");
		}
		ExtentListeners.test.log(Status.INFO, "Verified the search result");
		return rowCount;
		
		
	}

}
