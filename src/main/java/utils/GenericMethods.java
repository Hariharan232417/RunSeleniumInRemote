package utils;

import java.text.SimpleDateFormat;
import java.util.*;

import pages.Leaftaps_LeadNewRecordPage;

public class GenericMethods {

	public static String getRandomString() {
		Date sampleDate = new Date(); // initialising the date object with the current date
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMMyyyyhhmmss");
		String date = formatter.format(sampleDate);

		return date;
	}

	public static String generateRandomString(int len) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
		sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}

	public static String generateRandomNumber(int len) {
		String chars = "0123456789";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
		sb.append(chars.charAt(rnd.nextInt(chars.length())));
		return sb.toString();
	}
	
	public static String extractNumber(String text)
	{
		
//		String str = "sfdsfddfdsf (15115)";
		
//		String[] arrstring = str.split("(");
//		String num = arrstring[1].split(")")[0];
		String res = text.replaceAll("[^0-9]", "");
	
		return res;
	}

}
