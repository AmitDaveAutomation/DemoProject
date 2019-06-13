package demo.project.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Company {

	WebDriver driver;

	@FindBy(id = "t-setting")
	WebElement Settings;

	public Company(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void clickonsettings() throws InterruptedException {
		Settings.click();
		Thread.sleep(10000);
	}

}
