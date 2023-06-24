package testcases;

import org.testng.annotations.Test;

import pages.LeafTaps_MergeLeadPage;
import testcases.BaseTest;

public final class MergeLead extends BaseTest {

	private MergeLead() {

	}

	@Test(priority = 2)
	public void MergeLead() {

		new LeafTaps_MergeLeadPage()

				.clickMergeLeadButton().enterFromLead().enterToLead().clickMergeButton();

	}
}
