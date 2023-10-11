package com.neotech.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsReader {
	
	
	private static Properties prop;
/**
 * 
 * @param filePath
 */
	//no main method
	public static void readProperties(String filePath) {//filepath location oluyor
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(filePath);
			prop = new Properties();
			prop.load(fis);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * This method will return the value for a spesific key
	 * @param key String key
	 * @returnString valu
	 */
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
}	
