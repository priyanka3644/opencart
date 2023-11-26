package tests;

import java.io.IOException;

import utilities.ExcelUtility;

public class test {
	
	public static void main(String[] args) throws IOException
	{
		String path = System.getProperty("user.dir") +"\\testData\\LoginData.xlsx";
		ExcelUtility excelUtil = new ExcelUtility(path);
		int rowCount= excelUtil.getRowCount("Sheet1");
		int colCount = excelUtil.getCellCount("Sheet1", 0);
		
		String loginData[][] = new String[rowCount][colCount];
		
		for(int i=1;i<rowCount;i++) // 4 rows, 3 cols
		{
			for(int j=0;j<colCount;j++)
			{
				System.out.println("RowNumber "+i+"  colNumber "+j);
				loginData[i-1][j] = excelUtil.getCellData("Sheet1",i,j);
			}
		}
		
		
	}
	
}
