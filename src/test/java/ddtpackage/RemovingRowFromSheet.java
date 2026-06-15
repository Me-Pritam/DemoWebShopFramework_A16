package ddtpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class RemovingRowFromSheet
{
    public static void main(String[] args)
    {
      try
      {
          FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

          Workbook workbook = WorkbookFactory.create(fis);

          Sheet sheet = workbook.getSheet("NewCreatedSheet");

          Row desiredRow = sheet.getRow(1);

          sheet.removeRow(desiredRow);

          FileOutputStream fos = new FileOutputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

          workbook.write(fos);

          workbook.close();

          System.out.println("Current Row number --->"+sheet.getLastRowNum());


      }
      catch (Exception e)
      {
        e.printStackTrace();
      }
    }
}
