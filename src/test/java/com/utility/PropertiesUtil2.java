package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil2 {

	public static String readProperty(Env env,String property) {
		File propFile = new File(System.getProperty("user.dir") + "\\config\\" + env+ ".properties");
		Properties prop = new Properties();
		FileReader filereader = null;

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
		String urlname = prop.getProperty(property);// toUppercase becoz in config file we have stored URL in
		return urlname;											// caps
		

	}
	
	

	
}
