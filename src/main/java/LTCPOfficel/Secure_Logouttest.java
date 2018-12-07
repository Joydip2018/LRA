package LTCPOfficel;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import configuration.Baseclass;
import configuration.Secure_Baseclass;

public class Secure_Logouttest extends Secure_Baseclass
{

	/*****************************************************************/
	/*
	* This bellow function helps user to Logout from the Site.
	* And call the logintest function from Screen/Login.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@Test
	public void Secure_Logout_testcase() throws Exception
	{
		secure_Logintest ln=new secure_Logintest();
		ln.Login_testcase();
		Driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow function helps pass data to MakePayment_Testcase from excel sheet.
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
