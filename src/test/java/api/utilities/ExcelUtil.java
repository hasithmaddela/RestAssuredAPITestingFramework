package api.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtil {

	public static XSSFWorkbook wb;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static String data;
	String Path;
	
	public ExcelUtil(String Path) {
		this.Path=Path;
	}
	
	public  int getRowCount(String SheetName) throws IOException
	{
		fis=new FileInputStream(Path);
		wb=new XSSFWorkbook(fis);
		sheet=wb.getSheet(SheetName);
		int rowcount=sheet.getLastRowNum();
		wb.close();
		fis.close();
		return rowcount;	
	}
	
   public  int getColumnCount(String SheetName,int rowno) throws IOException
   {
		fis=new FileInputStream(Path);
		wb=new  XSSFWorkbook(fis);
		sheet=wb.getSheet(SheetName);
		row=sheet.getRow(rowno);
		int columncount=row.getLastCellNum();
		wb.close();
		fis.close();
		return columncount;
	}
   
   public  String getCellData(String SheetName,int rowno,int colno) throws IOException {
	   fis=new FileInputStream(Path);
	   wb=new XSSFWorkbook(fis);
	   sheet=wb.getSheet(SheetName);
	   row=sheet.getRow(rowno);
	   cell=row.getCell(colno);
	  try
	  {
		 //  data=cell.toString();
		   DataFormatter df=new DataFormatter();//Returns String value for any type of value format for cells
		  data= df.formatCellValue(cell);   
	  }
	  catch(Exception e) {
		  data="";
	  }
	   wb.close();
	   fis.close();
	   return data;
		
	}
   public  void setCellData(String SheetName,int rowno,int colno,String value) throws IOException {
	   fis=new FileInputStream(Path);
	   wb=new XSSFWorkbook(fis);
	   sheet=wb.getSheet(SheetName);
	   row=sheet.getRow(rowno);
	   cell=row.createCell(colno);
	   cell.setCellValue(value);
	   fos=new FileOutputStream(Path);
	   wb.write(fos);
	   wb.close();
	   fis.close();
	   fos.close();
	}
   public  void fillGreenColor(String SheetName,int rowno,int colno) throws IOException
   {  
	   fis=new FileInputStream(Path);
	   wb=new XSSFWorkbook(fis);
	   sheet=wb.getSheet(SheetName);
	   row=sheet.getRow(rowno);
	   cell=row.getCell(colno);
	   style=wb.createCellStyle();
	   style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	   style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	   cell.setCellStyle(style);
	   fos=new FileOutputStream(Path);
	   wb.write(fos);
	   wb.close();
	   fis.close();
	}
   public  void fillRedColor(String SheetName,int rowno,int colno) throws IOException
   {
	   fis=new FileInputStream(Path);
	   wb=new XSSFWorkbook(fis);
	   sheet=wb.getSheet(SheetName);
	   row=sheet.getRow(rowno);
	   cell=row.getCell(colno);
	   style=wb.createCellStyle();
	   style.setFillForegroundColor(IndexedColors.RED.getIndex());
	   style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
	   cell.setCellStyle(style);
	   fos=new FileOutputStream(Path);
	   wb.write(fos);
	   wb.close();
	   fis.close();
		
	}
}
