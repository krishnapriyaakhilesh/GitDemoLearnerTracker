package com.qa.pages;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.qa.base.BaseClass;


public class Learners extends BaseClass {

	public Learners(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href=\"/thome\"]")
	WebElement learnerslink;

	@FindBy(xpath = "//a[@href=\"/tadd\"]")
	WebElement addlearners;

	@FindBy(xpath = "//input[@id=\"learnerid\"]")
	WebElement learnerid;

	@FindBy(xpath = "//input[@id=\"name\"]")
	WebElement learnername;

	@FindBy(xpath = "//select[@name=\"course\"]")
	WebElement selectcourse;

	@FindBy(xpath = "//select[@name=\"project\"]")
	WebElement selectproject;

	@FindBy(xpath = "//select[@name=\"batch\"]")
	WebElement selectbatch;

	@FindBy(xpath = "//select[@name=\"cstatus\"]")
	WebElement selectcoursestatus;

	@FindBy(xpath = "//button[text()=\"Submit\"]")
	WebElement submit;

	@FindBy(xpath = "//div[text()=\"Posted successfully\"]")
	WebElement successfulmsg;

	@FindBy(xpath = "//button[text()=\"OK\"]")
	WebElement okbutton;

	@FindBy(xpath = "//table[@class=\"table table-bordered table-hover\"]/tbody/tr")
	List<WebElement> tbl_learnerlist;

	@FindBy(xpath = "//a[@href=\"/upload\"]")
	WebElement csvlink;

	@FindBy(xpath = "//label[text()=\"Upload a CSV File :\"]")
	WebElement csvlabeltext;

	@FindBy(xpath = "//input[@name=\"file\"]")
	WebElement csvupload;

	@FindBy(xpath = "//button[text()=\"Submit\"]")
	WebElement csvsubmit;

	@FindBy(xpath = "//button[@class=\"ui mini button\"]")
	WebElement csvcancel;

	@FindBy(xpath = "//a[text()=\"Click here to download a sample csv file\"]")
	WebElement csvdownload;

	@FindBy(xpath = "//button[text()=\"Return to Dashboard\"]")
	WebElement returntodashboard;

	@FindBy(xpath = "//button[@class=\"btn btn-warning\"]")
	WebElement returntodashboardwithoutupdate;

	@FindBy(xpath = "//h2[text()=\"Data added successfully..!\"]")
	WebElement returntodashboardtextcsv;

	public void listLearners()

	{
		learnerslink.click();

	}

	public void addLearners()

	{
		addlearners.click();

	}

	public void csvLink()

	{
		csvlink.click();

	}

	public void addLearnersData(String id, String strName, String strcourse, String strproject, String strbatch,
			String strcoursestatus) {
		learnerid.sendKeys(id);
		learnername.sendKeys(strName);
		Select course = new Select(selectcourse);
		course.selectByVisibleText("ST");
		Select project = new Select(selectproject);
		project.selectByVisibleText("ICTAK");
		Select batch = new Select(selectbatch);
		batch.selectByVisibleText("Mar_23");
		Select coursestatus = new Select(selectcoursestatus);
		coursestatus.selectByVisibleText("Qualified");
		submit.click();

	}

	public void okMsg()

	{
		okbutton.click();

	}

	public String successMsg() {
		return successfulmsg.getText();

	}

	public String csvuploadmsg() {
		return csvlabeltext.getText();
	}

	/*
	 * public String updateLearnerDetails() { return updatemessage.getText();
	 * 
	 * }
	 */

	public void okButton() {
		okbutton.click();
	}

	public void iterateTable(int intAction) {
		// Get all the rows in the table
		try {
			// Iterate through each row
			for (WebElement row : tbl_learnerlist) {
				// Get all the cells in the row
				List<WebElement> cells = row.findElements(By.tagName("td"));
				// Access the last cell
				WebElement lastCell = cells.get(cells.size() - 1);
				WebElement linkElement;
				switch (intAction) {
				case 1:
					linkElement = lastCell.findElement(By.xpath("//button[@class=\"btn btn-success\"]"));
					linkElement.click();
					break;
				case 2:
					linkElement = driver.findElement(By.xpath("//button[@class=\"btn btn-danger\"]"));
					linkElement.click();
					break;
				default:

				}
			}

		} catch (StaleElementReferenceException elementHasDisappeared) {

		}
	}

	
	
	/*
	 * public String checkFileDownload() {
	 * 
	 * String strdndPath = "C:\Users\priya\Downloads"; String strFindFile =
	 * AutomationConstants.CSVFILENAME; String strFileName;
	 * 
	 * boolean isFileDownloaded = isFileDownloaded(strdndPath, strFindFile);
	 * 
	 * if (isFileDownloaded) { System.out.println("File download verified");
	 * strFileName = strFindFile; } else { System.out.println("Not downloaded");
	 * strFileName = null; } return strFileName;
	 * 
	 * }
	 * 
	 * // To check if a file exists in a directory.//
	 * 
	 * private static boolean isFileDownloaded(String strdndPath, String fileName) {
	 * File dir = new File(strdndPath); File[] dirContents = dir.listFiles();
	 * 
	 * if (dirContents != null) { for (File file : dirContents) { if
	 * (file.getName().equals(fileName)) { return true; } } } return false;
	 * 
	 * }
	 */
	 

	public void uploadCSV() {
		csvupload.sendKeys(System.getProperty("user.dir") + "/src/main/resources/SampleCSV.csv");
		csvsubmit.click();

	}

	public void returnToDashboardClick() {
		returntodashboard.click();
	}

	public void returnToDashboardClickWithoutUpdate() {
		returntodashboardwithoutupdate.click();
	}

	public String returnToDashBoardText() {
		return returntodashboard.getText();

	}

	public String returnToDashBoardcsv() {
		return returntodashboardtextcsv.getText();

	}

	public void csvCancel() {
		csvcancel.click();
	}

}
