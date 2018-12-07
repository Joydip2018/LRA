package Screen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import configuration.Basesuit;

public class Transection_monitor extends Basesuit
{
	/*****************************************************************/
	/*
	* This bellow constructor helps to call the Driver from Base Class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	WebDriver Driver;
	public Transection_monitor(WebDriver driver)
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
	* These are the list of the WebElement for Transaction monitor Screen.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@FindBy(xpath="//img[@alt='Transaction Monitoring' and @src='static/images/um/rep.png']")
	@CacheLookup
	WebElement Tmonitor;
	
	@FindBy(id="referenceId")
	@CacheLookup
	WebElement Refarenceno;
	
	@FindBy(xpath="//input[@value='Search']")
	@CacheLookup
	WebElement Search;
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
	public void T_monitor()
	{
		HighlightOnElement(Tmonitor);
		Tmonitor.click();
	}
	public void Refarence_no(String Num)
	{
		HighlightOnElement(Refarenceno);
		Refarenceno.sendKeys(Num);
	}
	public void Search()
	{
		HighlightOnElement(Search);
		Search.click();
	}
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/
	
	/*****************************************************************/
	/*
	* This base function used for search Transaction.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	public void Search_Transaction(String Num) throws Exception
	{
		T_monitor();
		waitForPageLoad(Driver,Refarenceno);
		Refarence_no(Num);
		Search();
		Thread.sleep(2000);
		
	}
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/
}
