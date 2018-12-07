package Screen;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.Basesuit;

public class Login extends Basesuit
{
	/*****************************************************************/
	/*
	* This bellow constructor helps to call the Driver from Base Class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	WebDriver Driver;
	public Login(WebDriver driver)
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
	* These are the list of the WebElement for Citizen page Login Screen.
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
	
	@FindBy(id="loginsuccess")
	@CacheLookup
	WebElement LoginBtn;
	
	@FindBy(id="logincontinue")
	@CacheLookup
	WebElement Continue;
	
	@FindBy(xpath="//a[contains(text(),'User Dashboard')]")
	@CacheLookup
	WebElement Dashboard;
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
	public void Dashboard_click() 
	{			
		HighlightOnElement(Dashboard);
		Dashboard.click();
	}
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/
	
	/*****************************************************************/
	/*
	* This base function used for login user.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	public void logintest(String Uname, String Pwd) throws Exception 
	{
		WebDriverWait wait=new WebDriverWait(Driver, 10);
		login_link();
		//wait.until(ExpectedConditions.visibilityOfAllElements(LoginID));
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
		wait.until(ExpectedConditions.visibilityOfAllElements(Continue));
		if(Continue.isDisplayed())
		{
			Continue_click();
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
