package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;

public class ServiceNow_LoginPage extends BasePage{

	private final String userName ="//input[@id='user_name']";
	private final String userName2 ="//td//input[@name=\"USERNAME\"]";

	private final String passWord = "//input[@id='user_password']";
	private final String passWord2 = "//td//input[@name=\"PASSWORD\"]";

	private final String logInButton = "//button[@id='sysverb_login']";
	private final String logInButton2 = "//td//input[@class=\"loginButton\"]";

	public ServiceNow_LoginPage enterUserName(String username)
	{
		//switchToFrame("gsft_main");

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

	
	
	public ServiceNow_LoginPage enterUserName2(String username2)
	{

		sendKeys(By.xpath(userName2), username2, WaitStrategy.PRESENCE,"User name");

		return this;

	}
	
	public ServiceNow_LoginPage enterPassword2(String password2)
	{
		sendKeys(By.xpath(passWord2), password2, WaitStrategy.PRESENCE,"Password");

		return this;

	}

	public ServiceNow_HomePage clickLoginButton2()
	{
		click(By.xpath(logInButton2),WaitStrategy.CLICKABLE,"Login button");

		return new ServiceNow_HomePage();
	}


	
}
