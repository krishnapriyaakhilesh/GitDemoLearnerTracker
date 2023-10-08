package com.qa.testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.qa.base.BaseClass;
import com.qa.pages.Login;
import com.qa.pages.Placement;
import com.qa.utilities.ExcelUtility;

public class PlacementTC extends BaseClass {

	Login objLogin;
	Placement objplacement;

	void initializeAdminLogin() throws IOException 
	{
		objLogin = new Login(driver);
		String setUserName = ExcelUtility.getCellData(1, 0);
		String setPassWord = ExcelUtility.getCellData(1, 1);
		objLogin.clickLoginButton(setUserName, setPassWord);
		

	}


	void initializePlacementOfficerLogin() throws IOException 
	{
		objLogin = new Login(driver);
		String setUserName = ExcelUtility.getCellData(3, 0);
		String setPassWord = ExcelUtility.getCellData(3, 1);
		objLogin.clickLoginButton(setUserName, setPassWord);

	}
	

	@Test(priority = 1)
	public void listPlacementOfficers() throws IOException {
		initializeAdminLogin();
		objplacement = new Placement(driver);
		objplacement.listPlacementOfficers();
		
	}

	@Test(priority = 2)
	public void updatePlacementOfficers() throws IOException {
		initializeAdminLogin();
		objplacement = new Placement(driver);
		objplacement.listPlacementOfficers();
		objplacement.iterateTable(1);
		objplacement.submitButton();

	}
	
	@Test(priority = 3)
	public void listPlacementOfficersone() throws IOException {
		initializePlacementOfficerLogin();
		objplacement = new Placement(driver);
		objplacement.listPlacementOfficers();
	}
	
	@Test(priority = 4)
	public void updatePlacementOfficersone() throws IOException {
		initializePlacementOfficerLogin();
		objplacement = new Placement(driver);
		objplacement.listPlacementOfficers();
		objplacement.iterateTable(1);
		objplacement.submitButton();

	}
	
	

	@AfterMethod
	void close() {

		this.driver.close();
	}

}
