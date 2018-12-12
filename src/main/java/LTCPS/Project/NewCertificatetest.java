package LTCPS.Project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Screen.NewCertificate;
import Utility.WriteSheet;
import configuration.Baseclass;

public class NewCertificatetest extends Baseclass
{
	/*****************************************************************/
	/*
	* This bellow function helps to give request for New Certificate.
	* Call the logintest function from Screen/Login.class.
	* Call the Certificate function from Screen/NewCertificate.class.
	* And Call the Writedata function to write data in excel sheet.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@Test//(dataProvider = "ReadData")//(enabled = false)
	public void NewCertificate_Testcase() throws Exception
	{
		Logintest ln=new Logintest();
		String Username=Cellread(0,1,0);
		String Password=Cellread(0,1,1);
		ln.Login_testcase(Username,Password);
		Thread.sleep(2000);
		NewCertificate NC= PageFactory.initElements(Driver, NewCertificate.class);
		NC.Certificate("N-198839", "5");
		//NC.Certificate("N-314452", "5");
		Thread.sleep(3000);
		Alert alert=Driver.switchTo().alert();
		String txt=alert.getText();
		String []ID= txt.split(" ");
		RegID=ID[5];
		alert.accept();
		NC.Close_Bank_Details();
		WriteSheet WS=new WriteSheet();
		WS.Writedata(0,RegID,2);
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
