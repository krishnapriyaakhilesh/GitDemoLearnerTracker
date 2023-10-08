package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.qa.base.BaseClass;
import com.qa.constants.AutomationConstants;
import com.qa.pages.Login;
import com.qa.pages.Learners;
import com.qa.utilities.ExcelUtility;

public class LearnersTC extends BaseClass {

	Learners objlearners;
	Login objLogin;

	void initializeAdminLogin() throws IOException {
		objLogin = new Login(driver);
		String setUserName = ExcelUtility.getCellData(1, 0);
		String setPassWord = ExcelUtility.getCellData(1, 1);
		objLogin.clickLoginButton(setUserName, setPassWord);

	}
	
	void initializeTrainerLogin() throws IOException {
		objLogin = new Login(driver);
		String setUserName = ExcelUtility.getCellData(4, 0);
		String setPassWord = ExcelUtility.getCellData(4, 1);
		objLogin.clickLoginButton(setUserName, setPassWord);

	}
	
	
	

	@Test(priority = 1)
	public void listLearners() throws IOException {
		initializeAdminLogin();
		objlearners = new Learners(driver);
		objlearners.listLearners();
		objlearners.addLearners();
		String id = ExcelUtility.getCellData(1, 5);
		String name = ExcelUtility.getCellData(2, 5);
		String course = ExcelUtility.getCellData(3, 5);
		String project = ExcelUtility.getCellData(4, 5);
		String batch = ExcelUtility.getCellData(5, 5);
		String coursestatus = ExcelUtility.getCellData(6, 5);
		objlearners.addLearnersData(id, name, course, project, batch, coursestatus);
		objlearners.okMsg();
		String expectedvalue = AutomationConstants.SUCCESSFULMSGLEARNERADD;
		String actualvalue = objlearners.successMsg();
		Assert.assertEquals(actualvalue, expectedvalue);

	}

	@Test(priority = 2)
	public void updateLearners() throws IOException {
		initializeAdminLogin();
		objlearners = new Learners(driver);
		objlearners.listLearners();
		objlearners.iterateTable(1);
		

	}

	@Test(priority = 3)
	public void deleteLearners() throws IOException {
		initializeAdminLogin();
		objlearners = new Learners(driver);
		objlearners.listLearners();
		objlearners.iterateTable(2);

	}

	@Test(priority = 4)
	public void csvLink() throws IOException {
		initializeAdminLogin();
		objlearners = new Learners(driver);
		objlearners.listLearners();
		objlearners.csvLink();
		String expectedvalue = AutomationConstants.CSVMSG;
		String actualvalue = objlearners.csvuploadmsg();
		Assert.assertEquals(actualvalue, expectedvalue);	
		
	}
	
	@Test(priority = 5)
	public void csvLinkupload() throws IOException {
		initializeAdminLogin();
		objlearners = new Learners(driver);
		objlearners.listLearners();
		objlearners.csvLink();
		objlearners.uploadCSV();
		String expectedvalue = AutomationConstants.CSVRETURNTODASHBOARD;
		String actualvalue = objlearners.returnToDashBoardcsv();
		Assert.assertEquals(actualvalue, expectedvalue);
		objlearners.returnToDashboardClick();
	}
	
	@Test(priority = 6)
	public void csvLinkCancel() throws IOException {
		initializeAdminLogin();
		objlearners = new Learners(driver);
		objlearners.listLearners();
		objlearners.csvLink();
		objlearners.csvCancel();
		String expectedvalue = AutomationConstants.CSVRETURNTODASHBOARD;
		String actualvalue = objlearners.returnToDashBoardcsv();
		Assert.assertNotEquals(actualvalue, expectedvalue);
		
	}
	
	@Test(priority = 7)
	public void listTrainerLearners() throws IOException {
		initializeTrainerLogin();
		objlearners = new Learners(driver);
		objlearners.listLearners();
		objlearners.addLearners();
		String id = ExcelUtility.getCellData(1, 5);
		String name = ExcelUtility.getCellData(2, 5);
		String course = ExcelUtility.getCellData(3, 5);
		String project = ExcelUtility.getCellData(4, 5);
		String batch = ExcelUtility.getCellData(5, 5);
		String coursestatus = ExcelUtility.getCellData(6, 5);
		objlearners.addLearnersData(id, name, course, project, batch, coursestatus);
		objlearners.okMsg();
		String expectedvalue = AutomationConstants.SUCCESSFULMSGLEARNERADD;
		String actualvalue = objlearners.successMsg();
		Assert.assertEquals(actualvalue, expectedvalue);

	}

	@Test(priority = 8)
	public void updateTrainerLearners() throws IOException {
		initializeTrainerLogin();
		objlearners = new Learners(driver);
		objlearners.listLearners();
		objlearners.iterateTable(1);
		
		

	}

	@Test(priority = 9)
	public void deleteTrainerLearners() throws IOException {
		initializeTrainerLogin();
		objlearners = new Learners(driver);
		objlearners.listLearners();
		objlearners.iterateTable(2);

	}

	@Test(priority = 10)
	public void csvLinkTrainers() throws IOException {
		initializeTrainerLogin();
		objlearners = new Learners(driver);
		objlearners.listLearners();
		objlearners.csvLink();
		String expectedvalue = AutomationConstants.CSVMSG;
		String actualvalue = objlearners.csvuploadmsg();
		Assert.assertEquals(actualvalue, expectedvalue);	
		
	}
	
	@Test(priority = 11)
	public void csvLinkuploadTrainers() throws IOException {
		initializeTrainerLogin();
		objlearners = new Learners(driver);
		objlearners.listLearners();
		objlearners.csvLink();
		objlearners.uploadCSV();
		String expectedvalue = AutomationConstants.CSVRETURNTODASHBOARD;
		String actualvalue = objlearners.returnToDashBoardcsv();
		Assert.assertEquals(actualvalue, expectedvalue);
		objlearners.returnToDashboardClick();
	}
	
	@Test(priority = 12)
	public void csvLinkCancelTrainers() throws IOException {
		initializeTrainerLogin();
		objlearners = new Learners(driver);
		objlearners.listLearners();
		objlearners.csvLink();
		objlearners.csvCancel();
	}
	
	
	@Test(priority = 13)
	public void backToDashboardWithoutUpdate() throws IOException {
		initializeAdminLogin();
		objlearners = new Learners(driver);
		objlearners.listLearners();
		objlearners.addLearners();
		objlearners.returnToDashboardClickWithoutUpdate();
		String expectedvalue = AutomationConstants.RETURNTODASHBOARDWITHOUTUPDATELEARNER;
		String actualvalue = objlearners.returnToDashBoardText();
		Assert.assertEquals(actualvalue, expectedvalue);
		
	}
	

	@AfterMethod
	void close() 
	{
		this.driver.close();
	}

}