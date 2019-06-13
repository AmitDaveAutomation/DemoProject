package demo.project.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Login {

	WebDriver driver;

	@FindBy(id = "Email")
	WebElement UserEmail;

	@FindBy(id = "Password")
	WebElement Password;

	/* @FindBy(xpath = "//div[@class='primary login_btn']") */
	@FindBy(xpath = ".//*[@id='frmLogin']/div/div/div[4]/input")
	WebElement Loginbtn;

	@FindBy(xpath = "//span[text()=\"Welcome!\"]")
	WebElement TitleText;

	@FindBy(xpath = ".//*[@id='home']/div/div[1]/div/div/a/strong")
	WebElement LandingPageTitle;

	/*
	 * @FindBy(id = "t-setting") WebElement Settings;
	 */

	public Login(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void setUserEmail(String strUserEmail) {
		UserEmail.sendKeys(strUserEmail);
	}

	public void setPassword(String strPassword) {
		Password.sendKeys(strPassword);
	}

	public String getLoginTitleText() {
		return TitleText.getText();
	}

	// Input credential
	public void LogintoEUC(String strUserEmail, String strPassword) throws InterruptedException {
		this.setUserEmail(strUserEmail);
		this.setPassword(strPassword);
		this.clickLoginBtn();
		Thread.sleep(5000);
	}

	public void clickLoginBtn() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Loginbtn = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(".//*[@id='frmLogin']/div/div/div[4]/input")));
		Loginbtn.click();
	}

	public String getLandingPageTitle() {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement LandingPageTitle;
		LandingPageTitle = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath(".//*[@id='home']/div/div[1]/div/div/a/strong")));
		return LandingPageTitle.getText();
	}

	/*
	 * public void clickonsettings() throws InterruptedException { Settings.click();
	 * System.out.println("click settings"); Thread.sleep(10000); }
	 */

}
