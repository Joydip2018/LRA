package LTCPOfficel;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Screen.secure_Login;
import configuration.Secure_Baseclass;
import configuration.configreaderclass;

public class secure_Logintest extends Secure_Baseclass
{

	/*****************************************************************/
	/*
	* This bellow function helps to Login to the Site.
	* It's taking the login details from configreaderclass.java
	* And call the logintest function from Screen/secure_Login.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@Test(enabled=false)
	public void Login_testcase() throws Exception
	{
		configreaderclass BC=new configreaderclass();
		String[] str=BC.configreader();
		secure_Login ln=PageFactory.initElements(Driver, secure_Login.class);
		ln.logintest(str[1], str[2]);				
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/

}
