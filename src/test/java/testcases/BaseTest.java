package testcases;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import drivers.Driver;
import reports.ExtentReport;

public class BaseTest {
	
	protected BaseTest()
	{
		
	}
	
	
	

	
	@BeforeMethod
	public void setUp()
	{
		Driver.initDriver();
	}
	
	@AfterMethod
	public void tearDown()
	{
		Driver.quitDriver();
	}

}
