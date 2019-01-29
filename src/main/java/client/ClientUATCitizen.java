package client;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import LTCPS.Project.Logintest;
import Screen.MyRequest_Makepayment;
import Screen.NewCertificate;
import Utility.WriteSheet;
import configuration.Baseclass;
import configuration.configreaderclass;

public class ClientUATCitizen extends Baseclass
{
	@Test
	public void Client_UAT_Citizen() throws Exception
	{
		/***********************************Registration*************************************/
		
		/***********************************End**********************************************/
		/***********************************Login********************************************/
		Logintest ln=new Logintest();
		String Username=Cellread(0,1,0);
		String Password=Cellread(0,1,1);
		ln.Login_testcase(Username,Password);
		Thread.sleep(2000);
		/***********************************End**********************************************/
		/*************************Request for new Certificate********************************/
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
		Thread.sleep(3000);
		/***********************************End**********************************************/
		/******************************payment module****************************************/
		MyRequest_Makepayment MM=PageFactory.initElements(Driver, MyRequest_Makepayment.class);
		String Data3=Cellread(0,1,2);
		MM.Search_Item(Data3);
		Thread.sleep(2000);
		MM.makepayment("4111111111111111", "250");
		String CurUrl=Driver.getCurrentUrl();
		System.out.println(CurUrl);
		
		Thread.sleep(3000);
		configreaderclass BC=new configreaderclass();
		String[] str=BC.configreader();
		String NewUrl=CurUrl.replace("http://125.19.63.165",str[8]);
		System.out.println(NewUrl);
		Driver.get(NewUrl);
		
		ScroolDown();
		MM.no_success();
		MM.Click_here();
		Thread.sleep(3000);
		/***********************************End**********************************************/
		/**********************************Logout********************************************/
		Driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();		
		/***********************************End**********************************************/			
	}
}
