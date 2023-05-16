package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;
import reports.ExtentLogger;
import reports.ExtentManager;
import reports.ExtentReport;

public class ServiceNow_LoginPage extends BasePage{
	
	private final String userName ="//input[@id='user_name']";
	
	private final String passWord = "//input[@id='user_password']";
	
	private final String logInButton = "//button[@id='sysverb_login']";
	
	public ServiceNow_LoginPage enterUserName(String username)
	{
		switchToFrame("gsft_main");
		
		sendKeys(By.xpath(userName), username, WaitStrategy.PRESENCE,"User name");
		
		return this;
		
	}
	
	public ServiceNow_LoginPage enterPassword(String password)
	{
		sendKeys(By.xpath(passWord), password, WaitStrategy.PRESENCE,"Password");
		
		return this;
		
	}
	
	public ServiceNow_HomePage clickLoginButton()
	{
		click(By.xpath(logInButton),WaitStrategy.CLICKABLE,"Login button");
		
		return new ServiceNow_HomePage();
	}

}
