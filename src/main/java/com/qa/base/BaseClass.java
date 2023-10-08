package com.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;

public class BaseClass {

	public static Properties properties;
	public WebDriver driver;

	public BaseClass() {
		properties = new Properties();
		File file = new File(System.getProperty("user.dir") + "/src/main/java/com/qa/config/config.properties");

		try {

			FileInputStream inputStream = new FileInputStream(file);
			properties.load(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	@BeforeMethod
	public void initilizeDriver() {

		String browser = properties.getProperty("browser");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		}

		if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.get(properties.getProperty("landingpage"));
		driver.manage().window().maximize();

	}

	@AfterSuite
	public void TearDown() {
		driver.close();
	}

}
