package Admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import BasePage.BasePage;
import extentReports.ExtentListeners;

public class JobTitle extends BasePage{

	public JobTitle(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//div[@class='orangehrm-header-container']//button[@type='button']")
	public WebElement addButton;
	
	@FindBy(xpath="//div[@class='oxd-input-group oxd-input-field-bottom-space']//input[@class='oxd-input oxd-input--active']")
	public WebElement jobTitle_TextBox;
	
	@FindBy(tagName="textarea")
	public List<WebElement> JobDescription_Note_TextBox;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement saveButton;
	
	public void addJobTile(String jobTitle, String jobDescription, String note) {
		WebDriverWait wait= new WebDriverWait(driver,10);
		//wait.until(ExpectedConditions.elementToBeClickable(addButton)).click();
		addButton.click();
		ExtentListeners.test.log(Status.INFO, "clicked add button");
		jobTitle_TextBox.sendKeys(jobTitle);
		ExtentListeners.test.log(Status.INFO, "Enter value in job title");
		JobDescription_Note_TextBox.get(0).sendKeys(jobDescription);
		ExtentListeners.test.log(Status.INFO, "Entered job description");
		JobDescription_Note_TextBox.get(1).sendKeys(note);
		ExtentListeners.test.log(Status.INFO, "Entered value in note");
		saveButton.click();
		ExtentListeners.test.log(Status.INFO, "clicked save button");
		
		
	}

}
