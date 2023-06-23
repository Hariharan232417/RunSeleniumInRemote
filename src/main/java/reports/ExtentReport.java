package reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import constants.FrameworkConstants;

public final class ExtentReport {

	private static ExtentReports extent;
	
	private static ExtentHtmlReporter reporter;
	
	public String testCaseName;
	public String testCaseDescription;
	

	private ExtentReport() {

	}

	public static void initReports() {
		if (Objects.isNull(extent)) {

			File f = new File("./extent_test_output");
			if(!f.mkdir())
			{
				reporter = new ExtentHtmlReporter("./report_output/extent.html");
			}
			
			//reporter.setAppendExisting(false); 
			extent = new ExtentReports();
			extent.attachReporter(reporter);
		}
	}

	public static void flushReports() throws IOException {
		if (Objects.nonNull(extent)) {
			extent.flush();
		}
	}

	public static void createTest(String testname) {
		
		ExtentManager.setExtentTest(extent.createTest(testname));
	}
}
