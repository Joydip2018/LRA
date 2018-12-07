
package LTCPOfficel;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Screen.Secure_UpdatecourierStatus;
import configuration.Secure_Baseclass;

public class Secure_UpdateCourierStatus extends Secure_Baseclass
{
	/*****************************************************************/
	/*
	* This bellow function helps to update courier status.
	* Call the logintest function from Screen/secure_Login.class.
	* And call the UpdateCorier_status function from Screen/Secure_UpdatecourierStatus.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@Test(dataProvider = "ReadData")//(enabled = false)
	public void UpdateCourierStatus_Testcase(String Data1,String Data2, String Data3) throws Exception
	{
		secure_Logintest ln=new secure_Logintest();
		ln.Login_testcase();
		Secure_UpdatecourierStatus  SU=PageFactory.initElements(Driver, Secure_UpdatecourierStatus.class);
		SU.UpdateCorier_status(Data3);
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow function helps pass data to UpdateCourierStatus_Testcase from excel sheet.
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
