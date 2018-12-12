
package LTCPOfficel;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Screen.Secure_UpdatecourierStatus;
import configuration.Baseclass;
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
	@Test//(dataProvider = "ReadData")//(enabled = false)
	public void UpdateCourierStatus_Testcase() throws Exception
	{
		secure_Logintest ln=new secure_Logintest();
		ln.Login_testcase();
		Secure_UpdatecourierStatus  SU=PageFactory.initElements(Driver, Secure_UpdatecourierStatus.class);
		Baseclass BC=new Baseclass();
		String Data3=BC.Cellread(0,1,2);
		SU.UpdateCorier_status(Data3);
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/

}
