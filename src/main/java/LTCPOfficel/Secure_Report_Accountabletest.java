package LTCPOfficel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Screen.Secure_Report_Accountable;
import configuration.Secure_Baseclass;

public class Secure_Report_Accountabletest extends Secure_Baseclass
{
	/*****************************************************************/
	/*
	* This bellow function helps to generate report.
	* Call the logintest function from Screen/secure_Login.class.
	* And call the Search_Report function from Screen/Secure_Report_Courier.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@Test(dataProvider = "ReadData")//(enabled = false)
	public void Secure_Report_Accountable_Testcase(String Data1,String Data2, String Data3) throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		secure_Logintest ln=new secure_Logintest();
		ln.Login_testcase();
		Secure_Report_Accountable  STM=PageFactory.initElements(Driver, Secure_Report_Accountable.class);
		STM.Search_Report();
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*
	* This bellow function helps pass data to Secure_Report_Courier_Testcase from excel sheet.
	* And call the read function from configuration/Secure_Baseclass.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@DataProvider(name = "ReadData")
	public Object[][] sheetdetails() throws Exception
	{
		Object[][] testObjArray=Secure_Baseclass.read(0);
	   	return (testObjArray);
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
