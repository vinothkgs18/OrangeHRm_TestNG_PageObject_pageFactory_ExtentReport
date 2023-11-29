package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import BasePage.BasePage;

public class Employee_List extends BasePage {

	public Employee_List(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//label[text()='Employee Name']//parent::div//following-sibling::div/div/div/div//following-sibling::input")
	public WebElement employeeName;

	@FindBy(xpath = "//label[text()='Employee Id']//parent::div//following-sibling::div/input")
	public WebElement employeeID;

	@FindBy(xpath = "//label[text()='Supervisor Name']//parent::div//following-sibling::div/div/div/div//following-sibling::input")
	public WebElement supervisorName;

	@FindBy(xpath = "//button[@type='submit']")
	public WebElement searchButton;

	@FindBy(xpath="//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//child::span[@class='oxd-text oxd-text--span']")
	public WebElement searchRecordCount;

	public void employeeSearchByName(String Employee_Name) throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		employeeName.sendKeys(Employee_Name);
		searchButton.click();
		WebDriverWait wait= new WebDriverWait(driver,10);
		Thread.sleep(6000);
		//wait.until(ExpectedConditions.visibilityOf(searchRecordCount));
		System.out.println(searchRecordCount.getText());
		
		
		

	}

}
