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
	
	public static void captureScreenshots(WebDriver driver) {
		
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			Files.copy(src.toPath(), new File("./Screenshots/" + getCurrentDateTime() + ".png").toPath(), StandardCopyOption.REPLACE_EXISTING);
			System.out.println("Screenshot Captured");

		} catch (Exception e) {
			System.out.println("Unable to take screenshots " + e.getMessage());
		}
	}
	
	
	
	public static String getCurrentDateTime() {
		
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		
		Date currentDate = new Date();
		
		return customFormat.format(currentDate);
	
	
	}

}
