package drivers;

import org.openqa.selenium.WebDriver;

public final class DriverManager {
	
	private static ThreadLocal<WebDriver> dr = new ThreadLocal();
	
	private DriverManager()
	{
		
	}
	
	public static void setDriver(WebDriver driverValue)
	{
		dr.set(driverValue);
	}
	
	public static WebDriver getDriver()
	{
		return dr.get();
	}
	
	public static void unload()
	{
		dr.remove();
	}

}
