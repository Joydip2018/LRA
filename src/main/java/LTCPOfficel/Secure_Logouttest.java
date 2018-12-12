package LTCPOfficel;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
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
}
