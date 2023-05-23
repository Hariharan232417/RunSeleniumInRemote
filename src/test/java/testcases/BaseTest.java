package testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import drivers.Driver;
import pages.Leaftaps_LoginPage;
import reports.ExtentReport;


public class BaseTest {
	
	
	
	protected BaseTest()
	{
		
	}
	
	
	

	@BeforeMethod
	public void setUp()
	{
		Driver.initDriver();
		
		new Leaftaps_LoginPage()
		
		.enterUserName("Demosalesmanager")
		.enterPassword("crmsfa")
		.clickLoginButton();
	}
	
	@AfterMethod
	public void tearDown()
	{
		Driver.quitDriver();
	}

}
