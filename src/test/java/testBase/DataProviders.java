package testBase;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtility;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws IOException
	{
		String path = System.getProperty("user.dir") +"\\testData\\LoginData.xlsx";
		ExcelUtility excelUtil = new ExcelUtility(path);
		int rowCount= excelUtil.getRowCount("Sheet1");
		int colCount = excelUtil.getCellCount("Sheet1", 0);
		
		String loginData[][] = new String[rowCount-1][colCount];
		
		for(int i=1;i<rowCount;i++) // 4 rows, 3 cols
		{
			for(int j=0;j<colCount;j++)
			{
				loginData[i-1][j] = excelUtil.getCellData("Sheet1",i,j);
			}
		}
		
		return loginData;
	}

}
