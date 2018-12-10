package LTCPS.Project;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
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
	public void Updateprofile_Testcase(String Data1, String Data2, String Data3) throws Exception
	{
		Logintest ln=new Logintest();
		ln.Login_testcase(Data1,Data2);
		UpdateUser UU=PageFactory.initElements(Driver, UpdateUser.class);
		UU.Update_profile("9863158406", "joydip.ilfs@gmail.com", "Agartala");
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow function helps pass data to Transection_Testcase from excel sheet.
	* And call the read function from configuration/Baseclass.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@DataProvider(name = "ReadData") 
	public Object[][] sheetdetails() throws Exception
	{
		Object[][] testObjArray=Baseclass.read(0);
	   	System.out.println(testObjArray);
	   	return (testObjArray);   	
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
