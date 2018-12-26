package Screen;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.Basesuit;

public class Secure_PrintCertificate extends Basesuit
{
	/*****************************************************************/
	/*
	* This bellow constructor helps to call the Driver from Secure_Base Class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	WebDriver Driver;
	public Secure_PrintCertificate(WebDriver driver)
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
	* These are the list of the WebElement for Secure Truecopy Screen.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@FindBy(xpath="//img[@alt='new registration' and @src='static/images/um/all_request.png']")
	@CacheLookup
	WebElement CertificateTrueCopy;
	
	@FindBy(xpath="//label[contains(text(), 'Search')]//child::input")
	@CacheLookup
	WebElement Search;
	
	@FindBy(xpath="//a[contains(text(),'View Details')]")
	@CacheLookup
	WebElement ViewDetails;
	
	@FindBy(id="updatebutton")
	@CacheLookup
	WebElement Validate;
	
	@FindBy(id="addbutton")
	@CacheLookup
	WebElement Print;
	
	@FindBy(xpath="//a[contains(.,'Dashboard')]")
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
	public void Certificate_TrueCopy()
	{
		HighlightOnElement(CertificateTrueCopy);
		CertificateTrueCopy.click();
	}
	public void Search_ID(String ID)
	{
		HighlightOnElement(Search);
		Search.sendKeys(ID);
	}
	public void View_Details()
	{
		HighlightOnElement(ViewDetails);
		ViewDetails.click();
	}
	public void Validate_btn()
	{
		HighlightOnElement(Validate);
		Validate.click();
	}
	public void Print_btn()
	{
		HighlightOnElement(Print);
		Print.click();
	}
	
	public void Dashboard_link()
	{
		waitForPageLoad(Driver, Dashboard);
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
	* This base function used for print certificate for Users.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	public void Search_Transaction(String ID) throws Exception
	{
		
		WebDriverWait wait=new WebDriverWait(Driver, 20);
		waitForPageLoad(Driver,CertificateTrueCopy);
		Certificate_TrueCopy();
		waitForPageLoad(Driver,Search);
		Search_ID(ID);
		Actions action=new Actions(Driver);
		action.sendKeys(Keys.ENTER).build().perform();
		View_Details();
		Validate_btn();
		wait.until(ExpectedConditions.alertIsPresent());
		Driver.switchTo().alert().accept();
		Print_btn();
		wait.until(ExpectedConditions.alertIsPresent());
		Driver.switchTo().alert().accept();
	}
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/
}
