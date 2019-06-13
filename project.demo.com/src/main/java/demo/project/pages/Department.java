package demo.project.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Department {

	WebDriver driver;

	@FindBy(id = "t-setting")
	WebElement Settings;

	@FindBy(xpath = "//a[@href='/Department/Index']")
	WebElement ManageDepartments;

/*	@FindBy(xpath = ".//*[@id='mCSB_1_container']/table/tbody/tr["/+ (row+1) + /"]/td[5]/span/i")
	WebElement DeleteDeptBtn;*/

	@FindBy(className = "swal-modal")
	WebElement DeleteRecallMSGBox;
	/*WebElement Deletedialog;*/
	
	@FindBy(xpath = "html/body/div[5]/div/div[2]")
	WebElement ConfirmMessage;
	
	@FindBy(xpath = "html/body/div[5]/div/div[3]/div[2]/button")
	WebElement ConfirmOkBtn;
	
	@FindBy(id = "DepartmentName")
	WebElement EnterDeptName;

	@FindBy(id = "btnSave")
	WebElement SaveDept;
	
	
	public String deletebtn1 =  ".//*[@id='mCSB_1_container']/table/tbody/tr[";
	public String deletebtn2 =  "]/td[5]/span/i";
	public String DeptTable = "//*[@id=\"grdGroup\"]";
	public String Recallbtn1 = "/html/body/div[2]/div[2]/div/div[5]/div/div/div/div[2]/div[2]/div/div/div[1]/table/tbody/tr[";
	public String Recallbtn2 = "] /td[5]/span/i";
	
	public Department(WebDriver driver) {
		this.driver = driver;
		// This initElements method will create all WebElements
		PageFactory.initElements(driver, this);
	}

	public void ClickOnSettings() throws InterruptedException {

		WebDriverWait wait = new WebDriverWait(driver, 20);
		Settings = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("t-setting")));
		Settings.click();
		Thread.sleep(3000);
	}

	public void ClickonManageDepartments() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		ManageDepartments = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@href='/Department/Index']")));
		ManageDepartments.click();
		Thread.sleep(3000);
	}
	
	/*public void ClickonDeleteDepartment() {
		DeleteDeptBtn.click();
	}*/
	
	public String getConfirmationMessage() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement getConfirmationMessage;
		getConfirmationMessage = wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("html/body/div[5]/div/div[2]")));	
		return ConfirmMessage.getText();
	}
	
	public void ClickOKConfirmMessage() {
		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		ConfirmOkBtn = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath("html/body/div[5]/div/div[3]/div[2]/button")));
		ConfirmOkBtn.click();
	}
	
	public void EnterDepartmentName(String strEnterDeptName) {
		EnterDeptName.sendKeys(strEnterDeptName);
	}
	
	public void AddDepartmentName(String strEnterDeptName) throws InterruptedException {
		this.EnterDepartmentName(strEnterDeptName);
		
		Thread.sleep(5000);
	}
	
	public void ClicktoAddDept() {
		SaveDept.click();
	}


}
