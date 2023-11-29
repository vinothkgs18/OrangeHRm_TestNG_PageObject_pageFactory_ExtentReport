package org.OrangeHRM.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import extentReports.ExtentListeners;
import extentReports.ExtentManager;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public WebDriver driver;
	public Properties config = new Properties();
	public Properties OR = new Properties();
	public FileInputStream fis;
	public Logger log = LogManager.getLogger("TestBase");
	public WebDriverWait wait;

	public void setUp(String browser) {
		

		try {
			fis = new FileInputStream(
					"C:\\Users\\vinot\\eclipse-workspace\\orangeHRM\\src\\test\\resources\\Properties\\Config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			config.load(fis);
			log.info("Config file loaded successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\OR.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			OR.load(fis);
			log.info("OR file loaded successfully");
			// ExtentListeners.test.log(Status.INFO, "OR file loaded successfully");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			log.debug("Chrome Driver launched");
			ExtentListeners.test.log(Status.INFO, "chrome Browser Launched");

		}

		else if (browser.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			log.debug("fireFox Driver launched");
			ExtentListeners.test.log(Status.INFO, "fireFox Browser Launched");

		}

		else {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			log.debug("Edge Driver launched");
			ExtentListeners.test.log(Status.INFO, "Edge Browser Launched");

		}

		driver.get(config.getProperty("environment"));
		log.debug("navigate to application url");

		driver.manage().window().maximize();
		log.debug("maximaze the window");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		log.debug("wait for 10 second");

	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
		ExtentListeners.test.log(Status.INFO, "Browser closed");
	}

}
