package demo.project.pages.test;

import org.testng.annotations.Test;

import demo.project.helpers.OpenBrowser;
import demo.project.pages.Company;
import demo.project.pages.test.LoginTest;

public class CompanyTest extends OpenBrowser {

	Company objcmp;
	LoginTest objlogintest;

	@Test(priority = 0)
	public void loginprocess() throws Exception {

		objlogintest = new LoginTest();
		objlogintest.VerifyLoginTitleText();
		objlogintest.EnterloginCredential();
		objlogintest.VerifyLandingPageTitle();

	}

	@Test(priority = 1)
	public void comapnyprofile() throws Exception {
		objcmp = new Company(driver);
		objcmp.clickonsettings();

	}

}
