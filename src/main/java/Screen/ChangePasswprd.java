package Screen;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.Basesuit;

public class ChangePasswprd extends Basesuit
{
	/*****************************************************************/
	/*
	* This bellow constructor helps to call the Driver from Base Class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	WebDriver Driver;
	public ChangePasswprd(WebDriver driver)
	{
		this.Driver=driver;
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	
	/*****************************************************************/
	/*
	* These are the list of the WebElement for Citizen page Change Password Screen.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@FindBy(linkText="Change Password")
	@CacheLookup
	WebElement ChangepassLink;
	
	@FindBy(id="old_password")
	@CacheLookup
	WebElement OldPwd;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement Pwd;
	
	@FindBy(id="re_password")
	@CacheLookup
	WebElement Repwd;
	
	@FindBy(xpath="//input[@value='Change Password']")
	@CacheLookup
	WebElement Changepass;
	/*************************************************************/
	/*
	*  End
	*/
	/*************************************************************/
	
	/*****************************************************************/
	/*
	* These bellow functions take the reference of above WebElements.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	public void Change_passLink()
	{
		HighlightOnElement(ChangepassLink);
		ChangepassLink.click();
	}
	public void Old_Pwd(String Opass)
	{
		HighlightOnElement(OldPwd);
		OldPwd.sendKeys(Opass);
	}
	public void password(String pass)
	{
		HighlightOnElement(Pwd);
		Pwd.sendKeys(pass);
	}
	public void Repassword(String Repass)
	{
		HighlightOnElement(Repwd);
		Repwd.sendKeys(Repass);
	}
	public void Change_pass()
	{
		HighlightOnElement(Changepass);
		Changepass.click();
	}
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/
	
	/*****************************************************************/
	/*
	* This base functions updating the password.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	public void Change_password(String Opass, String pass,String Repass,WebDriver Driver) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(Driver, 20);
		Change_passLink();
		waitForPageLoad(Driver,OldPwd);
		Old_Pwd(Opass);
		password(pass);
		Repassword(Repass);
		JavascriptExecutor JS=(JavascriptExecutor)Driver;
		JS.executeScript("alert('Please enter the Capcha, This screen will hold for 20 Seconds only...')");
		Thread.sleep(20000);
		Change_pass();
		wait.until(ExpectedConditions.alertIsPresent());
		Driver.switchTo().alert().accept();
	}
	/*************************************************************/
	/*
	*  End
	*/
	/*************************************************************/
}
