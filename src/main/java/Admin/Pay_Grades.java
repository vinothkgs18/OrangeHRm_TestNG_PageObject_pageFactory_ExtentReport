package Admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import BasePage.BasePage;
import extentReports.ExtentListeners;

public class Pay_Grades extends BasePage{

	public Pay_Grades(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div[@class='orangehrm-header-container']//button[@type='button']")
	public WebElement addButton;
	
	@FindBy(xpath="//label[text()='Name']//parent::div//following-sibling::div//input")
	public WebElement nameField;
	
	
	@FindBy(xpath="//div[@class='oxd-select-text--after']")
	public WebElement dropDown;
	
	@FindBy(xpath="//div[@role='option']")
	public List<WebElement> dropDownOptions;
	
	@FindBy(xpath="//button[@type='submit']")
	public List<WebElement> saveButtons;
	
	@FindBy(xpath="//label[text()='Minimum Salary']//parent::div//following-sibling::div//input")
	public WebElement minSalaryField;
	
	@FindBy(xpath="//label[text()='Maximum Salary']//parent::div//following-sibling::div//input")
	public WebElement maxSalaryField;
	
	public void addPayGrades(String names, String minSalary, String MaxSalary) {
		
		addButton.click();
		ExtentListeners.test.log(Status.INFO, "Clicked the add button");
		nameField.sendKeys(names);
		ExtentListeners.test.log(Status.INFO, "Enter the value in name field");
		saveButtons.get(0).click();
		ExtentListeners.test.log(Status.INFO, "Clicked the save button");
		addButton.click();
		ExtentListeners.test.log(Status.INFO, "Clicked the add button");
		dropDown.click();
		ExtentListeners.test.log(Status.INFO, "Clicked the dropDown");
		dropDownOptions.get(2).click();
		ExtentListeners.test.log(Status.INFO, "selected the value from dropdown");
		minSalaryField.sendKeys(minSalary);
		ExtentListeners.test.log(Status.INFO, "Enter the value in Minimum Salary field");
		maxSalaryField.sendKeys(MaxSalary);
		ExtentListeners.test.log(Status.INFO, "Enter the value in Maximum  Salary field");
		
		saveButtons.get(1).click();
		ExtentListeners.test.log(Status.INFO, "Clicked the save button");
		
		
	}

}
