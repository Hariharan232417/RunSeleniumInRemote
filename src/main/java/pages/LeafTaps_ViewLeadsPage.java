package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;

public class LeafTaps_ViewLeadsPage extends BasePage{
	
private final String companyName ="//span[@id='viewLead_companyName_sp']";
	
	
	

	
	public LeafTaps_ViewLeadsPage getCompanyName()
	{
		getElementText(By.xpath(companyName), WaitStrategy.PRESENCE, "Company name");
		//sendKeys(By.xpath(userName), username, WaitStrategy.PRESENCE,"User name");
		
		return this;
		
	}

}
