package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.BasePage;
import pages.Leaftaps_HomePage;
import pages.Leaftaps_LeadNewRecordPage;
import pages.Leaftaps_LoginPage;
import reports.ExtentManager;
import reports.ExtentReport;
import utils.GenericMethods;

public final class CreateLead extends BaseTest {
	
	@BeforeTest
	public void testDetails()
	{
		ExtentReport.createTest("Create Lead");
	}

	
	private CreateLead()
	{
		//added some tetxt
	}
	
	@Test(invocationCount=1)
	public void createLead()
	{
		
		
		new Leaftaps_LoginPage()
			.clickCrmSfaButton()
			.clickCreateLeadButton()
			.enterCompanyName(GenericMethods.generateRandomString(5))
			.enterFirstName(GenericMethods.generateRandomString(6))
			.enterLastName(GenericMethods.generateRandomString(6))
			.clickSubmitButton()
			.getId();  
		
		
			
	}
	
	
	@Test(priority = 1)
	public void createLead2() {
		new Leaftaps_HomePage().clickCreateLeadButton().enterCompanyName(GenericMethods.getCompanyName())
				.enterFirstName(GenericMethods.getFirstName()).enterLastName(GenericMethods.getLastName())
				.clickSubmitButton().getId2();
	}
	
}
