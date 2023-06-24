package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;
import pages.BasePage;

public class LeafTaps_MergeLeadPage extends BasePage {
		private final String mergeLeads = "//a[text()=\"Merge Leads\"]";
		private final String fromLead = "//input[@name=\"ComboBox_partyIdFrom\"]";
		private final String toLead = "//input[@name=\"ComboBox_partyIdTo\"]";
		private final String mergeButton = "//a[@class=\"buttonDangerous\"]";

		public LeafTaps_MergeLeadPage clickMergeLeadButton() {
			//click(By.xpath(mergeLeads), WaitStrategy.CLICKABLE, "Click Merge Lead Button");
			
			click(By.xpath(mergeLeads), WaitStrategy.CLICKABLE, "CrmSfaButton");
			return this;

		}

		public LeafTaps_MergeLeadPage enterFromLead() {
			sendKeys(By.xpath(fromLead), leadNumber1, WaitStrategy.PRESENCE, "Set newly Created Lead");

			return this;

		}

		public LeafTaps_MergeLeadPage enterToLead() {
			sendKeys(By.xpath(toLead), leadNumber2, WaitStrategy.PRESENCE, "Set newly Created Lead");

			return this;

		}

		public LeafTaps_MergeLeadPage clickMergeButton()

		{
			click(By.xpath(mergeButton), WaitStrategy.CLICKABLE, "Merge Two Leads");
			return this;

		}

	}
