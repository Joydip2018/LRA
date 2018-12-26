package Screen;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.Basesuit;

public class Secure_Courier extends Basesuit
{
	/*****************************************************************/
	/*
	* This bellow constructor helps to call the Driver from Base Class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	WebDriver Driver;
	public Secure_Courier(WebDriver driver)
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
	* These are the list of the WebElement for Secure Courier Tracking Number Screen.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	
	@FindBy(xpath="//img[@alt='Courier Details' and @src='static/images/um/courrrier.png']")
	@CacheLookup
	WebElement CourierDetails;
	
	@FindBy(xpath="//img[@alt='Update Courier Tracking Number' and @src='static/images/um/track.png']")
	@CacheLookup
	WebElement UpdateCourier;
	
	@FindBy(xpath="//label[contains(text(), 'Search')]//child::input")
	@CacheLookup
	WebElement Search;
	
	@FindBy(xpath="//tbody//tr[1]//a[contains(text(),'Update')]")
	@CacheLookup
	WebElement Updatecourier;
	
	@FindBy(id="courierId")
	@CacheLookup
	WebElement SelectServiceProvider;
	
	@FindBy(id="trackingID")
	@CacheLookup
	WebElement trackID;
	
	@FindBy(id="csdialog_close")
	@CacheLookup
	WebElement Savebtn;
	
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
	public void Courier_Details()
	{
		HighlightOnElement(CourierDetails);
		CourierDetails.click();
	}
	public void Update_Courier()
	{
		HighlightOnElement(UpdateCourier);
		UpdateCourier.click();
	}
	public void Search_ID(String ID)
	{
		HighlightOnElement(Search);
		Search.sendKeys(ID);
	}
	public void Update_courier()
	{
		HighlightOnElement(Updatecourier);
		Updatecourier.click();
	}
	public void SelectServiceProvider()
	{
		HighlightOnElement(SelectServiceProvider);
		Select SP=new Select(SelectServiceProvider);
		SP.selectByVisibleText("DHL Express");
	}
	public void trackID(String TID)
	{
		HighlightOnElement(trackID);
		trackID.sendKeys(TID);
	}
	public void Save_btn()
	{
		HighlightOnElement(Savebtn);
		Savebtn.click();
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
	* This base function used for create user.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	public void SecureCourier(String ID,String TID) throws Exception
	{
		
		WebDriverWait wait=new WebDriverWait(Driver, 20);
		waitForPageLoad(Driver,CourierDetails);
		Courier_Details();
		waitForPageLoad(Driver,UpdateCourier);
		Update_Courier();
		waitForPageLoad(Driver,Search);	
		Search_ID(ID);
		Actions action=new Actions(Driver);
		action.sendKeys(Keys.ENTER).build().perform();
		Update_courier();
		waitForPageLoad(Driver,SelectServiceProvider);
		SelectServiceProvider();
		trackID(TID);
		Save_btn();
		wait.until(ExpectedConditions.alertIsPresent());
		Driver.switchTo().alert().accept();
	}
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/
}
