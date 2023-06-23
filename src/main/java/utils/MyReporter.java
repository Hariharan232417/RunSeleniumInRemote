package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriverException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public  class MyReporter {
	public static ExtentHtmlReporter reporter;
	
	public static ExtentReports extent;
	
	public String testCaseName;
	public String testCaseDescription;
	
	public ExtentTest test;
	
	@BeforeSuite
	public void projectSetup()
	{
		File f = new File("./extent_test_output");
		if(!f.mkdir())
		{
			reporter = new ExtentHtmlReporter("./extent_test_output/extent.html");
		}
		
		//reporter.setAppendExisting(false); 
		extent = new ExtentReports();
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void createTestAndNode()
	{
		test = extent.createTest(testCaseName,testCaseDescription);
		test.assignAuthor("Hari");
	}
	
	public String takeSnap()
	{
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("ddMMYYYYHHmmSS");
		
		String randomNumber = format.format(date);
		
		try {
			//FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE) , new File("./report_output/screenshots/"+randomNumber+".jpg"));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} /*
			 * catch (IOException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */
		
		
		return randomNumber;
	}
	public void reportStep(String desc, String status, boolean isScreenshotNeeded)
	{
		MediaEntityModelProvider img = null;
		if(isScreenshotNeeded && !status.equalsIgnoreCase("INFO"))
		{
			
			String randomText = takeSnap();
			try {
				img = MediaEntityBuilder.createScreenCaptureFromPath
						("./../extent_test_output/screenshots/"+randomText+".jpg").build();
			} catch (IOException e) {
				
			}
			
		}
	
		if(status.equalsIgnoreCase("PASS"))
		{
			test.pass(desc, img);
		}
		else if(status.equalsIgnoreCase("FAIL"))
		{
			test.fail(desc,img);
			throw new RuntimeException();
		}
		
		
	}
	
	@AfterSuite
	public void flushTest()
	{
		extent.flush();
	}

}
