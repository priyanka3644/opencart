package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	
	
	String path;
	public FileInputStream fis;
	public FileOutputStream fos;
	public XSSFWorkbook wb;
	public XSSFSheet sh;
	public XSSFRow row;
	public XSSFCell cell;
	public CellStyle style;
	
	
	public ExcelUtility(String path) throws IOException
	{
		this.path = path;
		fis = new FileInputStream(path);
		wb = new XSSFWorkbook(fis);		
	}
	
	public int getRowCount(String sheetName)
	{
		
		sh = wb.getSheet(sheetName);
		int count= sh.getLastRowNum()+1;
		return count;	
	}
	
	public int getColCount(String sheetName)
	{
		sh = wb.getSheet(sheetName);
		row = sh.getRow(0);
		int count = row.getLastCellNum();
		return count;
	}
	
	
	public int getCellCount(String sheetName, int rowNum)
	{
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		return cellCount;
	}
	
	public String getCellData(String sheetName, int rowNum, int colNum)
	{
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rowNum);
		cell = row.getCell(colNum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		
		try {
			data = formatter.formatCellValue(cell);
		}catch(Exception e)
		{
			data="";
		}
		return data;
	}
	
	
	public void setCellData(String sheetName, int rowNum, int colNum, String data) throws IOException
	{
		File file = new File(path);
		if(!file.exists())
		{
			wb = new XSSFWorkbook();
			fos = new FileOutputStream(path);
			wb.write(fos);
		}
		
		fis = new FileInputStream(path);
		wb= new XSSFWorkbook(fis);
		
		if(wb.getSheetIndex(sheetName) ==-1)
		{
			wb.createSheet(sheetName);
		}
		
		sh= wb.getSheet(sheetName);
		if(sh.getRow(rowNum)==null)
		{
			sh.createRow(rowNum);
		}
		
		row= sh.getRow(rowNum);
		
		cell= row.createCell(colNum);
		cell.setCellValue(data);
		fos = new FileOutputStream(path);
		wb.write(fos);
		fos.close();
	}
}
