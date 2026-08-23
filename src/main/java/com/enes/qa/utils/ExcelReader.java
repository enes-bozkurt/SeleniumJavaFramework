package com.enes.qa.utils;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

public class ExcelReader {

    public static Object[][] getExcelData(String filePath,
                                          String sheetName) {

        Object[][] data = null;

        try {

            FileInputStream fis =
                    new FileInputStream(filePath);

            XSSFWorkbook workbook =
                    new XSSFWorkbook(fis);

            XSSFSheet sheet =
                    workbook.getSheet(sheetName);

            int rowCount =
                    sheet.getPhysicalNumberOfRows();

            int columnCount =
                    sheet.getRow(0).getPhysicalNumberOfCells();

            data =
                    new Object[rowCount - 1][columnCount];

            DataFormatter formatter =
                    new DataFormatter();

            for (int i = 1; i < rowCount; i++) {

                for (int j = 0; j < columnCount; j++) {

                    data[i - 1][j] =
                            formatter.formatCellValue(
                                    sheet.getRow(i).getCell(j)
                            );
                }
            }

            workbook.close();
            fis.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}