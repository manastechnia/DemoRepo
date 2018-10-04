package util;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import tvc.Login;


public class Screenshot {

	public static void TakeScreenshot() throws IOException{
		WebDriver driver=Login.driver;;
	File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);  
	
	FileUtils.copyFile(scrFile, new File("D://Selenium//FailedCases//screenshot"+System.currentTimeMillis()+".png"));
	
}
	
	public static String CreateFolderWithTimeStamp()
	
	{
	Date today = Calendar.getInstance().getTime();
	// (2) create our date "formatter" (the date format we want)
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-hh.mm.ss");
	// (3) create a new String using the date format we want
	String folderName = formatter.format(today);
	
	folderName = "c://" + folderName;
	//String filename = String.Format("archive_{0:yyyyMMdd}", DateTime.Today);
	File dir = new File(folderName);
	 // Tests whether the directory denoted by this abstract pathname exists.
	boolean exists = dir.exists();
	System.out.println("Directory " + dir.getPath() + " exists: " + exists);
	if (exists) {
	 System.out.println("Main Folder Exist");
	}
	else
	{
		System.out.println("Main Folder Doesnt Exist");
		File directory = new File(folderName);
		directory.mkdir();
	}
	
return folderName ;
}


}