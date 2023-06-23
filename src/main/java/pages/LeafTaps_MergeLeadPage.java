
public class LeafTaps_MergeLeadPage extends BasePage {
		private final String mergeLeads = "//a[text()=\"Merge Leads\"]";
		private final String fromLead = "//input[@name=\"ComboBox_partyIdFrom\"]";
		private final String toLead = "//input[@name=\"ComboBox_partyIdTo\"]";
		private final String mergeButton = "//a[@class=\"buttonDangerous\"]";

		public Leaftaps_MergeLeadPage clickMergeLeadButton() {
			click(By.xpath(mergeLeads), WaitStrategy.CLICKABLE, "Click Merge Lead Button");
			return new Leaftaps_MergeLeadPage();

		}

		public Leaftaps_MergeLeadPage enterFromLead() {
			sendKeys(By.xpath(fromLead), leadNumber1, WaitStrategy.PRESENCE, "Set newly Created Lead");

			return this;

		}

		public Leaftaps_MergeLeadPage enterToLead() {
			sendKeys(By.xpath(toLead), leadNumber2, WaitStrategy.PRESENCE, "Set newly Created Lead");

			return this;

		}

		public Leaftaps_MergeLeadPage clickMergeButton()

		{
			click(By.xpath(mergeButton), WaitStrategy.CLICKABLE, "Merge Two Leads");
			return new Leaftaps_MergeLeadPage();

		}

	}

}
