package Screen;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import configuration.Basesuit;

public class MyRequest_Makepayment extends Basesuit
{
	/*****************************************************************/
	/*
	* This bellow constructor helps to call the Driver from Base Class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	WebDriver Driver;
	public MyRequest_Makepayment(WebDriver driver)
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
	* These are the list of the WebElement for Citizen page payment Screen.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@FindBy(xpath="//img[@alt='new registration' and @src='static/images/um/all_request.png']")
	@CacheLookup
	WebElement MyRequest;
	
	@FindBy(xpath="//label[contains(text(), 'Search')]//child::input")
	@CacheLookup
	WebElement Search;
	
	@FindBy(xpath="//a[contains(text(),'Payment')]")
	@CacheLookup
	WebElement makepaymentlink;
	
	@FindBy(id="bankID")
	@CacheLookup
	WebElement Bankname;
	
	//@FindBy(xpath="//div[@id='bankModal']//button[@id='csdialog_close']")
	@FindBy(xpath="//button[@id='paymentModel']")
	@CacheLookup
	WebElement Processbtn;
	
	@FindBy(id="pan")
	@CacheLookup
	WebElement CardNumber;
	
	@FindBy(id="cvv2")
	@CacheLookup
	WebElement CVV2Number;
	
	@FindBy(id="expiryDateMonth")
	@CacheLookup
	WebElement Month;
	
	@FindBy(id="expiryDateYear")
	@CacheLookup
	WebElement Year;
	
	@FindBy(id="submitButton")
	@CacheLookup
	WebElement Submitbtn;
	
	@FindBy(xpath="//img[@src='static/images/gateway/no-success-icon.png']")
	@CacheLookup
	WebElement nosuccess;
	
	@FindBy(xpath="//a[contains(.,'here')]")
	@CacheLookup
	WebElement Clickhere;
	
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
	public void MyRequest()
	{
		HighlightOnElement(MyRequest);
		MyRequest.click();
	}
	public void Search(String Svelue)
	{
		HighlightOnElement(Search);
		Search.sendKeys(Svelue);
	}
	public void makepayment_link()
	{
		HighlightOnElement(makepaymentlink);
		makepaymentlink.click();
	}
	public void Bank_name()
	{
		HighlightOnElement(Bankname);
		Select SB=new Select(Bankname);
		SB.selectByVisibleText("Development Bank of the Philippines");
	}
	public void Process_btn()
	{
		HighlightOnElement(Processbtn);
		Processbtn.click();
	}
	public void Card_Number(String Crdno)
	{
		HighlightOnElement(CardNumber);
		CardNumber.sendKeys(Crdno);
	}
	public void CVV2_Number(String CVV)
	{
		HighlightOnElement(CVV2Number);
		CVV2Number.sendKeys(CVV);;
	}
	public void EMonth()
	{
		HighlightOnElement(Month);
		Select SB=new Select(Month);
		SB.selectByVisibleText("05");
	}
	public void EYear()
	{
		HighlightOnElement(Year);
		Select SB=new Select(Year);
		SB.selectByVisibleText("2022");
	}
	public void Submit_btn()
	{
		HighlightOnElement(Submitbtn);
		Submitbtn.click();
	}
	
	public void no_success()
	{
		try
		{
		boolean x=nosuccess.isDisplayed();
		if(x==true)
		{
			WebDriverWait wait=new WebDriverWait(Driver, 10);
			wait.until(ExpectedConditions.visibilityOfAllElements(nosuccess));
			if(nosuccess.isDisplayed())
			{
				HighlightOnElement(nosuccess);	
				Assert.assertFalse(true);
			}
		}
		}
		catch(NoSuchElementException e)
		{
			System.out.println("Go for Next Step");
		}
	}
	public void Click_here()
	{
		HighlightOnElement(Clickhere);
		Clickhere.click();
	}
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/
	
	/*****************************************************************/
	/*
	* This bellow base functions used for make a successful payment .
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	public void Search_Item(String Svelue)
	{
		MyRequest();
		waitForPageLoad(Driver,Search);
		Search(Svelue);
		Actions action = new Actions(Driver); 
		action.sendKeys(Keys.ENTER).build().perform();
	}
	public void makepayment(String Crdno, String CVV) throws Exception
	{
		makepayment_link();
		waitForPageLoad(Driver,Bankname);
		Bank_name();
		waitForPageLoad(Driver,Processbtn);
		Process_btn();
		/*Card_Number(Crdno);
		CVV2_Number(CVV);
		EMonth();
		EYear();
		Submit_btn();*/
		
	}
	/*****************************************************************/
	/*
	*  End
	*/
	/*****************************************************************/
}
