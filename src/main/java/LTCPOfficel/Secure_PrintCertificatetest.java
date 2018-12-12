
package LTCPOfficel;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Screen.Secure_PrintCertificate;
import configuration.Baseclass;
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
	@Test//(dataProvider = "ReadData")//(enabled = false)
	public void Secure_PrintCertificate_Testcase() throws Exception
	{
		Thread.sleep(180000);
		secure_Logintest ln=new secure_Logintest();
		ln.Login_testcase();
		Secure_PrintCertificate  SP=PageFactory.initElements(Driver, Secure_PrintCertificate.class);
		Baseclass BC=new Baseclass();
		String Data3=BC.Cellread(0,1,2);
		SP.Search_Transaction(Data3);
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
