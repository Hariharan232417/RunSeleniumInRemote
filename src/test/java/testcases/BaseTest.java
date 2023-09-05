package testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import drivers.Driver;

public class BaseTest {

	protected BaseTest() {

	}

	@BeforeTest
	public void setUp() {
		Driver.initDriver();
	}

	@AfterTest
	public void tearDown() {
		Driver.quitDriver();
	}

}
