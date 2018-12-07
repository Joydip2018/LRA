package LTCPS.Project;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Screen.Login;
import configuration.Baseclass;

public class Logintest extends Baseclass
{

	/*****************************************************************/
	/*
	* This bellow function helps to Login to the Site.
	* And call the logintest function from Screen/Login.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@Test(enabled=false)
	public void Login_testcase(String str1, String str2) throws Exception
	{
		Login ln=PageFactory.initElements(Driver, Login.class);
		ln.logintest(str1, str2);
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/

}
