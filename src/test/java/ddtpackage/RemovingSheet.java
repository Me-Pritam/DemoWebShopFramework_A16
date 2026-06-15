package ddtpackage;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class RemovingSheet
{
    public static void main(String[] args)
    {
      try
      {
          FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

          Workbook workbook = WorkbookFactory.create(fis);

          Sheet desiredSheet = workbook.getSheet("NewCreatedSheet");

          int sheetNum = workbook.getSheetIndex(desiredSheet);

//          workbook.getSheetIndex("NewCreatedSheet");

          workbook.removeSheetAt(sheetNum);

          FileOutputStream fos =  new FileOutputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

          workbook.write(fos);
      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
