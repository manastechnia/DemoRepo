package util;

import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public  class WriteExcelSheet
{   

	public static FileInputStream fis;
	public static XSSFSheet sheet;
	private static XSSFWorkbook workbook;
	public static FileOutputStream fos = null;
	public static XSSFCell cell;
	public static XSSFRow row;



	public static void setCellData(String text, int rownum, int colnum) throws Exception
	{

		fis = new FileInputStream("D://Selenium/data.xlsx");
		workbook = new XSSFWorkbook(fis);
		sheet = workbook.getSheet("Sheet1");
		row = null;
		cell = null;
		try{   
			row  = sheet.getRow(rownum);
			if(row ==null)
			{
				row = sheet.createRow(rownum);
			}
			cell = row.getCell(colnum);
			if (cell != null) 
			{
				cell.setCellValue(text);
			} 
			else 
			{
				cell = row.createCell(colnum);
				cell.setCellValue(text);  
			}
			fos = new FileOutputStream("D://Selenium/data.xlsx");
			workbook.write(fos);
			workbook.close();
			fos.close();

		}catch(Exception e){throw (e);
		} 
	}

}