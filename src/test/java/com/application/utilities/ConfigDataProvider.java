package com.application.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataProvider {
	
	Properties pro;
	
	public  ConfigDataProvider() {
		
		File src = new File("./Configs/Config.properties");
		
		try {
			FileInputStream fis = new FileInputStream(src);
			
			pro = new Properties();
	
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Unable to load config file >> " + e.getMessage());
		}
		
	}
	
	
	public String getDataFromConfig(String keyToSearch) {
		return pro.getProperty(keyToSearch);
	}
	
	public String getBrowser() {
		return pro.getProperty("Browser");
	}
	
	public String getqaUrl() {
		return pro.getProperty("qaUrl");
	}
	

}
