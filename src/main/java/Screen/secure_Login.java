package Screen;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import configuration.Basesuit;

public class secure_Login extends Basesuit
{
	/*****************************************************************/
	/*
	* This bellow constructor helps to call the Driver from Base Class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	WebDriver Driver;
	public secure_Login(WebDriver driver)
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
	* These are the list of the WebElement for Secure Login Screen.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@FindBy(xpath="//li[contains(text(),'LOGIN')]")
	@CacheLookup
	WebElement Loginink;
	
	@FindBy(id="username")
	@CacheLookup
	WebElement LoginID;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement Password;
	
	@FindBy(xpath="//input[@value='Login']")
	@CacheLookup
	WebElement LoginBtn;
	
	@FindBy(id="logincontinue")
	@CacheLookup
	WebElement Continue;
	
	/*@FindBy(xpath="//a[contains(text(),'Welcome')]")
	@CacheLookup
	WebElement LoginChk;*/
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
	public void login_link()
	{
		HighlightOnElement(Loginink);
		Loginink.click();
	}
	public void loginUname(String Uname) 
	{	
		HighlightOnElement(LoginID);
		LoginID.sendKeys(Uname);	
	}
	public void loginPwd(String Pwd) 
	{	
		HighlightOnElement(Password);
		Password.sendKeys(Pwd);
	}
	public void loginclick() 
	{		
		HighlightOnElement(LoginBtn);
		LoginBtn.click();
	}
	public void Continue_click() 
	{			
		HighlightOnElement(Continue);
		Continue.click();
	}
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/
	
	/*****************************************************************/
	/*
	* This base function used for login into site.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	public void logintest(String Uname, String Pwd) throws Exception 
	{
		login_link();
		waitForPageLoad(Driver,LoginID);
		loginUname(Uname);
		loginPwd(Pwd);
		JavascriptExecutor JS=(JavascriptExecutor)Driver;
		JS.executeScript("alert('Please enter the Capcha, This screen will hold for 20 Seconds only...')");
		Thread.sleep(20000);
		loginclick();
		try
		{
		boolean x=LoginBtn.isDisplayed();
		if(x==false)
		{
		waitForPageLoad(Driver,Continue);
		if(Continue.isDisplayed())
		{
			Continue_click();
			Thread.sleep(2000);
		}
		}
		}
		catch(StaleElementReferenceException e)
		{
			System.out.println("Go for Next Step");
		}
		
	}
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/

}
