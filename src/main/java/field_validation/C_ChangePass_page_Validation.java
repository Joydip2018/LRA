package field_validation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import LTCPS.Project.Logintest;
import Screen.ChangePasswprd;
import configuration.Baseclass;

public class C_ChangePass_page_Validation extends Baseclass
{
	/*****************************************************************/
	/*
	* This bellow function helps pass login details from excel sheet.
	* And call the read function from configuration/Baseclass.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
 	@DataProvider(name = "ReadData") 
	public Object[][] sheetdetails() throws Exception
	{
		Object[][] testObjArray=Baseclass.read(0);
	   	System.out.println(testObjArray);
	   	return (testObjArray);   	
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow functions helps to validate password of the user.
	* Call the CRegistration function from Screen/Registration.class.
	* @author Joydip.Bhattacharjee
	*/
	/******************************************************************/
	@Test(dataProvider = "ReadData")//, enabled=false)
	public void C_change_NPassWord_Validation(String Data1, String Data2, String Data3) throws Exception
	{
		Logintest ln=new Logintest();
		ln.Login_testcase(Data1,Data2);
		String[] invalidChars = {"1234567", "12345678", "aaaaaaaa",
								"AAAAAAAA", "AAAAaaaa", "AAAAaaa1", 
								"!@#$!@#$"};
		ChangePasswprd CP=PageFactory.initElements(Driver, ChangePasswprd.class);
		CP.Change_passLink();
		Thread.sleep(2000);
		for (String invalid : invalidChars) 
		{	
			CP.password(invalid);
			CP.Change_pass();
			String alertMessage = Driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase("Password must be at least eight (8) characters in length. Please try again.")) 
			{
				Driver.switchTo().alert().dismiss();
			} 
			else if (alertMessage.equalsIgnoreCase("Password must contain at least one (1) lowercase letter (a-z).")) 
			{
				Driver.switchTo().alert().dismiss();
			} 
			else if (alertMessage.equalsIgnoreCase("Password must contain at least one (1) number (0-9).")) 
			{
				Driver.switchTo().alert().dismiss();
			} 
			else if (alertMessage.equalsIgnoreCase("Password must contain at least one (1) special character.")) 
			{
				Driver.switchTo().alert().dismiss();
			} 
			else 
			{
				System.out.println(invalid+" Accepted");
				Driver.switchTo().alert().dismiss();
				Assert.assertTrue(false);
				break;
			}

		}
		
	}
	@Test(dataProvider = "ReadData")//, enabled=false)
	public void C_change_OPassWord_Validation(String Data1, String Data2, String Data3) throws Exception
	{
		Logintest ln=new Logintest();
		ln.Login_testcase(Data1,Data2);
		String[] Chars = {"12345678", "Test@1234", "Test@1234"};
		ChangePasswprd CP=PageFactory.initElements(Driver, ChangePasswprd.class);
		CP.Change_passLink();
		Thread.sleep(2000);
		CP.Old_Pwd(Chars[0]);
		CP.password(Chars[1]);
		CP.Repassword(Chars[2]);
		JavascriptExecutor JS=(JavascriptExecutor)Driver;
		JS.executeScript("alert('Please enter the Capcha, This screen will hold for 20 Seconds only...')");
		Thread.sleep(20000);
		CP.Change_pass();
		String alertMessage = Driver.switchTo().alert().getText();
		if (alertMessage.equalsIgnoreCase("Please enter correct Old Password.")) 
		{
			Driver.switchTo().alert().dismiss();
		} 
		else 
		{
			System.out.println("Accepted");
			Driver.switchTo().alert().dismiss();
			Assert.assertTrue(false);
		}
		
	}
	@Test(dataProvider = "ReadData")//, enabled=false)
	public void C_same_N_O_PassWord_Validation(String Data1, String Data2, String Data3) throws Exception
	{
		Logintest ln=new Logintest();
		ln.Login_testcase(Data1,Data2);
		String[] Chars = {"Pass@1234", "Pass@1234", "Pass@1234"};
		ChangePasswprd CP=PageFactory.initElements(Driver, ChangePasswprd.class);
		CP.Change_passLink();
		Thread.sleep(2000);
		CP.Old_Pwd(Chars[0]);
		CP.password(Chars[1]);
		CP.Repassword(Chars[2]);
		JavascriptExecutor JS=(JavascriptExecutor)Driver;
		JS.executeScript("alert('Please enter the Capcha, This screen will hold for 20 Seconds only...')");
		Thread.sleep(20000);
		CP.Change_pass();
		String alertMessage = Driver.switchTo().alert().getText();
		if (alertMessage.equalsIgnoreCase("New password cannot be the same with old password.")) 
		{
			Driver.switchTo().alert().dismiss();
		} 
		else 
		{
			System.out.println("Accepted");
			Driver.switchTo().alert().dismiss();
			Assert.assertTrue(false);
		}		
	}
	@Test(dataProvider = "ReadData")// enabled=false)
	public void C_same_N_C_PassWord_Validation(String Data1, String Data2, String Data3) throws Exception
	{
		Logintest ln=new Logintest();
		ln.Login_testcase(Data1,Data2);
		String[] Chars = {"Pass@1234", "Pass@1234", "Pass@123"};
		ChangePasswprd CP=PageFactory.initElements(Driver, ChangePasswprd.class);
		CP.Change_passLink();
		Thread.sleep(2000);
		CP.Old_Pwd(Chars[0]);
		CP.password(Chars[1]);
		CP.Repassword(Chars[2]);
		CP.Change_pass();
		String alertMessage = Driver.switchTo().alert().getText();
		if (alertMessage.equalsIgnoreCase("Password mismatch. Please try again.")) 
		{
			Driver.switchTo().alert().dismiss();
		} 
		else 
		{
			System.out.println("Accepted");
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
