package field_validation;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
//import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import LTCPS.Project.Logintest;
import Screen.UpdateUser;
import configuration.Baseclass;

public class C_UserUpdate_page_Validation extends Baseclass
{
	/*****************************************************************/
	/*
	* This bellow function helps pass login details from excel sheet.
	* And call the read function from configuration/Baseclass.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	/*@DataProvider(name = "ReadData") 
	public Object[][] sheetdetails() throws Exception
	{
		Object[][] testObjArray=Baseclass.read(0);
	   	System.out.println(testObjArray);
	   	return (testObjArray);   	
	}*/
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow function helps to validate Mobile No.
	* Call the logintest function from Screen/Login.class.
	* @author Joydip.Bhattacharjee
	*/
	/******************************************************************/
	@Test//(dataProvider = "ReadData")//(enabled=false)
	public void C_UserUpdate_Mobileno_Validation() throws Exception
	{
		Logintest ln=new Logintest();
		String Username=Cellread(0,1,0);
		String Password=Cellread(0,1,1);
		ln.Login_testcase(Username,Password);
		//Call functions from Screen/UpdateUser.class with the help of "UU" object.	
		String[] invalidChars = {"A", "a","123456789"};
		UpdateUser UU=PageFactory.initElements(Driver, UpdateUser.class);
		UU.Update_profileLink();
		for (String invalid : invalidChars) 
		{	
			Thread.sleep(1000);
			UU.Mobile_Number(invalid);
			UU.Update_btn();
			String alertMessage = Driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase("Please enter valid 10-digit Mobile Number.")) 
			{
				Driver.switchTo().alert().dismiss();
			} 
			else 
			{
				System.out.println(invalid+" Accepted");
				UU.No_btn();
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
	* This bellow function helps to validate Email of the user.
	* Call the logintest function from Screen/Login.class.
	* @author Joydip.Bhattacharjee
	*/
	/******************************************************************/
	@Test//(dataProvider = "ReadData")//(enabled=false)
	public void C_UserUpdate_Email_Validation() throws Exception
	{
		
		Logintest ln=new Logintest();
		String Username=Cellread(0,1,0);
		String Password=Cellread(0,1,1);
		ln.Login_testcase(Username,Password);
		//Call functions from Screen/UpdateUser.class with the help of "UU" object.
		String[] invalidWorrds = {"plainaddress", "#@%^%#$@#$@#.com", 
									"@domain.com", "email.domain.com", 
									"email@domain@domain.com", ".email@domain.com", 
									"email@domain", "email@-domain.com", 
									"email@domain.web", "email@111.222.333.44444", 
									"email@domain..com"};
		UpdateUser UU=PageFactory.initElements(Driver, UpdateUser.class);
		UU.Update_profileLink();
		for (String invalid : invalidWorrds) 
		{	
			Thread.sleep(1000);
			UU.Email_ID(invalid);
			UU.Update_btn();
			String alertMessage = Driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase("Please enter valid E-mail Address.")) 
			{
				Driver.switchTo().alert().dismiss();
			} 
			else 
			{
				System.out.println(invalid+" Accepted");
				UU.No_btn();
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