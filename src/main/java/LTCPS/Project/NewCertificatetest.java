package LTCPS.Project;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
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
	@Test(dataProvider = "ReadData")//(enabled = false)
	public void NewCertificate_Testcase(String Data1, String Data2, String Data3) throws Exception
	{
		System.out.println(Data1);
		System.out.println(Data2);
		Logintest ln=new Logintest();
		ln.Login_testcase(Data1,Data2);
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
	/*****************************************************************/
	/*
	* This bellow function helps pass data to NewCertificate_Testcase from excel sheet.
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
