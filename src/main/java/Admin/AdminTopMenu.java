package Admin;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import BasePage.BasePage;
import extentReports.ExtentListeners;

public class AdminTopMenu extends BasePage {

	public AdminTopMenu(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//span[@class='oxd-topbar-body-nav-tab-item']")
	public List<WebElement> topMenus;
	
	@FindBy(xpath="//a[@role='menuitem']")
	public List<WebElement> SubItemLinks;
	
	
	public User_Management goToUser() {
		topMenus.get(0).click();
		ExtentListeners.test.log(Status.INFO, "Navigate to user Management tab");
		SubItemLinks.get(0).click();
		ExtentListeners.test.log(Status.INFO, "Navigate to user link");
		return new User_Management(driver);
	}
	
	public JobTitle goToJobTitle_Job() {
		topMenus.get(1).click();
		ExtentListeners.test.log(Status.INFO, "Navigate to Job tab ");
		SubItemLinks.get(0).click();
		ExtentListeners.test.log(Status.INFO, "Navigate to Job title link ");
		return new JobTitle(driver);
		
	}
	
	public Pay_Grades goToPay_Grades() {
		topMenus.get(1).click();
		ExtentListeners.test.log(Status.INFO, "Navigate to Job tab ");
		SubItemLinks.get(1).click();
		ExtentListeners.test.log(Status.INFO, "Navigate to Pay_Grades link ");
		return new Pay_Grades(driver);
	}
	
	public EmploymentStatus goToEmploymentStatus() {
		topMenus.get(1).click();
		ExtentListeners.test.log(Status.INFO, "Navigate to Job tab ");
		SubItemLinks.get(2).click();
		ExtentListeners.test.log(Status.INFO, "Navigate to EmploymentStatus link ");
		return new EmploymentStatus(driver);
	}
	
	public Job_Category goToJob_Categories() {
		topMenus.get(1).click();
		ExtentListeners.test.log(Status.INFO, "Navigate to Job tab ");
		SubItemLinks.get(3).click();
		ExtentListeners.test.log(Status.INFO, "Navigate to Job Category link ");
		return new Job_Category(driver);
	}
	
	public Work_Shift goToWorkShift() {
		topMenus.get(1).click();
		ExtentListeners.test.log(Status.INFO, "Navigate to Job tab ");
		SubItemLinks.get(4).click();
		ExtentListeners.test.log(Status.INFO, "Navigate to Job Category link ");
		return new Work_Shift(driver);
	}
	
	
	

}
