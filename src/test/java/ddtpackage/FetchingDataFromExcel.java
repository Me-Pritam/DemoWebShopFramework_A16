package ddtpackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

public class FetchingDataFromExcel
{
    public static void main(String[] args) {

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

            Workbook workbook= WorkbookFactory.create(fis);

            Sheet sheet= workbook.getSheet("LogInSheet");

            Row row = sheet.getRow(1);

            Cell cell= row.getCell(0);

            System.out.println(cell.getStringCellValue());
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
