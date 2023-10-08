package com.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.qa.base.BaseClass;
import com.qa.constants.AutomationConstants;
import com.qa.pages.Login;
import com.qa.pages.Users;
import com.qa.utilities.ExcelUtility;

public class UsersTC extends BaseClass {

	Users adminusers;
	Login objLogin;
	
    @BeforeMethod
   public void initializeAdminLogin() throws IOException {

		objLogin = new Login(driver);
		String setUserName = ExcelUtility.getCellData(1, 0);
		String setPassWord = ExcelUtility.getCellData(1, 1);
		objLogin.clickLoginButton(setUserName, setPassWord);

	}
	
	
	
	

	@Test(priority = 1)
	public void addUsers() throws IOException
	{
	
		adminusers = new Users(driver);
		adminusers.addUsers();

	}

	@Test(priority = 2)
	public void addUserDetails() throws IOException {
		
		adminusers = new Users(driver);
		addUsers();
		String strName = ExcelUtility.getCellData(1, 3);
		String stremail = ExcelUtility.getCellData(2, 3);
		String strUserName = ExcelUtility.getCellData(3, 3);
		String strPassWord = ExcelUtility.getCellData(4, 3);
		String strRole = ExcelUtility.getCellData(5, 3);
		adminusers.addUserData(strName, stremail, strUserName, strPassWord, strRole);
		String expectedmessage = AutomationConstants.SUCCESSFULMESSAGE;
		String actualmessage = adminusers.successMsg();
		Assert.assertEquals(actualmessage, expectedmessage);
		adminusers.okButton();

	}

	@Test(priority = 3)
	public void updateUsers() throws IOException {
		
		adminusers = new Users(driver);
		adminusers.iterateTable(1);
		String expectedmessage = AutomationConstants.UPDATEMESSAGE;
		String actualmessage = adminusers.updateMsg();
		Assert.assertEquals(actualmessage, expectedmessage);

	}

	@Test(priority = 4)
	public void deleteUsers() throws IOException {
		
		adminusers = new Users(driver);
		adminusers.iterateTable(2);

	}

	@AfterMethod
	void close() {

		this.driver.close();
	}

}
