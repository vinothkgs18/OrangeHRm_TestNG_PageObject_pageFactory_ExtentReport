package extentReports;

import java.io.IOException;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import BasePage.BasePage;




public class ExtentListeners implements ITestListener, ISuiteListener {



	static Date d = new Date();
	static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";

	public static ExtentTest test;
	private static ExtentReports extent = ExtentManager
			.createInstance(".\\target\\extent-report\\" + fileName);

	//public static ThreadLocal<ExtentTest> testReport = new ThreadLocal<ExtentTest>();
	
	
	
	
	
	

	public void onTestStart(ITestResult result) {

		 test = extent
				.createTest(result.getTestClass().getName() + "     TestCase : " + result.getMethod().getMethodName());
		//testReport.set(test);

	}

	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "TEST CASE:- " + methodName.toUpperCase() + " PASSED" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
		test.pass(m);
		

	}

	public void onTestFailure(ITestResult result) {
		
		String methodName=result.getMethod().getMethodName();
		String logText="<b>"+"TEST CASE:- "+ methodName.toUpperCase()+ " Was FAILED"+"</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.RED);
		
		//Markup exception = MarkupHelper.createLabel(result.getThrowable().toString(), ExtentColor.RED);
		//test.log(Status.FAIL, exception);
		
		//test.log(Status.FAIL, result.getThrowable().getMessage());
		
		try {
			ExtentManager.captureScreenshot();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
		
		
	
		test.fail("<font color=red>"+result.getThrowable().toString());

		test.fail("<b><font color=red>" + "Screenshot of failure" + "</font></b><br>",MediaEntityBuilder.createScreenCaptureFromPath(ExtentManager.fileName)
				.build());
		test.log(Status.FAIL, m);
		
		
	
		
		
		
		
		

	}

	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		String logText = "<b>" + "Test Case:- " + methodName + " Skipped" + "</b>";
		Markup m = MarkupHelper.createLabel(logText, ExtentColor.YELLOW);
		test.skip(m);

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

		if (extent != null) {

			extent.flush();
		}

	}

	public void onStart(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ISuite suite) {
		// TODO Auto-generated method stub
		
	}

}
