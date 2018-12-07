package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReadDatasheet 
{
	static XSSFWorkbook Workbook;
	static XSSFSheet Datasheet;
	static File src= new File(".//Data//TestDataSheet.xlsx");
	
	@Test(dataProvider = "ReadData")
	public void readtest(String []arg)
	{
		int count=arg.length;
		for(int i=0;i<count;i++)
		{
			if(arg[i]==null)
			{
				break;
			}
		System.out.print(" "+arg[i]);
		}
		System.out.println();
	}
	@DataProvider(name = "ReadData")
	public static Object[][] read() throws Exception
	{	
		FileInputStream FIS=new FileInputStream(src);
		Workbook =new XSSFWorkbook(FIS);
		Datasheet =Workbook.getSheetAt(0);		
		ArrayList<String> UserData=new ArrayList<String>();		
		int Rowc= Datasheet.getLastRowNum();
		int Col= Datasheet.getRow(0).getLastCellNum();
		Rowc=Rowc+1;
		Object[][] Data= new Object[Rowc][Col];		
		for(int i=1; i<Rowc; i++)
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
}
