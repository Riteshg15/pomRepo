package com.crm.qa.utils;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase{
	
	public static long PAGE_LOAD_TIMEOUT=20;
	public static long IMPLICIT_WAIT=10;
	
	static Workbook book;
	static org.apache.poi.ss.usermodel.Sheet sheet;
	  public void SwitchToFrame()
	  {
		  driver.switchTo().frame("mainpanel");
	  }
	  
	  public static Object [][] getTestData(String sheetname)
	  {
		  FileInputStream file=null;
		  try {
			  file=new FileInputStream("E:\\maven_p\\PageObjectModelProject1\\src\\main\\java\\com\\crm\\qa\\testdata\\freeCRMTestData.xlsx");
			  
		  }
		  catch (Exception e) {
			  e.printStackTrace();
		}try {
			book=WorkbookFactory.create(file);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetname);
		Object[][] data= new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		for(int i=0;i<sheet.getLastRowNum();i++)
		{
			for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
			{
				data [i][k]=sheet.getRow(i+1).getCell(k).toString();
			}
		}
		return data;
		  
		}
}
