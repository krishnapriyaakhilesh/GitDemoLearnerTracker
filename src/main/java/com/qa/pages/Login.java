package com.qa.pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class Login extends BaseClass{
	
	public Login(WebDriver driver)
	{
		this.driver=driver;

		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//input[@id=\"username\"]")
	WebElement Username;
	
	@FindBy(xpath="//input[@id=\"password\"]")
	WebElement password;
	
	@FindBy(xpath="//button[text()=\"Login\"]")
	WebElement Login;
	
	//@FindBy(xpath="//div[@role=\"alert\"]")
	//WebElement errbutton;
	
	@FindBy(xpath="//div[@role=\"alert\"]")
	WebElement errbutton;
	
	
	public void clickLoginButton(String strUserName,String strPassWord )
	{
		Username.sendKeys(strUserName);
		password.sendKeys(strPassWord);
		Login.click();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	}
	
	public void clickLoginButtonInvalid(String strUserName,String strPassWord)
	{
		Username.sendKeys(strUserName);
		password.sendKeys(strPassWord);
		Login.click();
	}
	
	public String errorMsg()
	{
		
		return errbutton.getText();
	}

}
