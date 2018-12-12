package LTCPS.Project;

import org.openqa.selenium.By;
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
	@Test//(dataProvider = "ReadData")
	public void Logout_testcase() throws Exception
	{
		Logintest ln=new Logintest();
		String Username=Cellread(0,1,0);
		String Password=Cellread(0,1,1);
		ln.Login_testcase(Username,Password);
		Driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/

}
