package Screen;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configuration.Basesuit;

public class RegVerification extends Basesuit
{
	By Username=By.id("identifierId");
	By Nextbtn=By.xpath("//span[contains(text(),'Next')]");
	By Password=By.name("password");
	By Gbtn=By.xpath("//div[@id='gbwa']//a[@class='gb_b']");
	By Gmailbtn=By.xpath("//a[@id='gb23']//span[@class='gb_W']");
	By Mail=By.xpath("//table[@class='F cf zt']//tbody//tr[1]");
	By Linktxt=By.linkText("link");
	
	public void GUsername(String Uname, WebDriver Driver)
	{
		WebElement WUsername=Driver.findElement(Username);
		HighlightOnElement(WUsername);
		WUsername.sendKeys(Uname);
	}
	public void Gnext(WebDriver Driver)
	{
		WebElement WNextbtn=Driver.findElement(Nextbtn);
		HighlightOnElement(WNextbtn);
		WNextbtn.click();
	}
	public void GPassword(String Pass, WebDriver Driver)
	{
		WebElement WPassword=Driver.findElement(Password);
		HighlightOnElement(WPassword);
		WPassword.sendKeys(Pass);
	}
	public void Gmbtn(WebDriver Driver)
	{
		WebElement WGbtn=Driver.findElement(Gbtn);
		HighlightOnElement(WGbtn);
		WGbtn.click();
	}
	public void Gmailbtn(WebDriver Driver)
	{
		WebElement WGmailbtn=Driver.findElement(Gmailbtn);
		HighlightOnElement(WGmailbtn);
		Driver.findElement(Gmailbtn).click();
	}
	public void Mail_Click(WebDriver Driver)
	{
		WebElement WMail=Driver.findElement(Mail);
		HighlightOnElement(WMail);
		WMail.click();
	}
	public void Link_click(WebDriver Driver)
	{
		WebElement WLinktxt=Driver.findElement(Linktxt);
		HighlightOnElement(WLinktxt);
		WLinktxt.click();
	}
	public void Glogin(String Uname, String Pass, WebDriver Driver)
	{
		Driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		Driver.findElement(Username).sendKeys(Uname);
		Driver.findElement(Nextbtn).click();
		Driver.findElement(Password).sendKeys(Pass);
		WebDriverWait wait=new WebDriverWait(Driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Nextbtn));
		Driver.findElement(Nextbtn).click();
		Driver.findElement(Gbtn).click();
		Driver.findElement(Gmailbtn).click();
		Driver.findElement(Mail).click();
		Driver.findElement(Linktxt).click();
		
	}
	
}
