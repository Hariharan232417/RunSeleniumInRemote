package reports;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;

import drivers.DriverManager;
import enums.ConfigProperties;
import utils.ReadPropertyFile;

public final class ExtentLogger {

	private ExtentLogger() {

	}

	public static void pass(String message) {
		ExtentManager.getExtentTest().pass(message);
	}

	public static void fail(String message) {
		ExtentManager.getExtentTest().fail(message);
	}

	public static void skip(String message) {
		ExtentManager.getExtentTest().skip(message);
	}

	public static void reportStep(String message, String status, boolean isScreenshotNeeded) {

		MediaEntityModelProvider img = null;
		if (isScreenshotNeeded && !status.equalsIgnoreCase("INFO")) {

			img = takeSnap();

		}

		if (status.equalsIgnoreCase("PASS")) {
			ExtentManager.getExtentTest().pass(message, img);
		} else if(status.equalsIgnoreCase("FAIL")) {
			ExtentManager.getExtentTest().fail(message, img);
		}

	}

	public static MediaEntityModelProvider takeSnap() {
		MediaEntityModelProvider img = null;
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("ddMMYYYYHHmmSS");

		String randomNumber = format.format(date);

		try {
			FileUtils.copyFile(((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.FILE),
					new File("./report_output/screenshots/" + randomNumber + ".jpg"));
		} catch (WebDriverException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			img = MediaEntityBuilder
					.createScreenCaptureFromPath("./../report_output/screenshots/" + randomNumber + ".jpg").build();
		} catch (IOException e) {

		}
		
		return img;
		
	}
	
	public static void fail(String message, boolean isScreenshotNeeded) throws Exception {
		if (ReadPropertyFile.getValue(ConfigProperties.SKIPPEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotNeeded)
			ExtentManager.getExtentTest().fail(message,takeSnap());
		else
			fail(message);
	}


	public static void skip(String message, boolean isScreenshotNeeded) throws Exception {
		if (ReadPropertyFile.getValue(ConfigProperties.SKIPPEDSTEPSCREENSHOTS).equalsIgnoreCase("yes")
				&& isScreenshotNeeded)
			ExtentManager.getExtentTest().skip(message,takeSnap());
		else
			skip(message);
	}

	public static String getBase64Image() {
		return ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BASE64);
	}
}
