package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import drivers.DriverManager;
import enums.WaitStrategy;
import reports.ExtentLogger;
import utils.GenericMethods;

public class Leaftaps_LeadNewRecordPage extends BasePage{
	
	private final String CompanyName = "//input[@id='createLeadForm_companyName']";
	
	private final String FirstName = "//input[@id='createLeadForm_firstName']";
	
	private final String LastName = "//input[@id='createLeadForm_lastName']";
	
	private final String SubmitButton = "//input[@name='submitButton']";
	
	private final String Id = "//span[@id='viewLead_companyName_sp']";
	
	
	public Leaftaps_LeadNewRecordPage enterCompanyName(String companyname)
	{
		
		sendKeys(By.xpath(CompanyName), companyname, WaitStrategy.PRESENCE,"CompanyName");
		
		
		return this;
		
	}
	
	public Leaftaps_LeadNewRecordPage enterFirstName(String firstname)
	{
		
		sendKeys(By.xpath(FirstName), firstname, WaitStrategy.PRESENCE,"FirstName");
		
		return this;
		
	}
	
	public Leaftaps_LeadNewRecordPage enterLastName(String lastname)
	{
		
		sendKeys(By.xpath(LastName), lastname, WaitStrategy.PRESENCE,"LastName");
		
		return this;
		
	}

	public  Leaftaps_LeadNewRecordPage clickSubmitButton()
	{
		click(By.xpath(SubmitButton), WaitStrategy.CLICKABLE, "SubmitButton");
		return this;
	
	}
	
	public Leaftaps_LeadNewRecordPage getId()

	{
		String leadID= getElementText(By.xpath(Id), WaitStrategy.PRESENCE, Id);
		leadNumber = GenericMethods.extractNumber(leadID);
		System.out.println(leadNumber);
		return this;
	}
	
	public Leaftaps_LeadNewRecordPage getId2()

	{
		String leadID2= getElementText(By.xpath(Id), WaitStrategy.PRESENCE, Id);
		leadNumber2 = GenericMethods.extractNumber(leadID2);
		System.out.println(leadNumber2);
		return this;
	}
	
	
}
