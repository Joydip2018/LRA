package LTCPS.Project;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Screen.Transection_monitor;
import configuration.Baseclass;

public class Transaction_monitortest extends Baseclass
{
	/*****************************************************************/
	/*
	* This bellow function helps to generate Transaction details.
	* Call the logintest function from Screen/Login.class.
	* Call the Certificate function from Screen/NewCertificate.class.
	* And Call the Writedata function to write data in excel sheet.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@Test//(dataProvider = "ReadData")//(enabled = false)
	public void Transection_Testcase() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		Logintest ln=new Logintest();
		String Username=Cellread(0,1,0);
		String Password=Cellread(0,1,1);
		ln.Login_testcase(Username,Password);
		Transection_monitor  TM=PageFactory.initElements(Driver, Transection_monitor.class);
		String Data3=Cellread(0,1,2);
		TM.Search_Transaction(Data3);
		js.executeScript("window.scrollBy(0,1000)");
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
