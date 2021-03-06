package testBankDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile {

	public static String credentials[][];
	public static String[][] readExcel(String filePath, String fileName, String sheetName) throws IOException
	{
		
		//creating object of File class to open excel file
		File file = new File(filePath+"\\"+fileName);
		
		//creating object of fileInputStream class to read file
		FileInputStream inputStream = new FileInputStream(file);
		
		Workbook TestData = null;
		
		String fileExtensionName = fileName.substring(fileName.indexOf("."));
		
		if(fileExtensionName.equals(".xlsx"))
		{
			TestData = new XSSFWorkbook(inputStream);
		}
		
		else
			if(fileExtensionName.equals(".xls"))
			{
				TestData = new HSSFWorkbook(inputStream);
			}
		
		//get sheet name
		Sheet TestDataSheet = TestData.getSheet("Sheet1");
		
		//find number of rows in sheet
		int ci = 0;
		int rowCount = TestDataSheet.getLastRowNum()-TestDataSheet.getFirstRowNum();
		credentials = new String[rowCount+1][2];
		for(int i = 1; i < rowCount; i++,ci++)
		{
			
			Row row = TestDataSheet.getRow(i);
			for(int j = 0; j < row.getLastCellNum(); j++)
			{
				
				//System.out.print(row.getCell(j).getStringCellValue()+"|| ");
				if(j == 1)
				{
					credentials[ci][0] = row.getCell(1).getStringCellValue();
				}
				else
					if(j == 2)
				{
					credentials[ci][1] = row.getCell(2).getStringCellValue();
				}

			}
			System.out.println();
		}

		return (credentials);

	}
	public static void main(String args[]) throws IOException
	{
		String filePath = System.getProperty("user.dir")+"\\src\\testBankDemo";
		readExcel(filePath,"TestData.xlsx","Sheet1");
		System.out.println(credentials[0][0]);
	}
	
}
