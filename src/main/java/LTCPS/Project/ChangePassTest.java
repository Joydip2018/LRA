package LTCPS.Project;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Screen.ChangePasswprd;
import Utility.WriteSheet;
import configuration.Baseclass;

public class ChangePassTest extends Baseclass
{
	/*****************************************************************/
	/*
	* This bellow function helps to perform the Change password operation.
	* Call the logintest function from Screen/Login.class.
	* Call the Change_password function from Screen/ChangePasswprd.class.
	* And Call the Writedata function to write data in excel sheet.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@Test//(dataProvider = "ReadData")//(enabled = false)
	public void Changepassword_Testcase() throws Exception
	{
		Logintest ln=new Logintest();
		String Username=Cellread(0,1,0);
		String Password=Cellread(0,1,1);
		ln.Login_testcase(Username,Password);
		String PWD=Password;
		String NewPwd="Pass@1234";
		ChangePasswprd CP=PageFactory.initElements(Driver, ChangePasswprd.class);
		CP.Change_password(PWD, NewPwd, NewPwd, Driver);
		WriteSheet WS=new WriteSheet();
		WS.Writedata(0,NewPwd,1);
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
