package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ParaExcelUtils {

	public static FileInputStream fis ;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static int rowcount;
	public static int colcount;
	
	
	
	public static int getRowcount(String xlfile, String sheetname) throws IOException
	{
		fis = new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fis);
		sh= wb.getSheet(sheetname) ;
	  int	rowcount = sh.getLastRowNum();
	
	  return rowcount;	
	}
	
	public static int getColcount(String xlfile, String sheetname, int rowcount) throws IOException
	{
		fis = new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fis);
		sh= wb.getSheet(sheetname) ;
		 colcount= sh.getRow(rowcount).getLastCellNum();
		
		return colcount;
	}
	
	public static Object getCellData(String xlfile, String sheetname, int rowcount, int colcount) throws IOException
	{
		fis = new FileInputStream(xlfile);
		wb= new XSSFWorkbook(fis);
		sh= wb.getSheet(sheetname) ;
		String celldata = sh.getRow(rowcount).getCell(colcount).getStringCellValue();
	
		return celldata;
		
	}
}
