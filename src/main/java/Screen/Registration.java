package Screen;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.Basesuit;

public class Registration extends Basesuit
{
	/*****************************************************************/
	/*
	* These are the list of the WebElement for Registration Screen.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	By Registr=By.linkText("REGISTER");
	By FirstName=By.id("firstName");
	By MiddleName=By.id("middleName");
	By LastName=By.id("lastName");
	By DOB=By.id("dateOfBirth");
	By Month=By.xpath("//select[@class='ui-datepicker-month']");
	By Year=By.xpath("//select[@class='ui-datepicker-year']");
	By Calendar=By.xpath("//div[@id='ui-datepicker-div']//tbody//td");
	By Gender=By.id("gender");
	By ShippingAdd=By.id("ShippingAddress");
	By UserName=By.id("userName");	
	By Password=By.id("password");
	By CPassword=By.id("confirmPassword");	
	//By SecurityQsn=By.id("secQuestionId");
	//By SecurityAns=By.id("secAnswer");
	By MobileNumber=By.id("mobileNumber");
	By EmailId=By.id("email");
	By Agree=By.id("termsConditionchxbx1");
	By Submit=By.xpath("//input[@value='Submit']");
	By Confirm=By.id("dialog_submit");
	
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
	
	public void Registr_Btn(WebDriver Driver)
	{
		WebElement WRegistr=Driver.findElement(Registr);
		HighlightOnElement(WRegistr);
		WRegistr.click();
	}
	public void First_Name(String Fname, WebDriver Driver)
	{
		WebElement WFirstName=Driver.findElement(FirstName);
		HighlightOnElement(WFirstName);
		WFirstName.sendKeys(Fname);
	}
	public void Middle_Name(String Mname, WebDriver Driver)
	{
		WebElement WMiddleName=Driver.findElement(MiddleName);
		HighlightOnElement(WMiddleName);
		WMiddleName.sendKeys(Mname);
	}
	public void Last_Name(String Lname, WebDriver Driver)
	{
		WebElement WLastName =Driver.findElement(LastName);
		HighlightOnElement(WLastName);
		WLastName.sendKeys(Lname);
	}
	public void DateOfBirth(WebDriver Driver) throws InterruptedException
	{
		WebElement WDOB =Driver.findElement(DOB);
		HighlightOnElement(WDOB);
		Driver.findElement(DOB).click();
		WebDriverWait Wait=new WebDriverWait(Driver, 20);
		Wait.until(ExpectedConditions.visibilityOfElementLocated(Year));
		Select Syear=new Select(Driver.findElement(Year));
		Syear.selectByVisibleText("1988");
		Wait.until(ExpectedConditions.visibilityOfElementLocated(Month));
		Select Smonth=new Select(Driver.findElement(Month));
		Smonth.selectByVisibleText("Dec");
		Thread.sleep(2000);
		List<WebElement> Daylist= Driver.findElements(Calendar);
		int Count= Daylist.size();
		for (int j=0; j<Count; j++)
		{
			String Date= Daylist.get(j).getText();
			if(Date.equalsIgnoreCase("18"))
			{
				Daylist.get(j).click();
				break;				
			}
		}		
	}
	public void Gender(WebDriver Driver)
	{
		WebElement WGender =Driver.findElement(Gender);
		HighlightOnElement(WGender);
		Select Sex=new Select(Driver.findElement(Gender));
		Sex.selectByVisibleText("Male");
	}
	public void Shipping_Address(String Add, WebDriver Driver)
	{
		WebElement WGender =Driver.findElement(ShippingAdd);
		HighlightOnElement(WGender);
		WGender.sendKeys(Add);
	}
	public void User_Name(String Uname, WebDriver Driver)
	{
		WebElement WUserName =Driver.findElement(UserName);
		HighlightOnElement(WUserName);
		WUserName.sendKeys(Uname);
	}	
	
	public void Pass_word(String pass, WebDriver Driver)
	{
		WebElement WPassword =Driver.findElement(Password);
		HighlightOnElement(WPassword);
		WPassword.sendKeys(pass);
	}
	public void C_Password(String Cpass, WebDriver Driver)
	{
		WebElement WCPassword =Driver.findElement(CPassword);
		HighlightOnElement(WCPassword);
		WCPassword.sendKeys(Cpass);
	}	
	/*public void Security_Qsn(WebDriver Driver)
	{
		Select Qsn=new Select(Driver.findElement(SecurityQsn));
		Qsn.selectByVisibleText("What was your childhood nickname?");
	}
	public void Security_Ans(String Ans, WebDriver Driver)
	{
		Driver.findElement(SecurityAns).sendKeys(Ans);
	}*/
	
	public void Mobile_Number(String Mobile, WebDriver Driver)
	{
		WebElement WMobileNumber =Driver.findElement(MobileNumber);
		HighlightOnElement(WMobileNumber);
		WMobileNumber.sendKeys(Mobile);
	}
	public void Email_ID(String Email, WebDriver Driver)
	{
		WebElement WEmailId =Driver.findElement(EmailId);
		HighlightOnElement(WEmailId);
		WEmailId.sendKeys(Email);
	}
	public void I_agree(WebDriver Driver)
	{
		WebElement WAgree =Driver.findElement(Agree);
		HighlightOnElement(WAgree);
		WAgree.click();
	}
	public void Submit_btn(WebDriver Driver)
	{
		WebElement WAgree =Driver.findElement(Submit);
		HighlightOnElement(WAgree);
		WAgree.click();
	}
	public void Confirm_btn(WebDriver Driver)
	{
		WebElement WConfirm =Driver.findElement(Confirm);
		HighlightOnElement(WConfirm);
		WConfirm.click();
	}
	public void CRegistration(String Fname, String Mname, String Lname, String Add, String Uname, String pass, String Cpass, String Ans, String Mobile, String Email, WebDriver Driver) throws Exception
	{
		
		WebDriverWait wait=new WebDriverWait(Driver, 20);
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		Registr_Btn(Driver);
		First_Name(Fname, Driver);
		Middle_Name(Mname, Driver);
		Last_Name(Lname, Driver);
		DateOfBirth(Driver);
		Gender(Driver);
		Shipping_Address(Add, Driver);
		User_Name(Uname, Driver);
		Pass_word(pass, Driver);
		C_Password(Cpass, Driver);
		//Security_Qsn(Driver);
		//Security_Ans(Ans, Driver);
		Mobile_Number(Mobile, Driver);
		Email_ID(Email, Driver);
		js.executeScript("window.scrollBy(0,1000)");		
		js.executeScript("alert('Please enter the Capcha, This screen will hold for 15 Seconds only...')");
		Thread.sleep(15000);
		I_agree(Driver);
		Submit_btn(Driver);
		Confirm_btn(Driver);
		wait.until(ExpectedConditions.alertIsPresent());
		Driver.switchTo().alert().accept();
	}
}
