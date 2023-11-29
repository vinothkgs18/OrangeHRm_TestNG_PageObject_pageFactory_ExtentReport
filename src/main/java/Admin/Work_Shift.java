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

public class Work_Shift extends BasePage {

	public Work_Shift(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div[@class='orangehrm-header-container']//button[@type='button']")
	public WebElement addButton;
	
	@FindBy(xpath="//label[text()='Shift Name']//parent::div//following-sibling::div//input")
	public WebElement shiftNameField;
	
	@FindBy(xpath="//label[text()='Assigned Employees']//parent::div//following-sibling::div//input")
	public WebElement assignedEmployeeField;
	
	@FindBy(xpath="//div[@role='option']")
	public List<WebElement>dropDownOptions;
	
	@FindBy(xpath="//button[@type='submit']")
	public List<WebElement> saveButtons;
	
	@FindBy(xpath="//p[text()='Successfully Saved']")
	public WebElement successMessage;
	
	@FindBy(xpath="//label[text()='From']//parent::div//following-sibling::div//input")
	public List<WebElement> addingHours_from;
	
	@FindBy(xpath="//label[text()='To']//parent::div//following-sibling::div//input")
	public List<WebElement> addingHours_to;
	
	
	public String add_WorkShift(String shiftName,String assignedEmployee,String from, String to) throws InterruptedException {
		WebDriverWait wait= new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		addButton.click();
		ExtentListeners.test.log(Status.INFO, "Clicked the add button");
		shiftNameField.sendKeys(shiftName);
		ExtentListeners.test.log(Status.INFO, "Enter the value in shift name field");
		assignedEmployeeField.sendKeys(assignedEmployee);
		ExtentListeners.test.log(Status.INFO, "Enter the value in Assigned Employee field");
		dropDownOptions.get(0).click();
		ExtentListeners.test.log(Status.INFO, "selected the value from the drop down");
		
		
		
		/*addingHours_from.get(0).click();
		ExtentListeners.test.log(Status.INFO, "Clicked the working hours from");
		Thread.sleep(2000);
		addingHours_from.get(1).clear();
		Thread.sleep(4000);
		addingHours_from.get(1).sendKeys(from);
		ExtentListeners.test.log(Status.INFO, "Enter the working hours ");
		Thread.sleep(2000);
		addingHours_from.get(4).sendKeys(from);
		ExtentListeners.test.log(Status.INFO, "Selected the PM ");
		
		addingHours_to.get(0).click();
		ExtentListeners.test.log(Status.INFO, "Clicked the working hours TO");
		
		addingHours_to.get(1).clear();
		Thread.sleep(4000);
		addingHours_to.get(1).sendKeys(to);
		ExtentListeners.test.log(Status.INFO, "Enter the working hours ");
		
		addingHours_to.get(3).click();
		ExtentListeners.test.log(Status.INFO, "Selected the AM ");*/
		
		
		saveButtons.get(0).click();
		ExtentListeners.test.log(Status.INFO, "Clicked the save button");
		String text = wait.until(ExpectedConditions.visibilityOf(successMessage)).getText();
		ExtentListeners.test.log(Status.INFO,text+" msg from system");
		return text;
		
		
	}
	
	
	

}
