package ddtpackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class RemovingDataFromCell
{
    public static void main(String[] args)
    {
      try
      {
          FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

          Workbook workbook = WorkbookFactory.create(fis);

          Sheet sheet = workbook.getSheet("NewCreatedSheet");

          Row row = sheet.getRow(0);

          Cell desiredCell = row.getCell(1);

          row.removeCell(desiredCell);

          FileOutputStream fos = new FileOutputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

          workbook.write(fos);

          System.out.println(row.getLastCellNum());
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
