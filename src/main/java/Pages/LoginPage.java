package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;
import com.github.dockerjava.api.model.LogConfig.LoggingType;

import BasePage.BasePage;
import extentReports.ExtentListeners;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	
	
	@FindBy(xpath="//input[@name='username']")
	public WebElement userName;
	
	
	@FindBy(xpath="//input[@name='password']")
	public WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement loginButton;
	
	
	@FindBy(xpath="//p[@class='oxd-text oxd-text--p orangehrm-login-forgot-header']")
	public WebElement forgetPasswordlink;
	
	
	
	//--------------------------------------------------------------------------------------------------------
	
	
	public  ApplicationHomePage dologin(String username, String Password) throws InterruptedException {
		
		userName.sendKeys(username);
		ExtentListeners.test.log(Status.INFO, "Entered the user name as "+username);
		password.sendKeys(Password);
		ExtentListeners.test.log(Status.INFO, "Entered the password as "+Password);
		loginButton.click();
		ExtentListeners.test.log(Status.INFO, "Click the login Button ");
		return  new ApplicationHomePage(driver);
	}
	
	
	public void goToForgetPassword() {
		forgetPasswordlink.click();
		ExtentListeners.test.log(Status.INFO, "Click the forget password link in login page");
	}

}
