package testcases;

import org.testng.annotations.Test;

import pages.ServiceNow_LoginPage;

public final class CreateIncident extends BaseTest {

	private CreateIncident() {
		// added some tetxt
	}

	@Test
	public void createIncident() {

		new ServiceNow_LoginPage()

				.enterUserName("Demosalesmanager").enterPassword("crmsfa").clickLoginButton()
				.enterSearchText_filterNavigator("Incidents").clickIncidentLink().clickNewButton()
				.enterShortDescription().clickSubmitButton();

		
		new ServiceNow_LoginPage()

		.enterUserName2("Demosalesmanager").enterPassword2("crmsfa").clickLoginButton2()
		.enterSearchText_filterNavigator("Incidents").clickIncidentLink().clickNewButton()
		.enterShortDescription().clickSubmitButton();
	}

	
	
}
