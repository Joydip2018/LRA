package Screen;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import configuration.Basesuit;

public class SetPasswprd extends Basesuit
{
	By Pwd=By.id("password");
	By Repwd=By.id("re_password");
	By Savepass=By.xpath("//input[@value='Save Password']");
	
	public void password(String pass,WebDriver Driver)
	{
		WebElement WPwd= Driver.findElement(Pwd);
		HighlightOnElement(WPwd);
		WPwd.sendKeys(pass);
	}
	public void Repassword(String Repass,WebDriver Driver)
	{
		WebElement WRepwd= Driver.findElement(Repwd);
		HighlightOnElement(WRepwd);
		WRepwd.sendKeys(Repass);
	}
	public void save_pass(WebDriver Driver)
	{
		WebElement WSavepass= Driver.findElement(Savepass);
		HighlightOnElement(WSavepass);
		Driver.findElement(Savepass).click();
	}
	public void Save_password(String pass,String Repass,WebDriver Driver) throws Exception
	{
		password(pass, Driver);
		Repassword(Repass, Driver);
		Thread.sleep(15000);
		save_pass(Driver);
		Driver.switchTo().alert().accept();
	}
}
