package LTCPS.Project;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Screen.Registration;
import configuration.Baseclass;

public class Registrationtest extends Baseclass
{

	/*****************************************************************/
	/*
	* This bellow function helps to register new user.
	* Call the CRegistration function from Screen/Registration.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@Test(dataProvider="ReadData" )
	public void Registration_TestCase(String []arg) throws Exception
    {		
		String str=arg[8].replaceAll("a", "");
		Registration Rg=new Registration();
    	Rg.CRegistration(arg[0], arg[1], arg[2], arg[3], arg[4], arg[5], arg[6], arg[7], str, arg[9], Driver);
    }
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow function helps pass data to Registration_TestCase from excel sheet.
	* And call the read function from configuration/Baseclass.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@DataProvider(name = "ReadData") 
	public Object[][] sheetdetails() throws Exception
	{
		Object[][] testObjArray=Baseclass.read(1);
	   	return (testObjArray);   	
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
 
}
