package testcases;

import org.testng.annotations.Test;

import pages.Leaftaps_DeleteLeadPage;

public class DeleteLead extends BaseTest {

	private DeleteLead() {

	}

	// adding some lines
	@Test()

	public void DeleteLead() {
		new Leaftaps_DeleteLeadPage()

				.clickDeleteButton();

	}
}
