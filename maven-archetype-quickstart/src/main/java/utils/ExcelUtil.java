package utils;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public static Object[][] getLoginData() {

        Object[][] data = null;

        try {

            FileInputStream fis = new FileInputStream("testdata/LoginData.xlsx");

            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheet("Sheet1");

            int rows = sheet.getLastRowNum();
            int cols = sheet.getRow(0).getLastCellNum();

            data = new Object[rows][cols];

            for (int i = 1; i <= rows; i++) {

                for (int j = 0; j < cols; j++) {

                    data[i - 1][j] = sheet.getRow(i).getCell(j).toString();

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return data;
    }
}