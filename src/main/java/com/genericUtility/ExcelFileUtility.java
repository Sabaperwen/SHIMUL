package com.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
	
	
/**
 * This method reads data from the Excel sheet using the given sheet name, row number, and cell number.
 * @param SheetName
 * @param row
 * @param cell
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String readDataFromExcelSheet(String SheetName,int row, int cell ) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis= new FileInputStream(IpathConstant.ExcelFilepath);
		Workbook workbook=WorkbookFactory.create(fis);
		String value=workbook.getSheet(SheetName).getRow(row).getCell(cell).toString();
		return value;
	}
	
	
	
	public int getLastRowNoOfSheet(String sheetName,int row) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis =new FileInputStream(IpathConstant.ExcelFilepath);
		Workbook Workbook = WorkbookFactory.create(fis);
		int rowCount = Workbook.getSheet(sheetName).getLastRowNum();
		return rowCount;
	}
	
	
	public void writeDataIntoExcel(String sheetName, int row,int cell,String value) throws EncryptedDocumentException, IOException {
		FileInputStream fi=new FileInputStream(IpathConstant.ExcelFilepath);
		Workbook workbook = WorkbookFactory.create(fi);
		workbook.getSheet(sheetName).getRow(row).getCell(cell).setCellValue(value);
		
		FileOutputStream fout=new FileOutputStream(IpathConstant.ExcelFilepath);
		workbook.write(fout);
		workbook.close();
	}
}
