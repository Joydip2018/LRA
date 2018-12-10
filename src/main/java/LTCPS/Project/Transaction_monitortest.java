package LTCPS.Project;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
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
	@Test(dataProvider = "ReadData")//(enabled = false)
	public void Transection_Testcase(String Data1,String Data2, String Data3) throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		Logintest ln=new Logintest();
		ln.Login_testcase(Data1,Data2);
		Transection_monitor  TM=PageFactory.initElements(Driver, Transection_monitor.class);
		TM.Search_Transaction(Data3);
		js.executeScript("window.scrollBy(0,1000)");
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
