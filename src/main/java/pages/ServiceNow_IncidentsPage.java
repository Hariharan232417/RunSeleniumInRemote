package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;

public class ServiceNow_IncidentsPage extends BasePage{

	private final String newButton = "//button[@id='sysverb_new']";

	private final String searchIncidentNumber="//span[contains(text(),'Press Enter from within the input to submit the search.')]/following-sibling::input";

	public ServiceNow_IncidentNewRecordPage clickNewButton()
	{
		switchToFrame("gsft_main");
		click(By.xpath(newButton),WaitStrategy.CLICKABLE,"New button");

		return new ServiceNow_IncidentNewRecordPage();
	}

	public ServiceNow_IncidentsPage searchWithIncidentNumber(String incidentNumber)
	{

		sendKeys(By.xpath(searchIncidentNumber), incidentNumber, WaitStrategy.PRESENCE,"Inbcident Number");

		return this;
	}



}
