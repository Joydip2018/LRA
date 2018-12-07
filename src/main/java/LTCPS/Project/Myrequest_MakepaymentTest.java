package LTCPS.Project;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Screen.MyRequest_Makepayment;
import configuration.Baseclass;

public class Myrequest_MakepaymentTest  extends Baseclass
{
	/*****************************************************************/
	/*
	* This bellow function helps to perform the Change password operation.
	* Call the logintest function from Screen/Login.class.
	* Call the Search_Item function from Screen/MyRequest_Makepayment.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@Test(dataProvider = "ReadData")//(enabled = false)
	public void MakePayment_Testcase(String Data1, String Data2, String Data3) throws Exception
	{
		Logintest ln=new Logintest();
		ln.Login_testcase(Data1,Data2);
		MyRequest_Makepayment MM=PageFactory.initElements(Driver, MyRequest_Makepayment.class);
		MM.Search_Item(Data3);
		Thread.sleep(2000);
		MM.makepayment("4111111111111111", "250");
		String CurUrl=Driver.getCurrentUrl();
		System.out.println(CurUrl);
		String NewUrl=CurUrl.replace("http://125.19.63.165:9094","http://192.168.127.108:9094");
		System.out.println(NewUrl);
		Driver.get(NewUrl);	
		Thread.sleep(3000);
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow function helps pass data to MakePayment_Testcase from excel sheet.
	* And call the read function from configuration/Baseclass.class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@DataProvider(name = "ReadData")
	public Object[][] sheetdetails() throws Exception
	{
		Object[][] testObjArray=Baseclass.read(0);
	   	return (testObjArray);   	
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
