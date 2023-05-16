package utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GenericMethods {
	
	public static String getRandomString()
	{
		Date sampleDate = new Date(); // initialising the date object with the current date 
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyyyyhhmmss");
        String date = formatter.format(sampleDate);
        
        return date;
	}

}
