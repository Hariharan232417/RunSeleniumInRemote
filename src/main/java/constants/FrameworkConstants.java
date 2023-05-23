package constants;

import enums.ConfigProperties;
import utils.ReadPropertyFile;

public final class FrameworkConstants {
	
	private FrameworkConstants()
	{
		
	}
	
	
	private static final String RESOURCESPATH ="src/test/resources";
	private static final String CHROMEDRIVERPATH =RESOURCESPATH+"/executables/chromedriver.exe";
	private static final String CONFIGFILEPATH =RESOURCESPATH+"/config/config.properties";
	private static final int EXPLICITWAIT = 30;
	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/report_output";
	private static String extentReportFilePath = "";
	
	public static String getExtentReportFilePath() throws Exception {
		if(extentReportFilePath.isEmpty())
		{
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}
	
	private static String createReportPath() throws Exception
	{
		if(ReadPropertyFile.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no"))
		{
			return EXTENTREPORTFOLDERPATH+"/"+System.currentTimeMillis()+"/index.html";
		}
		else
		{
			return EXTENTREPORTFOLDERPATH+"/"+"index.html";
		}
	}

	

	public static String getChromeDriverPath()
	{
		return CHROMEDRIVERPATH;
	}
	
	public static String getConfigFilePath()
	{
		return CONFIGFILEPATH;
	}
	

	public static int getExplicitWait()
	{
		return EXPLICITWAIT;
	}

}
