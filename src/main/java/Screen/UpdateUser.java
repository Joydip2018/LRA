package Screen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import configuration.Basesuit;

public class UpdateUser extends Basesuit
{

	/*****************************************************************/
	/*
	* This bellow constructor helps to call the Driver from Base Class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	WebDriver Driver;
	public UpdateUser(WebDriver driver)
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
	* These are the list of the WebElement for Update Citizen profile Screen.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@FindBy(xpath="//img[@alt='new registration' and @src='static/images/um/dormantuser.png']")
	@CacheLookup
	WebElement Updateprofile;
	
	@FindBy(id="mobileNumber")
	@CacheLookup
	WebElement MobileNo;

	@FindBy(id="email")
	@CacheLookup
	WebElement EmailID;
	
	@FindBy(id="shippingAddress")
	@CacheLookup
	WebElement shippingAdd;
	
	@FindBy(xpath="//input[@value='Update']")
	@CacheLookup
	WebElement Update;
	
	@FindBy(id="submitctc_dialog_submit")
	@CacheLookup
	WebElement Confirm;

	@FindBy(id="closeReq")
	@CacheLookup
	WebElement No;
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
	public void Update_profileLink()
	{
		HighlightOnElement(Updateprofile);
		Updateprofile.click();
	}
	public void Mobile_Number(String Mobile)
	{
		HighlightOnElement(MobileNo);
		MobileNo.clear();
		MobileNo.sendKeys(Mobile);
	}
	public void Email_ID(String Email)
	{
		HighlightOnElement(EmailID);
		EmailID.clear();
		EmailID.sendKeys(Email);
	}
	public void shipping_Add(String Address)
	{
		HighlightOnElement(shippingAdd);
		shippingAdd.clear();
		shippingAdd.sendKeys(Address);
	}
	public void Update_btn()
	{
		HighlightOnElement(Update);
		Update.click();
	}
	public void Confirm_btn()
	{
		HighlightOnElement(Confirm);
		Confirm.click();
	}
	public void No_btn()
	{
		HighlightOnElement(No);
		No.click();
	}
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/
	
	/*****************************************************************/
	/*
	* This base function used for Update Citizen Profile.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	public void Update_profile(String Mobile, String Email, String Address)
	{
		Update_profileLink();
		waitForPageLoad(Driver,MobileNo);
		Mobile_Number(Mobile);
		Email_ID(Email);
		shipping_Add(Address);
		Update_btn();
		Confirm_btn();
		Driver.switchTo().alert().accept();
	}
	
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/
	
}
