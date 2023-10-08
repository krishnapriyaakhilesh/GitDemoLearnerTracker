package com.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class Placement extends BaseClass {

	public Placement(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@href=\"/phome\"]")
	WebElement placementdashboardlink;

	@FindBy(xpath = "//table[@class=\"table table-bordered table-hover\"]/tbody/tr")
	List<WebElement> tbl_learnerlist;

	@FindBy(xpath = "//button[@class=\"btn btn-success\"]")
	WebElement submit;

	public void listPlacementOfficers()
	{
		placementdashboardlink.click();
		
	}

	public void iterateTable(int intAction) {
		try {

			for (WebElement row : tbl_learnerlist) {
				// Get all the cells in the row
				List<WebElement> cells = row.findElements(By.tagName("td"));
				// Access the last cell
				WebElement lastCell = cells.get(cells.size() - 1);
				WebElement linkElement;
				linkElement = lastCell.findElement(By.xpath("//button[@class=\"btn btn-success btn btn-primary\"]"));
				linkElement.click();
			}
		} catch (StaleElementReferenceException elementHasDisappeared) {

		}

	}

	public void submitButton() {
		// TODO Auto-generated method stub

		submit.click();

	}

}
