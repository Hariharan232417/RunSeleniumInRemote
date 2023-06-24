package utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import com.github.javafaker.Faker;

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
	
	public static String getFirstName() {
		Faker faker = new Faker();

		String Firstname = faker.name().firstName();
		return Firstname;

	}

	public static String getLastName() {
		Faker faker = new Faker();

		String Lastname = faker.name().lastName();
		return Lastname;
	}
	public static String getCompanyName() {
		Faker faker = new Faker();

		String Company = faker.company().name();
		return Company;
	}

}
