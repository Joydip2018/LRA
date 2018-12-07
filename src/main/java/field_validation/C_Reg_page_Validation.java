package field_validation;

import org.testng.Assert;
import org.testng.annotations.Test;
import Screen.Registration;
import configuration.Baseclass;

public class C_Reg_page_Validation extends Baseclass
{
	/*****************************************************************/
	/*
	* This bellow function helps to validate First name of the user.
	* Call the CRegistration function from Screen/Registration.class.
	* @author Joydip.Bhattacharjee
	*/
	/******************************************************************/
	@Test//(enabled=false)
	public void C_Reg_Fname_Validation() throws Exception
	{
		String[] invalidChars = {"#", "!", "$", "@", "%", "^", "&", 
								"*", "(", ")", ":", "+", "0"};
		Registration Rg=new Registration();
		Rg.Registr_Btn(Driver);
		for (String invalid : invalidChars) 
		{	
			Rg.First_Name(invalid, Driver);
			Rg.Submit_btn(Driver);
			String alertMessage = Driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase("Please enter valid First Name.")) 
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
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow function helps to validate Middle name of the user.
	* Call the CRegistration function from Screen/Registration.class.
	* @author Joydip.Bhattacharjee
	*/
	/******************************************************************/
	@Test//(enabled=false)
	public void C_Reg_Mname_Validation() throws Exception
	{
		String[] invalidChars = {"#", "!", "$", "@", "%", "^", 
								"&", "*", "(", ")", ":", "+", "0"};
		Registration Rg=new Registration();
		Rg.Registr_Btn(Driver);
		for (String invalid : invalidChars) 
		{	
			Rg.Middle_Name(invalid, Driver);
			Rg.Submit_btn(Driver);
			String alertMessage = Driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase("Please enter valid Middle Name.")) 
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
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow function helps to validate Last name of the user.
	* Call the CRegistration function from Screen/Registration.class.
	* @author Joydip.Bhattacharjee
	*/
	/******************************************************************/
	@Test//(enabled=false)
	public void C_Reg_Lname_Validation() throws Exception
	{
		String[] invalidChars = {"#", "!", "$", "@", "%", "^", "&",
								"*", "(", ")", ":", "+", "0"};
		Registration Rg=new Registration();
		Rg.Registr_Btn(Driver);
		for (String invalid : invalidChars) 
		{	
			Rg.Last_Name(invalid, Driver);
			Rg.Submit_btn(Driver);
			String alertMessage = Driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase("Please enter valid Last Name.")) 
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
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow function helps to validate User name of the user.
	* Call the CRegistration function from Screen/Registration.class.
	* @author Joydip.Bhattacharjee
	*/
	/******************************************************************/
	@Test//(enabled=false)
	public void C_Reg_Username_Validation() throws Exception
	{
		String[] invalidChars = {"#", "!", "$", "@", "%", "^",
								"&", "*", "(", ")", ":", "+"};
		Registration Rg=new Registration();
		Rg.Registr_Btn(Driver);
		for (String invalid : invalidChars) 
		{	
			Rg.User_Name(invalid, Driver);
			Rg.Submit_btn(Driver);
			String alertMessage = Driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase("Please enter valid User Name.")) 
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
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow function helps to validate Mobile No of the user.
	* Call the CRegistration function from Screen/Registration.class.
	* @author Joydip.Bhattacharjee
	*/
	/******************************************************************/
	@Test//(enabled=false)
	public void C_Reg_Mobileno_Validation() throws Exception
	{
		String[] invalidChars = {"#", "!", "$", "@", "%", "^", 
								"&", "*", "(", ")", ":", "+", 
								"A", "a","123456789"};
		Registration Rg=new Registration();
		Rg.Registr_Btn(Driver);
		for (String invalid : invalidChars) 
		{	
			Rg.Mobile_Number(invalid, Driver);
			Rg.Submit_btn(Driver);
			String alertMessage = Driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase("Please enter valid 10-digit Mobile Number.")) 
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
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow function helps to validate password of the user.
	* Call the CRegistration function from Screen/Registration.class.
	* @author Joydip.Bhattacharjee
	*/
	/******************************************************************/
	@Test//(enabled=false)
	public void C_Reg_PassWord_Validation() throws Exception
	{
		String[] invalidChars = {"1234567", "12345678", "aaaaaaaa",
								"AAAAAAAA", "AAAAaaaa", "AAAAaaa1", 
								"!@#$!@#$"};
		Registration Rg=new Registration();
		Rg.Registr_Btn(Driver);
		for (String invalid : invalidChars) 
		{	
			Rg.Pass_word(invalid, Driver);
			Rg.Submit_btn(Driver);
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
		
	}/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow function helps to validate Email of the user.
	* Call the CRegistration function from Screen/Registration.class.
	* @author Joydip.Bhattacharjee
	*/
	/******************************************************************/
	@Test//(enabled=false)
	public void C_Reg_Email_Validation() throws Exception
	{
		String[] invalidWorrds = {"plainaddress", "#@%^%#$@#$@#.com", 
								"@domain.com", "email.domain.com", 
								"email@domain@domain.com", ".email@domain.com", 
								"email@domain", "email@-domain.com", 
								"email@domain.web", "email@111.222.333.44444", 
								"email@domain..com"};
		Registration Rg=new Registration();
		Rg.Registr_Btn(Driver);
		for (String invalid : invalidWorrds) 
		{	
			Rg.Email_ID(invalid, Driver);
			Rg.Submit_btn(Driver);
			String alertMessage = Driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase("Please enter valid E-mail Address.")) 
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
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
