
package LTCPOfficel;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Screen.Secure_PrintCertificate;
import configuration.Secure_Baseclass;

public class Secure_PrintCertificatetest extends Secure_Baseclass
{
	/*****************************************************************/
	/*
	* This bellow function helps to perform the Print Certificate operation.
	* Call the logintest function from Screen/secure_Login.class.
	* And call the Search_Transaction function from Screen/Secure_PrintCertificate.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@Test(dataProvider = "ReadData")//(enabled = false)
	public void Secure_PrintCertificate_Testcase(String Data1,String Data2, String Data3) throws Exception
	{
		//Thread.sleep(300000);
		secure_Logintest ln=new secure_Logintest();
		ln.Login_testcase();
		Secure_PrintCertificate  SP=PageFactory.initElements(Driver, Secure_PrintCertificate.class);
		SP.Search_Transaction(Data3);
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow function helps pass data to PrintCertificate_Testcase from excel sheet.
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
