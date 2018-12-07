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

public class Secure_UpdatecourierStatus extends Basesuit
{
	/*****************************************************************/
	/*
	* This bellow constructor helps to call the Driver from Secure_Base Class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	WebDriver Driver;
	public Secure_UpdatecourierStatus(WebDriver driver)
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
	* These are the list of the WebElement for Secure Courier status Screen.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@FindBy(xpath="//img[@alt='Courier Details' and @src='static/images/um/courrrier.png']")
	@CacheLookup
	WebElement CourierDetails;
	
	@FindBy(xpath="//img[@alt='Update Courier Status' and @src='static/images/um/courrrier.png']")
	@CacheLookup
	WebElement UpdateCourierStatus;
	
	@FindBy(xpath="//label[contains(text(), 'Search')]//child::input")
	@CacheLookup
	WebElement Search;
	
	@FindBy(xpath="//a[contains(text(),'Update')]")
	@CacheLookup
	WebElement UpdateStatus;
	
	@FindBy(id="courStatus")
	@CacheLookup
	WebElement courierStatus;
	
	@FindBy(id="csdialog_close")
	@CacheLookup
	WebElement Update;
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
	public void Update_Courier_Status()
	{
		HighlightOnElement(UpdateCourierStatus);
		UpdateCourierStatus.click();
	}
	public void Search_ID(String ID)
	{
		HighlightOnElement(Search);
		Search.sendKeys(ID);
	}
	public void Update_Status()
	{
		HighlightOnElement(UpdateStatus);
		UpdateStatus.click();
	}
	public void cour_Status()
	{
		HighlightOnElement(courierStatus);
		Select CS=new Select(courierStatus);
		CS.selectByVisibleText("Delivered to Client");
	}
	public void Update_btn()
	{
		HighlightOnElement(Update);
		Update.click();
	}
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/
	
	/*****************************************************************/
	/*
	* This base function used for update courier status
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	public void UpdateCorier_status(String ID) throws Exception
	{
		WebDriverWait wait=new WebDriverWait(Driver, 20);
		waitForPageLoad(Driver,CourierDetails);
		Courier_Details();
		waitForPageLoad(Driver,UpdateCourierStatus);
		Update_Courier_Status();
		waitForPageLoad(Driver,Search);
		Search_ID(ID);
		Actions action=new Actions(Driver);
		action.sendKeys(Keys.ENTER).build().perform();
		Update_Status();
		cour_Status();
		Update_btn();
		wait.until(ExpectedConditions.alertIsPresent());
		Driver.switchTo().alert().accept();
	}
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/
}
