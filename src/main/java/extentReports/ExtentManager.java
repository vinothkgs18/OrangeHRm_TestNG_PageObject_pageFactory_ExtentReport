package extentReports;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import BasePage.BasePage;

public class ExtentManager extends BasePage {

	public ExtentManager(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private static ExtentReports extent;
	public static String fileName;

	public static ExtentReports createInstance(String fileName) {
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(fileName);

		htmlReporter.config().setTheme(Theme.STANDARD);
		htmlReporter.config().setDocumentTitle(fileName);
		htmlReporter.config().setEncoding("utf-8");
		htmlReporter.config().setReportName(fileName);

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Automation Tester", "Vinoth Kumar Gnanasekaran");
		extent.setSystemInfo("Organization", "Atmecs Technolodgy");
		extent.setSystemInfo("Build no", "W2A-1234");

		return extent;
	}

	public static void captureScreenshot() throws IOException {

		Date d = new Date();
		fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screeshot = ((TakesScreenshot) BasePage.driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screeshot, new File(".\\target\\extent-report\\" + fileName));
	}

	public static void captureElementScreenshot(WebElement element) throws IOException {

		Date d = new Date();
		String fileName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		File screeshot = ((TakesScreenshot) element).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screeshot, new File(".//screenshot//" + "Element_" + fileName));
	}

}
