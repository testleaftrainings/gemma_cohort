import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

public class ReadExcelData {
    //data
    @DataProvider(name = "Login")
    public String[][] readData() throws IOException {
        FileInputStream fl = new FileInputStream(System.getProperty("user.dir") + "/resources/MySheet.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fl);
        XSSFSheet sheet = wb.getSheet("Login");
        int row = sheet.getLastRowNum();
        int col = sheet.getRow(row).getLastCellNum();
        String[][] data = new String[row][col];
        for (int i = 1; i <= row; i++) {
            for (int j = 0; j < col; j++) {

                data[i - 1][j] = sheet.getRow(i).getCell(j).getStringCellValue();
            }
        }

        wb.close();
        fl.close();
        return data;
    }
}
