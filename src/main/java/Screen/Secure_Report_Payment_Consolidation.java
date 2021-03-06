package Screen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import configuration.Basesuit;

public class Secure_Report_Payment_Consolidation extends Basesuit
{
	/*****************************************************************/
	/*
	* This bellow constructor helps to call the Driver from Base Class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	WebDriver Driver;
	public Secure_Report_Payment_Consolidation(WebDriver driver)
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
	* These are the list of the WebElement for Transaction monitor report Screen.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	
	@FindBy(xpath="//img[@alt='Report' and @src='static/images/um/reports.png']")
	@CacheLookup
	WebElement Report;
	
	@FindBy(xpath="//img[@alt='Payment Consolidation' and @src='static/images/um/paymentConsolidationReport.png']")
	@CacheLookup
	WebElement PConsolidation;
	
	@FindBy(id="referenceId")
	@CacheLookup
	WebElement Refarenceno;
	
	@FindBy(xpath="//input[@value='Submit']")
	@CacheLookup
	WebElement Submit;
	
	@FindBy(xpath="//input[@value='Download Report']")
	@CacheLookup
	WebElement Downloadreport;
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
	public void Reportchk()
	{
		HighlightOnElement(Report);
		Report.click();
	}
	public void P_Consolidation()
	{
		HighlightOnElement(PConsolidation);
		PConsolidation.click();
	}
	public void Refarence_no(String Num)
	{
		HighlightOnElement(Refarenceno);
		Refarenceno.sendKeys(Num);
	}
	public void Search()
	{
		HighlightOnElement(Submit);
		Submit.click();
	}
	
	public void Download_report()
	{
		waitForPageLoad(Driver,Downloadreport);
		HighlightOnElement(Downloadreport);
		String str=Downloadreport.getAttribute("value");
		Assert.assertEquals(str, "Download Report");
		Downloadreport.click();
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
	public void Search_Report(String Num) throws Exception
	{
		Reportchk();
		waitForPageLoad(Driver,PConsolidation);
		P_Consolidation();
		waitForPageLoad(Driver,Refarenceno);
		Refarence_no(Num);
		Search();
		//Download_report();
		Thread.sleep(2000);	
		ScroolDown();
	}
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/
}
