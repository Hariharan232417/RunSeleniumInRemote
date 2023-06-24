package pages;

import org.openqa.selenium.By;

import drivers.DriverManager;
import enums.WaitStrategy;
import reports.ExtentLogger;
import reports.ExtentManager;
import reports.ExtentReport;

public class Leaftaps_HomePage extends BasePage{
	
private final String CreateLeadButton = "//a[text()='Create Lead']";

private final String LeadsButton = "//a[@href='/crmsfa/control/leadsMain']";
	

	
	public  Leaftaps_LeadNewRecordPage clickCreateLeadButton()
	{
		click(By.xpath(CreateLeadButton), WaitStrategy.CLICKABLE, "CreateLeadButton");
		return new Leaftaps_LeadNewRecordPage() ;
	
	}
	
	public LeadsPage clickLeadsButton()
	{
		click(By.xpath(LeadsButton), WaitStrategy.CLICKABLE, "LeadsButton");
		return new LeadsPage();
	}
	
	
}
