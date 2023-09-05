package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;

public class ServiceNow_HomePage extends BasePage{

	private final String filterNavigator = "//input[@id='filter']";

	private final String incidentsLink = "//a[contains(normalize-space(),'Self-Service')]/..//a[contains(normalize-space(),'Incidents')]";

	public ServiceNow_HomePage enterSearchText_filterNavigator(String searchTextFilter)
	{
		switchToDefaultContent();
		sendKeys(By.xpath(filterNavigator), searchTextFilter, WaitStrategy.PRESENCE,"Search text");

		return this;
	}

	public ServiceNow_IncidentsPage clickIncidentLink()
	{

		click(By.xpath(incidentsLink),WaitStrategy.CLICKABLE,"Incident Link");

		return new ServiceNow_IncidentsPage();
	}

}
