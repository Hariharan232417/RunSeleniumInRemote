package testcases;

import org.testng.annotations.Test;

import pages.Leaftaps_MergeLeadPage;

public final class MergeLead extends BaseTest {

	private MergeLead() {

	}

	@Test()

	public void MergeLead() {

		new Leaftaps_MergeLeadPage()

				.clickMergeLeadButton().enterFromLead().enterToLead().clickMergeButton().AlertHandle();

	}
}
