package pages;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import enums.WaitStrategy;



public class LeadsPage extends BasePage {

private final String mergeLeads = "//a[@href='/crmsfa/control/mergeLeadsForm']";

	
	
	public LeafTaps_MergeLeadPage clickMergeLeads()
	{
			
		click(By.xpath(mergeLeads),WaitStrategy.PRESENCE,"MergeLeads");
		
		return new LeafTaps_MergeLeadPage();
		
	}
	
	

}
