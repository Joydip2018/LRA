package configuration;
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class configreaderclass 
{
	/*****************************************************************/
	/*
	* This bellow function read the constant from property file.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	public String[] configreader() throws Exception
	{
	File src = new File("./Configelement/config.property");
	FileInputStream FIS= new FileInputStream(src);
	Properties pro=new Properties();
	pro.load(FIS);
	String url=pro.getProperty("URL");
	String uname=pro.getProperty("Username");
	String pwd=pro.getProperty("password");
	String Browsername=pro.getProperty("Browser");
	String Gmail=pro.getProperty("GmailUrl");
	String GUname=pro.getProperty("GmailUsername");
	String GPwd=pro.getProperty("Gmailpassword");
	String Surl=pro.getProperty("SecureURL");
	String Burl=pro.getProperty("BaseURL");
	return new String[]{url,uname,pwd,Browsername,Gmail,GUname,GPwd,Surl,Burl};	
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
