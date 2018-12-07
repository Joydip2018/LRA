
package LTCPOfficel;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Screen.Secure_Courier;
import configuration.Secure_Baseclass;

public class Secure_UpdateCourier extends Secure_Baseclass
{
	/*****************************************************************/
	/*
	* This bellow function helps to Update courier details.
	* Call the logintest function from Screen/secure_Login.class.
	* And call the SecureCourier function from Screen/Secure_Courier.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@Test(dataProvider = "ReadData")//(enabled = false)
	public void UpdateCourier_Testcase(String Data1,String Data2, String Data3) throws Exception
	{
		secure_Logintest ln=new secure_Logintest();
		ln.Login_testcase();
		Secure_Courier  SC=PageFactory.initElements(Driver, Secure_Courier.class);
		SC.SecureCourier(Data3,"JD1234098");
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow function helps pass data to UpdateCourier_Testcase from excel sheet.
	* And call the read function from configuration/Secure_Baseclass.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@DataProvider(name = "ReadData") 
	public Object[][] sheetdetails() throws Exception
	    {
			Object[][] testObjArray=Secure_Baseclass.read(0);
	    	return (testObjArray);   	
	    }
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
