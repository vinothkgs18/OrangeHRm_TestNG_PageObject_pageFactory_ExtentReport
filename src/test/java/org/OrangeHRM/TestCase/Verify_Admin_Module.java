package org.OrangeHRM.TestCase;

import org.OrangeHRM.Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import Admin.AdminTopMenu;
import Admin.User_Management;
import Pages.LoginPage;
import extentReports.ExtentListeners;

public class Verify_Admin_Module extends TestBase {
	@Test(enabled=true)
	public void Verify_admin_able_to_create_new_user() throws InterruptedException {
		setUp("chrome");
		LoginPage l = new LoginPage(driver);
		AdminTopMenu admintopmenu = l.dologin("admin", "admin123").goToAdmin_SideMenu();
		
		admintopmenu.goToUser().createNewUser("Ravi M B", "Ravimg066", "Spring*123");
		int result = admintopmenu.goToUser().searchUserByUserName("Ravimg066").verifySearchResult();
		//int result = admintopmenu.goToUser().verifySearchResult();
		Assert.assertEquals(result, 1);
		ExtentListeners.test.log(Status.INFO,"Actual as= "+String.valueOf(result)+"\t\t,Expected as= 1");
		
	}
	
	@Test(enabled=true)
	public void verify_user_able_to_add_job_title() throws InterruptedException {
		setUp("chrome");
		LoginPage l = new LoginPage(driver);
		AdminTopMenu admintopmenu = l.dologin("admin", "admin123").goToAdmin_SideMenu();
		admintopmenu.goToJobTitle_Job().addJobTile("Transation Process Associate", "do the enrollment application", "all gradevate can applay");
	}
	
	@Test(enabled=true)
	public void verify_user_is_able_to_add_pay_grade() throws InterruptedException {
		setUp("chrome");
		LoginPage l = new LoginPage(driver);
		AdminTopMenu admintopmenu = l.dologin("admin", "admin123").goToAdmin_SideMenu();
		admintopmenu.goToPay_Grades().addPayGrades("TestGrade-0006", "500000", "700000");
	}
	
	@Test(enabled=true)
	public void verify_user_able_to_add_emp_status() throws InterruptedException {
		setUp("chrome");
		LoginPage l = new LoginPage(driver);
		AdminTopMenu admintopmenu = l.dologin("admin", "admin123").goToAdmin_SideMenu();
		String text = admintopmenu.goToEmploymentStatus().addEmployeementStatus("internal contract positions");
		Assert.assertEquals(text, "Successfully Saved");
		
	}
	
	@Test(enabled=true)
	public void verify_user_able_to_add_Job_category() throws InterruptedException {
		setUp("chrome");
		LoginPage l = new LoginPage(driver);
		AdminTopMenu admintopmenu = l.dologin("admin", "admin123").goToAdmin_SideMenu();
		String text = admintopmenu.goToJob_Categories().addJobCategory("Test_job_01");
		Assert.assertEquals(text, "Successfully Saved");
		
	}
	
	@Test(enabled=true)
	public void verify_user_able_to_add_work_Shift() throws InterruptedException {
		setUp("chrome");
		LoginPage l = new LoginPage(driver);
		AdminTopMenu admintopmenu = l.dologin("admin", "admin123").goToAdmin_SideMenu();
		String text = admintopmenu.goToWorkShift().add_WorkShift("Test_Gentral Shift_1", "Ravi", "10", "07");
		Assert.assertEquals(text, "Successfully Saved");
		
	}

}
