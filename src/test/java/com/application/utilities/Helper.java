package com.application.utilities;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;


// screenshots, alerts, frames,  multi-windows, sysn issue, JS Executrer

public class Helper {
	
	public static String captureScreenshots(WebDriver driver) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath = System.getProperty("user.dir") + "/Screenshots/SS_" + getCurrentDateTime() + ".png" ;
		
		try {
			Files.copy(src.toPath(), new File(screenshotPath).toPath(), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Screenshot Captured");

		} catch (Exception e) {
			System.out.println("Unable to take screenshots " + e.getMessage());
		}
		
		return screenshotPath;
	}
	
	
	
	public static String getCurrentDateTime() {
		
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
	
	
	}

}
