package Pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;

import Admin.AdminTopMenu;
import Admin.User_Management;
import BasePage.BasePage;
import extentReports.ExtentListeners;

public class ApplicationHomePage extends BasePage {
	
	
	public ApplicationHomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	

	@FindBy(xpath="//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name']")
	public List<WebElement> sideMenu;
	
	@FindBy(xpath="//h6[text()='Dashboard']")
	public WebElement dashboardlabel;
	
	
	//---------------------------------------------------------------------------------------------------------------------------
	
	public AdminTopMenu goToAdmin_SideMenu() {
		sideMenu.get(0).click();
		return new AdminTopMenu(driver);
	}
	
	public PIM_Page goToPIM_SideMenu() {
		wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(dashboardlabel));
		sideMenu.get(1).click();
		ExtentListeners.test.log(Status.INFO, "clicked the PIM link on home page");
		return new PIM_Page(driver);
	}
	
	public void goToLeave_SideMenu() {
		sideMenu.get(2).click();
	}
	
	public void goToTime_SideMenu() {
		sideMenu.get(3).click();
	}
	
	public String getPageTitle() {
		String title = driver.getTitle();
		return title;
	}

}
