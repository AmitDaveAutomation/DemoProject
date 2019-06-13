package demo.project.pages.test;

import org.testng.annotations.Test;

import demo.project.helpers.OpenBrowser;
import demo.project.pages.Login;
import junit.framework.Assert;

public class LoginTest extends OpenBrowser {

	Login objLogin;

	public LoginTest() {

	}

	@Test(priority = 0)
	public void VerifyLoginTitleText() {

		objLogin = new Login(driver);

		// Verify login page title
		String loginPageTitle = objLogin.getLoginTitleText();
		Assert.assertTrue(loginPageTitle.contains("Welcome!"));
	}

	@Test(priority = 1)
	public void EnterloginCredential() throws Exception {
		// login to application
		objLogin.LogintoEUC("UserName", "Password");

	}

	@Test(priority = 2)
	public void VerifyLandingPageTitle() throws Exception {
		objLogin = new Login(driver);
		String LandingPageTitle = objLogin.getLandingPageTitle();
		Assert.assertTrue(LandingPageTitle.contains("Test"));
		/* objLogin.clickonsettings(); */
		Thread.sleep(5000);
	}
}
