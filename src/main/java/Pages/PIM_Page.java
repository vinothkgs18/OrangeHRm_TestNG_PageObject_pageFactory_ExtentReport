package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.aventstack.extentreports.Status;

import BasePage.BasePage;
import extentReports.ExtentListeners;

public class PIM_Page extends BasePage {

	public PIM_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath = "//a[@class='oxd-topbar-body-nav-tab-item']")
	public List<WebElement> topMenu;

	@FindBy(xpath = "//span[@class='oxd-topbar-body-nav-tab-item']")
	public WebElement topMenu_configuration;
	
	

	// -----------------------------------------------------------------------------------------------------------

	public void goToConfiguration() {
		topMenu_configuration.click();
	}

	public Employee_List goToEmployeeList() {
		topMenu.get(0).click();
		return new Employee_List(driver);
	}

	public AddEmployee goToAddEmployee() {
		topMenu.get(1).click();
		ExtentListeners.test.log(Status.INFO, "Click the add employee link ");
		return new AddEmployee(driver);
	}

	public void goToReports() {
		topMenu.get(2).click();
	}

}
