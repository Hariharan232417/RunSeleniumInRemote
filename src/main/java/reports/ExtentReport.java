package reports;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import constants.FrameworkConstants;

public final class ExtentReport {

	private static ExtentReports extent;


	private ExtentReport() {

	}

	public static void initReports() {
		if (Objects.isNull(extent)) {

			extent = new ExtentReports();

			ExtentSparkReporter spark=null;
			try {
				spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("SerVice Now Testing Report");

			spark.config().setReportName("SerVice Now Testing Report");
		}
	}

	public static void flushReports() throws IOException {
		if (Objects.nonNull(extent)) {
			extent.flush();
			try {
				Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void createTest(String testname) {

		ExtentManager.setExtentTest(extent.createTest(testname));
	}
}
