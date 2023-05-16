package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import constants.FrameworkConstants;

public final class ReadPropertyFile {
	
	private static Properties prop = new Properties();
	private static final Map<String,String> CONFIGMAP = new HashMap();
	
	private ReadPropertyFile()
	{
		
	}
	
	static {
		FileInputStream fip;
		try {
			 fip = new FileInputStream(FrameworkConstants.getConfigFilePath());
			 
			 prop.load(fip);
			 
			 for(Map.Entry<Object,Object> entry: prop.entrySet()) {
				 CONFIGMAP.put(entry.getKey().toString(), entry.getValue().toString().trim());
			 }
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
		catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
	}
	
	public  static String getValue(enums.ConfigProperties key) throws Exception
	{
		
		if(prop.getProperty(key.name().toLowerCase())==null)
		{
			throw new Exception("Property name is not found");
		}
		
	
		return CONFIGMAP.get(key.name().toLowerCase());
	}

}
