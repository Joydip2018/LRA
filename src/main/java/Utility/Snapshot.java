package Utility;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Snapshot
{	
	/*****************************************************************/
	/*
	* This bellow screenshot function taking the argument from Listner class.
	* @author Joydip.Bhattacharjee
	*/
	/**
	 * @return ***************************************************************/
	public static String takescreen(String imagename, WebDriver driver) throws Exception
	{
		TakesScreenshot Screen=(TakesScreenshot)driver;
		File source= Screen.getScreenshotAs(OutputType.FILE);
		File DestFile=new File("./Screenshot/"+imagename+".png");
		FileUtils.copyFile(source, DestFile);
		String path1="/"+imagename+".png";
		return path1;
	}
}
