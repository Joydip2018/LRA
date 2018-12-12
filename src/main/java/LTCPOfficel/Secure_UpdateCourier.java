
package LTCPOfficel;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Screen.Secure_Courier;
import configuration.Baseclass;
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
	@Test//(dataProvider = "ReadData")//(enabled = false)
	public void UpdateCourier_Testcase() throws Exception
	{
		secure_Logintest ln=new secure_Logintest();
		ln.Login_testcase();
		Secure_Courier  SC=PageFactory.initElements(Driver, Secure_Courier.class);
		Baseclass BC=new Baseclass();
		String Data3=BC.Cellread(0,1,2);
		SC.SecureCourier(Data3,"JD1234098");
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
