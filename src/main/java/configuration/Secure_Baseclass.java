package configuration;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class Secure_Baseclass extends Basesuit
{	
	static XSSFWorkbook Workbook;
	static XSSFSheet Datasheet;
	static File src= new File(".//Data//DataSheet.xlsx");
	
	/*****************************************************************/
	/*
	* This bellow function helps to open the Browser.
	* It's taking the browser name from configreaderclass.java and pass parameter to browser class.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@BeforeMethod
	public static void OpenBrowser() throws Exception
	{
		configreaderclass BC=new configreaderclass();
		String[] str2=BC.configreader();
		Driver=Secure_BrowserClass.BrowserDetails(str2[3], Driver);
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow function helps to close the Browser.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	@AfterMethod
	public static void closebrowser() throws Exception
	{
		Thread.sleep(2000);
		Driver.close();	
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
	/*****************************************************************/
	/*
	* This bellow function read the excel sheet and send data to calling function.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	public static Object[][] read(int sheetname) throws Exception
	{	
		FileInputStream FIS=new FileInputStream(src);
		Workbook =new XSSFWorkbook(FIS);
		Datasheet =Workbook.getSheetAt(sheetname);		
		ArrayList<String> UserData=new ArrayList<String>();		
		int Rowc= Datasheet.getLastRowNum();
		int Col= Datasheet.getRow(0).getLastCellNum();
		Rowc=Rowc+1;
		Object[][] Data= new Object[Rowc][Col];		
		for(int i=0; i<Rowc; i++)
		{
			for(int j=0; j<Col; j++)
			{	
				UserData.add(Datasheet.getRow(i).getCell(j).getStringCellValue());
				Data[i][j]=UserData.get(j);
			}			
			UserData.clear();
		}
		return Data;		
	}
	/*****************************************************************/
	/*
	* End
	*/
	/*****************************************************************/
}
