package testcases;

import org.testng.annotations.Test;

public final class MergeLead extends BaseTest {

	private MergeLead() {

	}

	@Test(priority = 2)
	public void MergeLead() {

		new Leaftaps_MergeLeadPage()

				.clickMergeLeadButton().enterFromLead().enterToLead().clickMergeButton().AlertHandle();

	}
}
