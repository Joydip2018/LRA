package configuration;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Basesuit 
{
	public static WebDriver Driver;
	public static ExtentReports extent;
	
	public static WebDriver getdriver()
	{
		return Driver;	
	}
	public static ExtentReports getextent()
	{
	 	return extent;	
	}
	/*****************************************************************/
	/*
	* This bellow function helps to generate Extent report.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@BeforeSuite(alwaysRun=true)
	@Parameters({"Reportname"})
	public void setup(String Reportname)
	{
		String xmlname=Reportname;
	    ExtentHtmlReporter reporter=new ExtentHtmlReporter("./Screenshot/"+xmlname+".html");		
	    extent = new ExtentReports();	    
	    extent.attachReporter(reporter);
	    
	}
	/*****************************************************************/
	/*
	* This bellow function helps to Wait driver.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	public void waitForPageLoad(WebDriver wdriver, WebElement WE) 
	{
	ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() 
	{
	       public Boolean apply(WebDriver driver) 
	       {
	           return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
	       }
	       };
	       try {
	           WebDriverWait wait = new WebDriverWait(wdriver, 120);
	           wait.until(expectation);
	           wait.until(ExpectedConditions.visibilityOfAllElements(WE));
	       } catch (Throwable error) {
	           Assert.fail("Timeout waiting for Page Load Request to complete.");
	       }
	}
	/****************************************************************************************************/
	 /* This method used to click on "OK" button of the alert pop up
	  * @author Joydip.Bhattacharjee*/
	/*******************************************************************************************************/
	public void acceptAlert() 
	{
		WebDriverWait wait = new WebDriverWait(Driver, 1000);
		wait.until(ExpectedConditions.alertIsPresent());
		String alrt = Driver.switchTo().alert().getText();
		Alert alert = Driver.switchTo().alert();
		alert.accept();
		Reporter.log("Error Message:" + alrt, true);
	}

	/***************************************************************************************************/
	/* This method is used to "CANCEL" button of the alert pop up
	 * @author Joydip.Bhattacharjee*/
	/******************************************************************************************************/	
	public void dismissAlert() 
	{
		WebDriverWait wait = new WebDriverWait(Driver, 1000);
		wait.until(ExpectedConditions.alertIsPresent());
		String alrt = Driver.switchTo().alert().getText();
		Alert alert = Driver.switchTo().alert();
		alert.dismiss();
		Reporter.log("Expected result:" + alrt, true);
	}
	
	/*******************************************************************************************************/
	/* This method is used to refresh the page
	 * @author Joydip.Bhattacharjee*/
	/******************************************************************************************************/
	public void pageForRefresh(WebDriver driver) 
	{
		driver.navigate().refresh();
	}
	
	/*******************************************************************************************************/
	/* This method is used to back the page
	 * @author Joydip.Bhattacharjee*/
	/******************************************************************************************************/
	public void backtoPage(WebDriver driver) 
	{
		driver.navigate().back();
	}
	
	/****************************************************************************/
	/* Highlight the Element to visible at time of Execution
	 * @author Joydip.Bhattacharjee*/
	/***************************************************************************/
	public static void HighlightOnElement(WebElement element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,"color: blue; border: 4px solid Red;");
	}
	
	/****************************************************************************/
	/* Highlight the List Element to visible at time of Execution
	 * @author Joydip.Bhattacharjee*/
	/***************************************************************************/
	public static void HighlightOnElementList(List<WebElement> element) 
	{
		JavascriptExecutor js = (JavascriptExecutor) Driver;
		js.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,"color: blue; border: 4px solid Magenta;");
	}
	
	/****************************************************************************/
	/* This method is used to Switch to frame
	 * @author Joydip.Bhattacharjee*/
	/***************************************************************************/
	public void switchToFrame(WebElement element) 
	{
		Driver.switchTo().frame(element);
	}
	
	/****************************************************************************/
	/* This method is used to Switch to main frame
	 * @author Joydip.Bhattacharjee*/
	/***************************************************************************/
	public void switchFrameToMainWindow() 
	{
		Driver.switchTo().defaultContent();
	}
	
	/****************************************************************************/
	/* This method is used to Page ScroolDown
	 * @author Joydip.Bhattacharjee*/
	/***************************************************************************/
	public void ScroolDown() 
	{
		JavascriptExecutor jse = (JavascriptExecutor) Driver;
		jse.executeScript("window.scrollBy(0,1000)");
	}
	/****************************************************************************/
	/* This method is used to Page Scroolup
	 * @author Joydip.Bhattacharjee*/
	/***************************************************************************/
	
	public void ScroolUp() 
	{
		JavascriptExecutor jse = (JavascriptExecutor) Driver;
		jse.executeScript("window.scrollBy(0,-450)", "");
	}

}
