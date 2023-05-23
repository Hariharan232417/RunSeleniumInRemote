package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import drivers.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import reports.ExtentLogger;

public class BasePage {
	
	public static String leadNumber = "";
	
	protected void click(By by,WaitStrategy waitStrategy,String elementName)
	{
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
		ExtentLogger.pass(elementName + " is clicked ");
	}
	
	protected void actionsClick(By by,WaitStrategy waitStrategy,String elementName)
	{
		
		Actions actions = new Actions(DriverManager.getDriver());
		
		actions.moveToElement(ExplicitWaitFactory.performExplicitWait(waitStrategy, by)).click();
		try {
			ExtentLogger.reportStep(elementName + " is clicked ","Pass", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void clickUsingJavaScriptExecutor(By by,WaitStrategy waitStrategy,String elementName)
	{

		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver() ;
		executor.executeScript("arguments[0].click();", ExplicitWaitFactory.performExplicitWait(waitStrategy, by));
		
		try {
			ExtentLogger.reportStep(elementName + " is clicked ","Pass", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void sendKeys(By by, String value,WaitStrategy waitStrategy,String elementName)
	{
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(value);
		
		try {
			ExtentLogger.reportStep(value + " is entered in the  "+elementName,"Pass", true);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected String getElementText(By by, WaitStrategy waitStrategy,String elementName)
	{
		String text = ExplicitWaitFactory.performExplicitWait(waitStrategy, by).getText();
		
		try {
			ExtentLogger.reportStep(elementName +" is saved to a variable","Pass", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return text;
	}
	
	protected String getPageTitle()
	{
		return DriverManager.getDriver().getTitle();
	}
	
	protected void switchToFrame(String id)
	{
		DriverManager.getDriver().switchTo().frame(id);
	}
	
	protected void switchToDefaultContent()
	{
		DriverManager.getDriver().switchTo().defaultContent();
	}

}
