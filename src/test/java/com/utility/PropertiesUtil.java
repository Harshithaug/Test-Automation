package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	public static String readProperty(Env env, String url) {
		File propFile = new File(System.getProperty("user.dir") + "\\config\\" + env + ".properties");
		FileReader filereader = null;
		Properties prop = new Properties();
		try {
			filereader = new FileReader(propFile);
			prop.load(filereader);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String urlname = prop.getProperty(url.toUpperCase()); // toUppercase becoz in config file we have stored URL in
																// caps
		return urlname;
	}

}
