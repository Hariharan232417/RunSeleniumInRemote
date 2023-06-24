package pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.interactions.Actions;

import drivers.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import reports.ExtentLogger;

public class BasePage {

	public static String leadNumber = "";
	
	//public static String leadNumber1 = "";
	public static String leadNumber2 = "10233";

	protected void click(By by, WaitStrategy waitStrategy, String elementName) {
		try {
			ExplicitWaitFactory.performExplicitWait(waitStrategy, by).click();
			ExtentLogger.reportStep(elementName + " is clicked ","Pass",true);
		} 
		catch (NoSuchElementException e) {
			ExtentLogger.reportStep("Element not found - "+elementName,"Fail", true);
		}
		catch (ElementClickInterceptedException e) {
			ExtentLogger.reportStep("Element not clicked - "+elementName + " as it is intercepted","Fail", true);
		}
		catch (TimeoutException e) {
			ExtentLogger.reportStep("Element not clicked - "+elementName + " as it is not found within the time","Fail", true);
			new TimeoutException("Element not found");
		}
		
		catch (StaleElementReferenceException e) {
			ExtentLogger.reportStep("Element not clicked - "+elementName + " as the Element is stale","Fail", true);
			new StaleElementReferenceException("Element Stale");
		}
		
		catch (UnhandledAlertException e) {
			ExtentLogger.reportStep("Element not clicked - "+elementName + " as the Alert is present","Fail", true);
			new UnhandledAlertException("Element Stale");
		}
		

	}

	protected void actionsClick(By by, WaitStrategy waitStrategy, String elementName) {

		Actions actions = new Actions(DriverManager.getDriver());

		actions.moveToElement(ExplicitWaitFactory.performExplicitWait(waitStrategy, by)).click();
		try {
			ExtentLogger.reportStep(elementName + " is clicked ", "Pass", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void clickUsingJavaScriptExecutor(By by, WaitStrategy waitStrategy, String elementName) {

		JavascriptExecutor executor = (JavascriptExecutor) DriverManager.getDriver();
		executor.executeScript("arguments[0].click();", ExplicitWaitFactory.performExplicitWait(waitStrategy, by));

		try {
			ExtentLogger.reportStep(elementName + " is clicked ", "Pass", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void sendKeys(By by, String value, WaitStrategy waitStrategy, String elementName) {
		ExplicitWaitFactory.performExplicitWait(waitStrategy, by).sendKeys(value);

		try {
			ExtentLogger.reportStep(value + " is entered in the  " + elementName, "Pass", true);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected String getElementText(By by, WaitStrategy waitStrategy, String elementName) {
		String text = ExplicitWaitFactory.performExplicitWait(waitStrategy, by).getText();

		try {
			ExtentLogger.reportStep(elementName + " is saved to a variable", "Pass", true);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return text;
	}
	
	
	protected void clickOkInAlert()
	{
		
		//Alert alert = ExplicitWaitFactory.performExplicitWait(waitStrategy,null);
		try {
			Thread.sleep(2000);
		
		DriverManager.getDriver().switchTo().alert().accept();
		
		ExtentLogger.reportStep("Clicked Ok button in Alert", "Pass", true);
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NoAlertPresentException nA)
		{
			ExtentLogger.reportStep("No alert present", "fail", true);
			throw new NoAlertPresentException();
		}
	}

	protected String getPageTitle() {
		return DriverManager.getDriver().getTitle();
	}

	protected void switchToFrame(String id) {
		DriverManager.getDriver().switchTo().frame(id);
	}

	protected void switchToDefaultContent() {
		DriverManager.getDriver().switchTo().defaultContent();
	}

}
