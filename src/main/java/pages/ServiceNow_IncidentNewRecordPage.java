package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import drivers.DriverManager;
import enums.WaitStrategy;
import reports.ExtentLogger;
import utils.GenericMethods;

public class ServiceNow_IncidentNewRecordPage extends BasePage{
	
	private final String shortDescription = "//input[@id='incident.short_description']";
	
	private final String submitButton = "//button[@id='sysverb_insert_bottom']";
	
	public ServiceNow_IncidentNewRecordPage enterShortDescription()
	{
		String text = "Incident Sample"+GenericMethods.getRandomString();
		sendKeys(By.xpath(shortDescription), text, WaitStrategy.PRESENCE,"Short Desription");
	
		return this;
		
	}

	public ServiceNow_IncidentsPage clickSubmitButton()
	{
		
		click(By.xpath(submitButton),WaitStrategy.CLICKABLE,"Submit button");
	
		return new ServiceNow_IncidentsPage();
	}
}
