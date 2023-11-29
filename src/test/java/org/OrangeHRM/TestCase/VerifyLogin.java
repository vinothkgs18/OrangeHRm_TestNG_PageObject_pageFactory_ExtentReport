package org.OrangeHRM.TestCase;




import org.OrangeHRM.Base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

import Admin.User_Management;
import Pages.ApplicationHomePage;
import Pages.LoginPage;

public class VerifyLogin extends TestBase {
	
	@Test(enabled=true)
	public void verifyLoginWithValidCredential() throws InterruptedException {
		setUp("edge");
		LoginPage l = new LoginPage(driver);

		ApplicationHomePage dologin = l.dologin("admin", "admin123");
		String pageTitle = dologin.getPageTitle();
		Assert.assertEquals(pageTitle, "OrangeHRM1");

	}
	
	@Test(enabled=true)
	public void verify_user_able_to_add_new_employee() throws InterruptedException {
		setUp("edge");
		LoginPage l = new LoginPage(driver);

		 l.dologin("admin", "admin123").goToPIM_SideMenu().goToAddEmployee().addingEmp("sekaran", "kanna", "sekaran.ss", "admin123", "admin123", "Sakthi", "TN5004443578951", "2030-12-30", "207082284671", "20027106270", "1991-01-18", "Not served");
		 l.dologin("admin", "admin123").goToPIM_SideMenu().goToEmployeeList().employeeSearchByName(null);

	}
	
	@Test(enabled=true)
	public void Verify_user_able_to_search_employee_by_name() throws InterruptedException {
		setUp("edge");
		LoginPage l = new LoginPage(driver);
		l.dologin("admin", "admin123").goToPIM_SideMenu().goToEmployeeList().employeeSearchByName("pen");
	}
	
	
}
