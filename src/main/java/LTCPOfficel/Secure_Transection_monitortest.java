package LTCPOfficel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Screen.Secure_Transection_monitor;
import configuration.Baseclass;
import configuration.Secure_Baseclass;

public class Secure_Transection_monitortest extends Secure_Baseclass
{
	/*****************************************************************/
	/*
	* This bellow function helps to generate report.
	* Call the logintest function from Screen/secure_Login.class.
	* And call the Search_Report function from Screen/Secure_Transection_monitor.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@Test//(dataProvider = "ReadData")//(enabled = false)
	public void Secure_Transmonitor_Testcase() throws Exception
	{
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		secure_Logintest ln=new secure_Logintest();
		ln.Login_testcase();
		Secure_Transection_monitor  STM=PageFactory.initElements(Driver, Secure_Transection_monitor.class);
		Baseclass BC=new Baseclass();
		String Data3=BC.Cellread(0,1,2);
		STM.Search_Transaction(Data3);
		js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(2000);
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
