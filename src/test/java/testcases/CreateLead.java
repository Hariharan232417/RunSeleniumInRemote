package testcases;

import org.testng.annotations.Test;

import pages.Leaftaps_HomePage;
import pages.Leaftaps_LoginPage;
import utils.GenericMethods;

public final class CreateLead extends BaseTest {

	private CreateLead() {
		// added some text
	}

	@Test()
	public void createLead() {

		new Leaftaps_LoginPage()

				.enterUserName("Demosalesmanager").enterPassword("crmsfa").clickLoginButton().clickCrmSfaButton()
				.clickCreateLeadButton().enterCompanyName(GenericMethods.getCompanyName())
				.enterFirstName(GenericMethods.getFirstName()).enterLastName(GenericMethods.getLastName())
				.clickSubmitButton().getId();

	}

	@Test()
	public void createLead2() {
		new Leaftaps_HomePage().clickCreateLeadButton().enterCompanyName(GenericMethods.getCompanyName())
				.enterFirstName(GenericMethods.getFirstName()).enterLastName(GenericMethods.getLastName())
				.clickSubmitButton().getId2();
	}

}
