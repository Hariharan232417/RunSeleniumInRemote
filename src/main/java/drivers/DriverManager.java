package drivers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public final class DriverManager {
	
	private static ThreadLocal<RemoteWebDriver> dr = new ThreadLocal();
	
	private DriverManager()
	{
		
	}
	
	public static void setDriver(RemoteWebDriver driverValue)
	{
		dr.set(driverValue);
	}
	
	public static RemoteWebDriver getDriver()
	{
		return dr.get();
	}
	
	public static void unload()
	{
		dr.remove();
	}

}
