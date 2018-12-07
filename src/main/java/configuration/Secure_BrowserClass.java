package configuration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Secure_BrowserClass
{
	/*****************************************************************/
	/*
	* This bellow function helps to open the Browser.
	* It's taking the Secure site url from configreaderclass.java and return the driver.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	public static WebDriver BrowserDetails(String browser,WebDriver Driver) throws Exception
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			//create chrome instance
			System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
			Driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			//create firefox instance
			System.setProperty("webdriver.gecko.driver", "./Driver/geckodriver.exe");
			Driver = new FirefoxDriver();
		}
		configreaderclass BC=new configreaderclass();
		String[] str=BC.configreader();
		Driver.get(str[7]);
		Driver.manage().window().maximize();
		return Driver;
		/*****************************************************************/
		/*
		* End
		*/
		/*****************************************************************/
	}
}
