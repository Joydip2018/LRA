package Screen;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import configuration.Basesuit;

public class NewCertificate extends Basesuit
{
	/*****************************************************************/
	/*
	* This bellow constructor helps to call the Driver from Base Class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	WebDriver Driver;
	public NewCertificate(WebDriver driver)
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
	* These are the list of the WebElement for Citizen New Certificate request Screen.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@FindBy(xpath="//img[@alt='new registration' and @src='static/images/um/new_request.png']")
	@CacheLookup
	WebElement Newcertificate;
	
	@FindBy(id="rd")
	@CacheLookup
	WebElement Deed;
	
	@FindBy(id="titleType")
	@CacheLookup
	WebElement TitleType;
	
	@FindBy(id="titleNumber")
	@CacheLookup
	WebElement TitleNum;
	
	@FindBy(id="noOfcopies")
	@CacheLookup
	WebElement Copies;
	
	@FindBy(id="addbutton")
	@CacheLookup
	WebElement Add;	
	
	@FindBy(id="dialog_submit")
	@CacheLookup
	WebElement Confirm;	
	
	@FindBy(id="submitbutton")
	@CacheLookup
	WebElement SubmitRequst;
	
	@FindBy(id="submitctc_dialog_submit")
	@CacheLookup
	WebElement ConfirmRequest;	
	
	@FindBy(id="bankClose1")
	@CacheLookup
	WebElement Close;
	
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
	public void New_certificate()
	{
		HighlightOnElement(Newcertificate);
		Newcertificate.click();
	}
	public void Select_Deed()
	{	
		HighlightOnElement(Deed);
		Select selectdeed= new Select(Deed);
		selectdeed.selectByVisibleText("Quezon City");
	}
	public void Select_TitleType()
	{
		HighlightOnElement(TitleType);
		Select selecttitle=new Select(TitleType);
		selecttitle.selectByVisibleText("Transfer Certificate of Title");
	}
	public void Title_number(String num)
	{
		HighlightOnElement(TitleNum);
		TitleNum.sendKeys(num);
	}
	public void No_Copies(String Copy)
	{
		HighlightOnElement(Copies);
		Copies.sendKeys(Copy);
	}
	public void Add_Deed()
	{
		HighlightOnElement(Add);
		Add.click();
	}
	public void Confirm_Deed()
	{
		HighlightOnElement(Confirm);
		Confirm.click();
	}
	public void Submit_Requst()
	{
		HighlightOnElement(SubmitRequst);
		SubmitRequst.click();
	}
	public void Confirm_Request()
	{
		HighlightOnElement(ConfirmRequest);
		ConfirmRequest.click();
	}
	public void Close_Bank_Details()
	{
		HighlightOnElement(Close);
		Close.click();
	}
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/
	
	/*****************************************************************/
	/*
	* This base function used for give new deed request.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	public void Certificate(String num, String Copy) throws Exception
	{
		New_certificate();
		waitForPageLoad(Driver,Deed);
		Select_Deed();
		Select_TitleType();
		Title_number(num);
		No_Copies(Copy);
		Add_Deed();
		waitForPageLoad(Driver,Confirm);
		Confirm_Deed();
		waitForPageLoad(Driver,SubmitRequst);
		Submit_Requst();
		waitForPageLoad(Driver,ConfirmRequest);
		Confirm_Request();
	}
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/
	
}
