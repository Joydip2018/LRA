package Utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import configuration.Basesuit;
import configuration.Secure_Baseclass;

public class Listener implements ITestListener

{
	 ExtentTest logger;
	public void onFinish(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult result) 
	{    
		logger=Basesuit.extent.createTest(result.getName());	 
		try 
		{
			String img="Fail_"+result.getName();
			String temp="."+Snapshot.takescreen(img,Basesuit.getdriver());
			System.out.println(temp);
			logger.fail(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		Secure_Baseclass.extent.flush();
	}

	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) 
	{    
		logger=Basesuit.extent.createTest(result.getName());	    	    	   
		try 
		{
			String img="Pass_"+result.getName();
			String temp="."+Snapshot.takescreen(img,Basesuit.getdriver());
			System.out.println(temp); 
			logger.pass(result.getThrowable().getMessage(), MediaEntityBuilder.createScreenCaptureFromPath(temp).build());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		Secure_Baseclass.extent.flush();	
		
		/*try 
		{
			String img="Pass_"+result.getName();
			Snapshot.takescreen(img, Basesuit.getdriver());
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}*/
	}

}
