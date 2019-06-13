package demo.project.pages.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.project.helpers.OpenBrowser;
import demo.project.pages.Department;

public class DepartmentTest extends OpenBrowser {

	Department objdepartment;
	LoginTest objlogintest;

	@Test(priority = 0)
	public void LoginProcess() throws Exception {

		objlogintest = new LoginTest();
		objlogintest.VerifyLoginTitleText();
		objlogintest.EnterloginCredential();
		objlogintest.VerifyLandingPageTitle();

	}

	@Test(priority = 1)
	public void ClickSettings() throws Exception {
		objdepartment = new Department(driver);
		objdepartment.ClickOnSettings();

	}

	@Test(priority = 2)
	public void ClickManageDepartments() throws Exception {
		objdepartment = new Department(driver);
		objdepartment.ClickonManageDepartments();
	}

	@Test(priority = 3)
	public void DeleteSpecificDepartment() throws InterruptedException {

		String Department = "Test";

		WebElement mytable = driver.findElement(By.xpath(objdepartment.DeptTable));

		List<WebElement> rows_table = mytable.findElements(By.tagName("tr"));

		int rows_count = rows_table.size();
		for (int row = 0; row < rows_count; row++) {
			List<WebElement> Columns_row = rows_table.get(row).findElements(By.tagName("td"));

			int columns_count = Columns_row.size();
			for (int column = 0; column < columns_count; column++) {

				String celtext = Columns_row.get(column).getText(); 
				System.out.println(celtext);
			
				if (Columns_row.get(column).getText().equals(Department))
				{
					Thread.sleep(1000);
					driver.findElement(By.xpath(objdepartment.deletebtn1 + row + objdepartment.deletebtn2)).click();
					Thread.sleep(1000);
				}
				else
				{
					objdepartment.AddDepartmentName("Test");
					Thread.sleep(3000);
					objdepartment.ClicktoAddDept();
					Thread.sleep(3000);
					/*
					 * driver.findElement(By.xpath(objdepartment.deletebtn1 + row +
					 * objdepartment.deletebtn2)).click();
					 */

					WebElement mytable2 = driver.findElement(By.xpath(objdepartment.DeptTable));

					List<WebElement> rows_table2 = mytable2.findElements(By.tagName("tr"));

					int rows_count2 = rows_table2.size();
					for (int row2 = 0; row2 < rows_count2; row2++) {
						List<WebElement> Columns_row2 = rows_table2.get(row2).findElements(By.tagName("td"));

						int columns_count2 = Columns_row2.size();
						for (int column2 = 0; column2 < columns_count2; column2++) {

							/* String celtext = Columns_row.get(column).getText(); */
							System.out.println(column2);

							if (Columns_row2.get(column2).getText().equals(Department)) {
								Thread.sleep(1000);
								driver.findElement(By.xpath(objdepartment.deletebtn1 + row2 + objdepartment.deletebtn2))
										.click();
								Thread.sleep(1000);
							}
						}
					}
				}

			}
		}

	}

	/* String celtext; */

	/*
	 * do {
	 * 
	 * celtext = Columns_row.get(column).getText(); System.out.println(celtext);
	 * 
	 * } while (celtext.equals("CIMCON"));
	 */

	/*
	 * if (celtext.equals("CIMCON")) { Thread.sleep(1000);
	 * driver.findElement(By.xpath(objdepartment.deletebtn1 + (row + 1) +
	 * objdepartment.deletebtn2)) .click(); Thread.sleep(1000); } else {
	 * objdepartment.AddDepartmentName("CIMCON"); Thread.sleep(3000);
	 * objdepartment.ClicktoAddDept(); }
	 */

	@Test(priority = 4)
	public void VerifyDeletDeptMessage() throws Exception {

		String DeleteMessage = objdepartment.getConfirmationMessage();
		System.out.println(DeleteMessage);

		Assert.assertEquals(DeleteMessage, "Are you sure you want to delete this record?");
		System.out.println("Deleted Message is correct");
		Thread.sleep(1000);

	}

	@Test(priority = 5)
	public void ClickOktoDelete() throws Exception {

		objdepartment.ClickOKConfirmMessage();
		System.out.println("Department is Deleted");
		Thread.sleep(3000);
	}

	@Test(priority = 6)
	public void RecallDepartment() throws Exception {
		WebElement mytable1 = driver.findElement(By.xpath(objdepartment.DeptTable));

		List<WebElement> rows_table1 = mytable1.findElements(By.tagName("tr"));

		int rows_count1 = rows_table1.size();
		for (int row1 = 0; row1 < rows_count1; row1++) {
			List<WebElement> Columns_row1 = rows_table1.get(row1).findElements(By.tagName("td"));

			int columns_count1 = Columns_row1.size();
			for (int column1 = 0; column1 < columns_count1; column1++) {
				String celtext = Columns_row1.get(column1).getText();
				if (celtext.equals("HR CIMCON")) {

					driver.findElement(By.xpath(objdepartment.Recallbtn1 + (row1) + objdepartment.Recallbtn2)).click();
					Thread.sleep(1000);
				}
			}
		}
	}

	@Test(priority = 7)
	public void VerifyRecallDeptMessage() throws Exception {

		String DeleteMessage = objdepartment.getConfirmationMessage();
		System.out.println(DeleteMessage);

		Assert.assertEquals(DeleteMessage, "Are you sure you want to recall this record?");
		System.out.println("Recall Message is correct");
		Thread.sleep(1000);

	}

	@Test(priority = 8)
	public void ClickOktoRecall() throws Exception {

		objdepartment.ClickOKConfirmMessage();
		System.out.println("Department is Recalled");
		Thread.sleep(3000);
	}

}
