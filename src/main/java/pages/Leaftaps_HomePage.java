package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;

public class Leaftaps_HomePage extends BasePage{

private final String CreateLeadButton = "//a[text()='Create Lead']";



	public  Leaftaps_LeadNewRecordPage clickCreateLeadButton()
	{
		click(By.xpath(CreateLeadButton), WaitStrategy.CLICKABLE, "CreateLeadButton");
		return new Leaftaps_LeadNewRecordPage() ;

	}


}
