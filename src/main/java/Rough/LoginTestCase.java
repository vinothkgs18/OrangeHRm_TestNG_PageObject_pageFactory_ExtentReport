package Rough;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import BasePage.BasePage;
import Pages.ApplicationHomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCase extends BasePage {

	public LoginTestCase(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(6000);
		LoginPage page= new LoginPage(driver);
		page.dologin("admin", "admin123").goToPIM_SideMenu();
		
	}

}
