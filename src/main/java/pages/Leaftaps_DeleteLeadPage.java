package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;

public class Leaftaps_DeleteLeadPage extends BasePage {
	
	private final String deleteButton = "//a[text()=\"Delete\"]";
	



	public Leaftaps_DeleteLeadPage clickDeleteButton()

	{
		click(By.xpath(deleteButton), WaitStrategy.CLICKABLE, "Delete the Merged Leads");
		return new Leaftaps_DeleteLeadPage();

	}

}
