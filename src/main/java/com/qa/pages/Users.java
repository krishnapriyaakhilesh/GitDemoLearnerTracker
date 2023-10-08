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

public class Users extends BaseClass {
	public Users(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href=\"/ahome\"]")
	private WebElement users;

	@FindBy(xpath = "//main/div/a/button")
	private WebElement addusers;

	@FindBy(xpath = "//input[@id=\"name\"]")
	private WebElement addname;

	@FindBy(xpath = "//input[@id=\"email\" and @name=\"email\"]")
	private WebElement addemail;

	@FindBy(xpath = "//input[@id=\"username\" and @name=\"username\"]")
	private WebElement addusername;

	@FindBy(xpath = "//input[@id=\"password\" and @name=\"password\"]")
	private WebElement addpassword;

	@FindBy(xpath = "//select[@name=\"roleInputs\"]")
	private WebElement addrole;

	@FindBy(xpath = "//button[text()=\"Submit\"]")
	private WebElement submit;

	@FindBy(xpath = "//div[text()=\"Posted successfully\"]")
	private WebElement submittext;

	@FindBy(xpath = "//button[text()=\"OK\"]")
	private WebElement okbutton;

	@FindBy(xpath = "//table[@class=\"table table-bordered table-hover\"]/tbody/tr")
	List<WebElement> tbl_userlist;

	@FindBy(xpath = "//h3[text()=\"Add Users\"]")
	private WebElement updatemessage;

	public void addUsers()

	{
		addusers.click();

	}

	public void addUserData(String strName, String stremail, String strUserName, String strPassWord, String strRole) {
		addname.sendKeys(strName);
		addemail.sendKeys(stremail);
		addusername.sendKeys(strUserName);
		addpassword.sendKeys(strPassWord);
		// addrole.sendKeys(strRole);
		Select select = new Select(addrole);
		select.selectByVisibleText("Admin");
		submit.click();

	}

	public String successMsg() {
		return submittext.getText();

	}

	public String updateMsg() {
		return updatemessage.getText();

	}

	public void okButton() {
		okbutton.click();
	}

	public void iterateTable(int intAction) {
		// Get all the rows in the table

		try {
			// Iterate through each row
			for (WebElement row : tbl_userlist) {
				// Get all the cells in the row
				List<WebElement> cells = row.findElements(By.tagName("td"));
				// Access the last cell
				WebElement lastCell = cells.get(cells.size() - 1);
				WebElement linkElement;
				switch (intAction) {
				case 1:
					linkElement = lastCell
							.findElement(By.xpath("//button[@class=\"btn btn-success btn btn-primary\"]"));
					linkElement.click();
					break;
				case 2:
					linkElement = driver.findElement(By.xpath("//button[@class=\"btn btn-danger btn btn-primary\"]"));
					linkElement.click();
					break;
				default:

				}
			}

		} catch (StaleElementReferenceException elementHasDisappeared) {

		}

	}

}
