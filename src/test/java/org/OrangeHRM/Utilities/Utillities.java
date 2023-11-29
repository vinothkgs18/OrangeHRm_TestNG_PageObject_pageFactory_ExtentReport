package org.OrangeHRM.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.OrangeHRM.Base.TestBase;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;





public class Utillities extends TestBase{
	
	
	
	public static String[][] getDataFromExcel(String filePath,int sgeetNO)  {

		XSSFWorkbook wBook = null;
		try {
			wBook = new XSSFWorkbook(filePath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = wBook.getSheetAt(sgeetNO);
		int lastRow = sheet.getLastRowNum();
		short lastCell = sheet.getRow(0).getLastCellNum();
		System.out.println("Last Row=="+lastRow);
		System.out.println("Last Cell=="+lastCell);
		String[][] data = new String[lastRow][lastCell];
		for (int i = 1; i <=lastRow; i++) {
			XSSFRow row = sheet.getRow(i);
			for (int j = 0; j <lastCell; j++) {
				XSSFCell cell = row.getCell(j);
				DataFormatter dft = new DataFormatter();
				String value = dft.formatCellValue(cell);
				data[i-1][j] = value;

			}

		}
		try {
			wBook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	


}
