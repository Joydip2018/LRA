package LTCPS.Project;

import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import Screen.RegVerification;
import Screen.SetPasswprd;
import configuration.configreaderclass;

public class RegVerificationtest 
{
	WebDriver Driver;
	@Test(enabled=false)
	public void Verificationtest() throws Exception
	{
		configreaderclass BC=new configreaderclass();
		String[] str3=BC.configreader();
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		Driver = new ChromeDriver();
		Driver.manage().window().maximize();
		Driver.get(str3[4]);
		RegVerification GL= new RegVerification();
		GL.Glogin(str3[5], str3[6], Driver);
		String Parent=Driver.getWindowHandle();
		//System.out.println(Parent);
		Set<String> allwindow=Driver.getWindowHandles();
		//int count=allwindow.size();
		//System.out.println(count);
		for(String child:allwindow)
		{
			if(!Parent.equalsIgnoreCase(child))
			{
				Driver.switchTo().window(child);
				SetPasswprd SP=new SetPasswprd();
				SP.Save_password("Joydip@123", "Joydip@123", Driver);
			}
		}
		
		
	}
}
