package com.qa.testcases;

import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
//import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.constants.AutomationConstants;
//import com.qa.constants.AutomationConstants;
import com.qa.pages.Login;
import com.qa.utilities.ExcelUtility;

public class LoginTC extends BaseClass {

	Login objLogin;

	@BeforeMethod
	void initializeAdminLogin() {
		objLogin = new Login(driver);
	}

	@Test(priority = 1)
	public void verifyValidLogin() throws IOException {
		String setUserName = ExcelUtility.getCellData(1, 0);
		String setPassWord = ExcelUtility.getCellData(1, 1);
		objLogin.clickLoginButton(setUserName, setPassWord);
		String expectedtitle = AutomationConstants.HOMEPAGETITLE;
		String actualtitle = driver.getTitle();
		Assert.assertEquals(expectedtitle, actualtitle);

	}

	@Test(priority = 2)
	public void verifyInvalidLogin() throws IOException {

		String UserName = ExcelUtility.getCellData(2, 0);
		String Password = ExcelUtility.getCellData(2, 1);
		objLogin.clickLoginButtonInvalid(UserName, Password);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String expectedmessage = AutomationConstants.ERRORMESSAGE;
		String actualmessage = objLogin.errorMsg();
		Assert.assertEquals(expectedmessage, actualmessage);

	}

	@Test(priority = 3)
	public void verifyValidPlacementOfficerLogin() throws IOException {
		String setUserName = ExcelUtility.getCellData(3, 0);
		String setPassWord = ExcelUtility.getCellData(3, 1);
		objLogin.clickLoginButton(setUserName, setPassWord);
		String expectedtitle = AutomationConstants.PLACEMENTLOGINASSERT;
		String actualtitle = driver.getTitle();
		Assert.assertNotEquals(expectedtitle, actualtitle);

	}

	@Test(priority = 4)
	public void verifyValidTrainerLogin() throws IOException {
		String setUserName = ExcelUtility.getCellData(4, 0);
		String setPassWord = ExcelUtility.getCellData(4, 1);
		objLogin.clickLoginButton(setUserName, setPassWord);
		String expectedtitle = AutomationConstants.TRAINERLOGINASSERT;
		String actualtitle = driver.getTitle();
		Assert.assertNotEquals(expectedtitle, actualtitle);

	}
	
	@Test(priority = 5)
	public void verifyLoginWithoutUsernameAndPassword() throws IOException {

		String UserName = "";
		String Password = "";
		objLogin.clickLoginButton(UserName, Password);;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		String expectedmessage = AutomationConstants.ERRORMESSAGE;
		String actualmessage = objLogin.errorMsg();
		Assert.assertEquals(expectedmessage, actualmessage);

	}
	
	
	

	@AfterMethod
	void close() {
		driver.close();
	}

}
