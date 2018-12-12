package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteSheet 
{
	/*****************************************************************/
	/*
	* This bellow function helps to write data into Excel Sheet.
	* It's taking Sheetno, CellNo and value as a argument.
	* @author Joydip.Bhattacharjee
	*/
	/*****************************************************************/
	
	XSSFWorkbook Workbook;
	XSSFSheet Datasheet;
	File src= new File(".//Data//DataSheet.xlsx");

	public void Writedata(int sheetno, String value,int cellNo) throws Exception
	{	
		FileInputStream FIS=new FileInputStream(src);
		Workbook =new XSSFWorkbook(FIS);
		Datasheet =Workbook.getSheetAt(sheetno);		
		int Rowc= Datasheet.getLastRowNum();
		Rowc=Rowc+1;	
		for(int i=1; i<Rowc; i++)
		{			
			//System.out.println(Rowc+"Joy");
			Datasheet.getRow(i).createCell(cellNo).setCellValue(value);
			FileOutputStream FOS = new FileOutputStream(src);
			Workbook.write(FOS);
		}		
	}
}
