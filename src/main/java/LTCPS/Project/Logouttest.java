package LTCPS.Project;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import configuration.Baseclass;

public class Logouttest extends Baseclass
{

	/*****************************************************************/
	/*
	* This bellow function helps user to Logout from the Site.
	* And call the logintest function from Screen/Login.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@Test(dataProvider = "ReadData")
	public void Logout_testcase(String Data1, String Data2, String Data3) throws Exception
	{
		Logintest ln=new Logintest();
		ln.Login_testcase(Data1,Data2);
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
