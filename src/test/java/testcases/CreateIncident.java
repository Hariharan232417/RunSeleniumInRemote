package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.ServiceNow_LoginPage;
import reports.ExtentReport;

public final class CreateIncident extends BaseTest {

	
	private CreateIncident()
	{
		//added some tetxt
	}
	
		
	@Test
	public void createIncident()
	{
		
		
		new ServiceNow_LoginPage()
			.enterUserName("Demosalesmanager")
			.enterPassword("crmsfa")
			.clickLoginButton()
			.enterSearchText_filterNavigator("Incidents")
			.clickIncidentLink()
			.clickNewButton()
			.enterShortDescription()
			.clickSubmitButton();
			
			
	}
	
}
