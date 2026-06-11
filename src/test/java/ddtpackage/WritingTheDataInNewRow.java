package ddtpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class WritingTheDataInNewRow
{
    public static void main(String[] args)
    {
        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

            Workbook workbook = WorkbookFactory.create(fis);

            Sheet sheet = workbook.getSheet("LogInSheet");

            Row newRow = sheet.createRow(11);

            newRow.createCell(0).setCellValue("themail11@gmail.com");
            newRow.createCell(1).setCellValue("Password@4321");

            FileOutputStream fos = new FileOutputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

            workbook.write(fos);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
