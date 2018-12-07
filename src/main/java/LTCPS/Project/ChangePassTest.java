package LTCPS.Project;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
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
	@Test(dataProvider = "ReadData")//(enabled = false)
	public void Changepassword_Testcase(String Data1, String Data2, String Data3) throws Exception
	{
		Logintest ln=new Logintest();
		ln.Login_testcase(Data1,Data2);
		String PWD=Data2;
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
	/*****************************************************************/
	/*
	* This bellow function helps pass data to Changepassword_Testcase from excel sheet.
	* And call the read function from configuration/Baseclass.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@DataProvider(name = "ReadData") 
	public Object[][] sheetdetails() throws Exception
	    {
			Object[][] testObjArray=Baseclass.read(0);
	    	return (testObjArray);   	
	    }
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
