package field_validation;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import LTCPOfficel.secure_Logintest;
import Screen.Secure_Courier;
import configuration.Secure_Baseclass;

public class Secure_UpdateCourier_page_Validation extends Secure_Baseclass
{
	/*****************************************************************/
	/*
	* This bellow functions helps to validate the Service Provider dropdown for courier screen.
	* Call the functions from Screen/Login.class.
	* @author Joydip.Bhattacharjee
	*/
	/******************************************************************/
	@Test//(enabled=false)
	public void S_Blank__Service_Provider_Validation() throws Exception
	{
		secure_Logintest ln=new secure_Logintest();
		ln.Login_testcase();
		Secure_Courier  SC=PageFactory.initElements(Driver, Secure_Courier.class);
		//WebDriverWait wait=new WebDriverWait(Driver, 20);
		//wait.until(ExpectedConditions.visibilityOfAllElements(CourierDetails));
		SC.Courier_Details();
		Thread.sleep(20000);
		SC.Update_Courier();
		Thread.sleep(20000);
		//wait.until(ExpectedConditions.visibilityOfAllElements(UpdateCourierStatus));
		SC.	Update_courier();
		//wait.until(ExpectedConditions.visibilityOfAllElements(Search));
		SC.trackID("12345");
		SC.Save_btn();
		String alertMessage = Driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase("Please select Courier Service.")) 
			{
				Driver.switchTo().alert().dismiss();
			} 
			else 
			{
				System.out.println("Blank Courier Service Accepted");
				Driver.switchTo().alert().dismiss();
				Assert.assertTrue(false);
			}
		
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow functions helps to validate the Tracking ID for courier screen.
	* Call the functions from Screen/Login.class.
	* @author Joydip.Bhattacharjee
	*/
	/******************************************************************/
	@Test//(enabled=false)
	public void S_Blank_Trackid_Validation() throws Exception
	{
		secure_Logintest ln=new secure_Logintest();
		ln.Login_testcase();
		Secure_Courier  SC=PageFactory.initElements(Driver, Secure_Courier.class);
		//WebDriverWait wait=new WebDriverWait(Driver, 20);
		//wait.until(ExpectedConditions.visibilityOfAllElements(CourierDetails));
		SC.Courier_Details();
		Thread.sleep(20000);
		SC.Update_Courier();
		Thread.sleep(20000);
		//wait.until(ExpectedConditions.visibilityOfAllElements(UpdateCourierStatus));
		SC.	Update_courier();
		//wait.until(ExpectedConditions.visibilityOfAllElements(Search));
		SC.SelectServiceProvider();
		SC.Save_btn();
		String alertMessage = Driver.switchTo().alert().getText();
			if (alertMessage.equalsIgnoreCase("Please enter Tracking Number.")) 
			{
				Driver.switchTo().alert().dismiss();
			} 
			else 
			{
				System.out.println("Blank Tracking Accepted");
				Driver.switchTo().alert().dismiss();
				Assert.assertTrue(false);
			}		
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
