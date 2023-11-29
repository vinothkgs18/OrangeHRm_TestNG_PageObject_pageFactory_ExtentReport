package org.OrangeHRM.Utilities;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;








public class ExtentManager {
	private static ExtentReports extent;
	
	public static ExtentReports getInstance() {
		if(extent==null) {
			extent=new ExtentReports();
			ExtentSparkReporter spark= new ExtentSparkReporter("C:\\Users\\vinot\\eclipse-workspace\\LiveProject_01\\target\\surefire-reports\\html\\extentSpark-report.html");
			extent.attachReporter(spark);
		}
		return extent;	
	}

}
