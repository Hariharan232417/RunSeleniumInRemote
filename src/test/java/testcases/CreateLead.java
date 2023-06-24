package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.Leaftaps_HomePage;
import pages.Leaftaps_LoginPage;
import reports.ExtentReport;
import testcases.BaseTest;
import utils.GenericMethods;

public final class CreateLead extends BaseTest {
	
		
	private CreateLead()
	{
		//added some tetxt
	}
	
	@Test(priority = 1)
	public void createLead()
	{
		
		new Leaftaps_LoginPage()
		
		.enterUserName("Demosalesmanager")
		.enterPassword("crmsfa")
		.clickLoginButton()
			.clickCrmSfaButton()
			.clickCreateLeadButton()
			.enterCompanyName(GenericMethods.generateRandomString(5))
			.enterFirstName(GenericMethods.generateRandomString(6))
			.enterLastName(GenericMethods.generateRandomString(6))
			.clickSubmitButton()
			.getId();  	
	}
	
	
}
