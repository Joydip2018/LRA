package LTCPS.Project;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Screen.UpdateUser;
import configuration.Baseclass;

public class UpdateProfileTest extends Baseclass
{
	/*****************************************************************/
	/*
	* This bellow function helps to update user profile.
	* Call the logintest function from Screen/Login.class.
	* Call the Update_profile function from Screen/UpdateUser.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@Test(dataProvider = "ReadData")//(enabled = false)
	public void Updateprofile_Testcase() throws Exception
	{
		Logintest ln=new Logintest();
		String Username=Cellread(0,1,0);
		String Password=Cellread(0,1,1);
		ln.Login_testcase(Username,Password);
		UpdateUser UU=PageFactory.initElements(Driver, UpdateUser.class);
		UU.Update_profile("9863158406", "joydip.ilfs@gmail.com", "Agartala");
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
