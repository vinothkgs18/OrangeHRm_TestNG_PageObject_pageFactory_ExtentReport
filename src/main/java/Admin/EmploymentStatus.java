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

public class EmploymentStatus extends BasePage{

	public EmploymentStatus(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div[@class='orangehrm-header-container']//button[@type='button']")
	public WebElement addButton;
	
	@FindBy(xpath="//label[text()='Name']//parent::div//following-sibling::div//input")
	public WebElement nameField;
	
	@FindBy(xpath="//button[@type='submit']")
	public List<WebElement> saveButtons;
	
	@FindBy(xpath="//p[text()='Successfully Saved']")
	public WebElement successMessage;
	
	public String addEmployeementStatus(String name) {
		WebDriverWait wait= new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		addButton.click();
		ExtentListeners.test.log(Status.INFO, "Clicked the add button");
		nameField.sendKeys(name);
		ExtentListeners.test.log(Status.INFO, "Enter the value in name field");
		saveButtons.get(0).click();
		ExtentListeners.test.log(Status.INFO, "Clicked the save button");
		String text = wait.until(ExpectedConditions.visibilityOf(successMessage)).getText();
		ExtentListeners.test.log(Status.INFO,text+" msg from system");
		return text;
		
		
	}

}
