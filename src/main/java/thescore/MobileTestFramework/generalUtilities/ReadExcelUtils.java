package thescore.MobileTestFramework.generalUtilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelUtils {
	
	private static XSSFWorkbook excelWorkbook;
	
	private static XSSFSheet excelWorkSheet;
	
	private static XSSFCell cell;
	
	public static void setExcelFile(String path, String sheetName) throws Exception
	{
		try
		{
			FileInputStream inputStream = new FileInputStream(new File(path));
			
			excelWorkbook = new XSSFWorkbook(inputStream);
			
			excelWorkSheet = excelWorkbook.getSheet(sheetName);
		}
		catch (Exception e)
		{
			throw (e);
		}
	}
	
	public static int getRowCount()
	{
		return excelWorkSheet.getLastRowNum() + 1;
	}
	
	public static String getCellData(int row, int collum)
	{
		cell = excelWorkSheet.getRow(row).getCell(collum);
		return cell.getStringCellValue();
	}
}
