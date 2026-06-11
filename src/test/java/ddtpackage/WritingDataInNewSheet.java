package ddtpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WritingDataInNewSheet
{
    public static void main(String[] args)
    {
      try
      {
          FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

          Workbook workbook = WorkbookFactory.create(fis);

          Sheet newSheet = workbook.createSheet("NewCreatedSheet");

          Row newSheetRow = newSheet.createRow(0);

          newSheetRow.createCell(0).setCellValue("Email");
          newSheetRow.createCell(1).setCellValue("UserName");

          FileOutputStream fos = new FileOutputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

          workbook.write(fos);
      }
      catch (Exception e)
      {
          e.printStackTrace();

      }
    }
}
