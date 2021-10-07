package com.ups.automation.pageobject;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;

/**
 * DataHelper class providing helper methods for reading test data from excel
 */
public class DataHelper {

	private static final Logger logger = LoggerFactory.getLogger(DataHelper.class);

	/**
	 *
	 * @param filepath       - test data input data file path
	 * @param sheetName      - sheet-name of excel data input data file
	 * @param jiraTestCaseId - column value of excel data input data file
	 * @return - return read data from excel
	 */
	public static void data(String filepath, String sheetName, String jiraTestCaseId) {
		try {
			FileInputStream fs = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);
			Row HeaderRow = sheet.getRow(0);
			for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
				Row currentRow = sheet.getRow(i);

				if (!jiraTestCaseId.isEmpty() && jiraTestCaseId.equalsIgnoreCase(String.valueOf(currentRow.getCell(0)))){
					String equipmentNumber = String.valueOf(currentRow.getCell(0));
					String Demurrage = String.valueOf(currentRow.getCell(1));
					String Detention = String.valueOf(currentRow.getCell(2));
				}
			}
			fs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
