package testcases;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.LeafTaps_MergeLeadPage;
import pages.Leaftaps_LoginPage;
import reports.ExtentReport;
import testcases.BaseTest;

public final class MergeLead extends BaseTest {

	private MergeLead() {

	}
	
	

	@Test(priority = 2)
	public void MergeLead() {
		
		new Leaftaps_LoginPage()
		
		.enterUserName("Demosalesmanager")
		.enterPassword("crmsfa")
		.clickLoginButton()
		.clickCrmSfaButton().clickLeadsButton().clickMergeLeads().enterFromLead().enterToLead().clickMergeButton().clickAlertOK().getCompanyName();

	}
}
