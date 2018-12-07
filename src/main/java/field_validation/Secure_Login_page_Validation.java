package field_validation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import Screen.secure_Login;
import configuration.Secure_Baseclass;

public class Secure_Login_page_Validation extends Secure_Baseclass
{
	/*****************************************************************/
	/*
	* This bellow functions helps to validate the userid for Login screen.
	* Call the functions from Screen/Login.class.
	* @author Joydip.Bhattacharjee
	*/
	/******************************************************************/
	@Test//(enabled=false)
	public void S_Login_Username_Validation() throws Exception
	{
		String[] User = {"Xyz123456", "12345678"};
		secure_Login ln=PageFactory.initElements(Driver, secure_Login.class);
		ln.login_link();
		Thread.sleep(2000);
		ln.loginUname(User[0]);
		ln.loginPwd(User[1]);
		JavascriptExecutor JS=(JavascriptExecutor)Driver;
		JS.executeScript("alert('Please enter the Capcha, This screen will hold for 20 Seconds only...')");
		Thread.sleep(20000);
		ln.loginclick();
			String alertMessage = Driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase("User Name is incorrect. Please try again.")) 
			{
				Driver.switchTo().alert().dismiss();
			} 
			else 
			{
				System.out.println("invalid User Accepted");
				Driver.switchTo().alert().dismiss();
				Assert.assertTrue(false);
			}
		
	}
	@Test//(enabled=false)
	public void S_Login_Blank_Username_Validation() throws Exception
	{
		String[] User = {"Xyz123456", "12345678"};
		secure_Login ln=PageFactory.initElements(Driver, secure_Login.class);
		ln.login_link();
		Thread.sleep(2000);
		ln.loginPwd(User[1]);
		JavascriptExecutor JS=(JavascriptExecutor)Driver;
		JS.executeScript("alert('Please enter the Capcha, This screen will hold for 20 Seconds only...')");
		Thread.sleep(20000);
		ln.loginclick();
			String alertMessage = Driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase("Please enter User Name.")) 
			{
				Driver.switchTo().alert().dismiss();
			} 
			else 
			{
				System.out.println("Blcnk User Accepted");
				Driver.switchTo().alert().dismiss();
				Assert.assertTrue(false);
			}
		
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow functions helps to validate the password for Login screen.
	* Call the functions from Screen/Login.class.
	* @author Joydip.Bhattacharjee
	*/
	/******************************************************************/
	@Test//(enabled=false)
	public void S_Login_password_Validation() throws Exception
	{
		String[] User = {"pclerk1", "12345678"};
		secure_Login ln=PageFactory.initElements(Driver, secure_Login.class);
		ln.login_link();
		Thread.sleep(2000);
		ln.loginUname(User[0]);
		ln.loginPwd(User[1]);
		JavascriptExecutor JS=(JavascriptExecutor)Driver;
		JS.executeScript("alert('Please enter the Capcha, This screen will hold for 20 Seconds only...')");
		Thread.sleep(20000);
		ln.loginclick();
			String alertMessage = Driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase("Password is incorrect. Please try again.")) 
			{
				Driver.switchTo().alert().dismiss();
			} 
			else 
			{
				System.out.println("invalid password Accepted");
				Driver.switchTo().alert().dismiss();
				Assert.assertTrue(false);
			}
		
	}
	@Test//(enabled=false)
	public void S_Login_Blank_Password_Validation() throws Exception
	{
		String[] User = {"Xyz123456", "12345678"};
		secure_Login ln=PageFactory.initElements(Driver, secure_Login.class);
		ln.login_link();
		Thread.sleep(2000);
		ln.loginUname(User[0]);
		JavascriptExecutor JS=(JavascriptExecutor)Driver;
		JS.executeScript("alert('Please enter the Capcha, This screen will hold for 20 Seconds only...')");
		Thread.sleep(20000);
		ln.loginclick();
			String alertMessage = Driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase("Please enter Password.")) 
			{
				Driver.switchTo().alert().dismiss();
			} 
			else 
			{
				System.out.println("Blcnk User Accepted");
				Driver.switchTo().alert().dismiss();
				Assert.assertTrue(false);
			}
		
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow functions helps to validate the Capcha for Login screen.
	* Call the functions from Screen/Login.class.
	* @author Joydip.Bhattacharjee
	*/
	/******************************************************************/
	@Test//(enabled=false)
	public void S_Login_Capcha_Validation() throws Exception
	{
		String[] User = {"Test0001", "12345678"};
		secure_Login ln=PageFactory.initElements(Driver, secure_Login.class);
		ln.login_link();
		Thread.sleep(2000);
		ln.loginUname(User[0]);
		ln.loginPwd(User[1]);
		JavascriptExecutor JS=(JavascriptExecutor)Driver;
		JS.executeScript("alert('Please enter Wrong Capcha, This screen will hold for 20 Seconds only...')");
		Thread.sleep(20000);
		ln.loginclick();
			String alertMessage = Driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase("Captcha does not match.")) 
			{
				Driver.switchTo().alert().dismiss();
			} 
			else 
			{
				System.out.println("invalid Capch Accepted");
				Driver.switchTo().alert().dismiss();
				Assert.assertTrue(false);
			}		
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
