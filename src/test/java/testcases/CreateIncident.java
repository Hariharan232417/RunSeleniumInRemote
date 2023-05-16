package testcases;

import org.testng.annotations.Test;

import pages.ServiceNow_LoginPage;
import reports.ExtentReport;

public final class CreateIncident extends BaseTest {

	
	private CreateIncident()
	{
		
	}
	
	@Test
	public void createIncident()
	{
		
		
		new ServiceNow_LoginPage()
			
			.enterUserName("admin")
			.enterPassword("ll3DS=pp4B-P")
			.clickLoginButton()
			.enterSearchText_filterNavigator("Incidents")
			.clickIncidentLink()
			.clickNewButton()
			.enterShortDescription()
			.clickSubmitButton();
			
			
	}
	
}
