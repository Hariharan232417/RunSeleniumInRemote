package drivers;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import constants.FrameworkConstants;
import enums.ConfigProperties;
import utils.ReadPropertyFile;

public class Driver {
	
	
	
	public static void initDriver()
	{
		
		if(DriverManager.getDriver()==null)
		{
			System.setProperty("webdriver.chrome.driver", FrameworkConstants.getChromeDriverPath());
			ChromeOptions options = new ChromeOptions();

			options.addArguments("--remote-allow-origins=*");

			WebDriver driver= new ChromeDriver(options);
			
			DriverManager.setDriver(driver);
			
			try {
				DriverManager.getDriver().get(ReadPropertyFile.getValue(ConfigProperties.URL));
				
				DriverManager.getDriver().manage().window().maximize();
				DriverManager.getDriver().manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//"https://dev90659.service-now.com/"
			//Username: admin, Password: Ji0ghQPn1oHB
		}
	}
	
	public static void quitDriver()
	{
		if(DriverManager.getDriver()!=null)
		{
			DriverManager.getDriver().quit();
			DriverManager.unload();
		}
		
	}

}
