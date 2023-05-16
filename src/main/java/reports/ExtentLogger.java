package reports;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.internal.PropertyUtils;

import com.aventstack.extentreports.MediaEntityBuilder;

import drivers.DriverManager;
import enums.ConfigProperties;
import utils.ReadPropertyFile;

public final class ExtentLogger {
	
	private ExtentLogger()
	{
		
	}
	
	public static void pass(String message)
	{
		ExtentManager.getExtentTest().pass(message);
	}
	public static void fail(String message)
	{
		ExtentManager.getExtentTest().fail(message);
	}
	public static void skip(String message)
	{
		ExtentManager.getExtentTest().skip(message);
	}
	
	public static void pass(String message,boolean isScreenshotNeeded) throws Exception
	{
		if(ReadPropertyFile.getValue(ConfigProperties.PASSEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded)
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		else
			pass(message);
	}
	
	public static void fail(String message,boolean isScreenshotNeeded) throws Exception
	{
		if(ReadPropertyFile.getValue(ConfigProperties.FAILEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded)
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		else
			fail(message);
	}
	
	public static void skip(String message,boolean isScreenshotNeeded) throws Exception
	{
		if(ReadPropertyFile.getValue(ConfigProperties.SKIPPEDSTEPSCREENSHOTS).equalsIgnoreCase("yes") && isScreenshotNeeded)
			ExtentManager.getExtentTest().pass(message, MediaEntityBuilder.createScreenCaptureFromBase64String(getBase64Image()).build());
		else
			skip(message);
	}
	
	public static String getBase64Image()
	{
		return ((TakesScreenshot)DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
