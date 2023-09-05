package pages;

import org.openqa.selenium.By;

import enums.WaitStrategy;

public class Leaftaps_LoginPage extends BasePage {

	private final String userName = "//input[@id='username']";

	private final String passWord = "//input[@id='password']";

	private final String logInButton = "//input[@value='Login']";

	private final String CrmSfaButton = "//div[@class='crmsfa']";

	public Leaftaps_LoginPage enterUserName(String username) {

		sendKeys(By.xpath(userName), username, WaitStrategy.PRESENCE, "User name");

		return this;

	}

	public Leaftaps_LoginPage enterPassword(String password) {
		sendKeys(By.xpath(passWord), password, WaitStrategy.PRESENCE, "Password");
//		try {
//			Thread.sleep(10000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return this;

	}

	public Leaftaps_LoginPage clickLoginButton() {
		click(By.xpath(logInButton), WaitStrategy.CLICKABLE, "Login button");

		return new Leaftaps_LoginPage();
	}

	public Leaftaps_HomePage clickCrmSfaButton() {
		click(By.xpath(CrmSfaButton), WaitStrategy.CLICKABLE, "CrmSfaButton");
		return new Leaftaps_HomePage();

	}

}
