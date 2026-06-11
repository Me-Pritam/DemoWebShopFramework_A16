package ddtpackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WriteDataInSingleCell
{
    public static void main(String[] args)
    {
      try
      {
          FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

          Workbook workbook = WorkbookFactory.create(fis);

          Sheet sheet = workbook.getSheet("LogInSheet");

          Row row = sheet.getRow(0);

          Cell cell = row.createCell(2);

          cell.setCellValue("Name");

          FileOutputStream fos = new FileOutputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

          workbook.write(fos);
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
