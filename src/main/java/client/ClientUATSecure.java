package client;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import LTCPOfficel.secure_Logintest;
import Screen.Secure_Courier;
import Screen.Secure_PrintCertificate;
import Screen.Secure_UpdatecourierStatus;
import configuration.Baseclass;
import configuration.Secure_Baseclass;

public class ClientUATSecure extends Secure_Baseclass
{
	@Test
	public void Client_UAT_office() throws Exception
	{
		/************************Request for print certificate*******************************/
		Thread.sleep(180000);
		secure_Logintest Sln=new secure_Logintest();
		Sln.Login_testcase();
		Secure_PrintCertificate  SP=PageFactory.initElements(Driver, Secure_PrintCertificate.class);
		Baseclass BC=new Baseclass();
		String Data2=BC.Cellread(0,1,2);
		SP.Search_Transaction(Data2);
		SP.Dashboard_link();
		/***********************************End**********************************************/
		/******************************Update Courier****************************************/
		Secure_Courier  SC=PageFactory.initElements(Driver, Secure_Courier.class);
		SC.SecureCourier(Data2,"JD1234098");
		SC.Dashboard_link();
		/***********************************End**********************************************/
		/**************************Update Courier status*************************************/
		Secure_UpdatecourierStatus  SU=PageFactory.initElements(Driver, Secure_UpdatecourierStatus.class);
		SU.UpdateCorier_status(Data2);
		/***********************************End**********************************************/
		/**********************************Logout********************************************/
		Driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();		
		/***********************************End**********************************************/
	}
	
}
