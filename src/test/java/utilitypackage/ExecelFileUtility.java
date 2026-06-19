package utilitypackage;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;

public class ExecelFileUtility
{
    Workbook workbook;

    public ExecelFileUtility() throws Exception
    {
        FileInputStream fis = new FileInputStream("./src/test/resources/TestDataFolder/DemoWebShopExcelSheet.xlsx");

        workbook = WorkbookFactory.create(fis);

    }

    public Sheet getDesiredSheet(String sheetName)
    {
        return workbook.getSheet(sheetName);
    }

    public String getCellData(Sheet sheet,int rowNum,int cellNum)
    {
      return sheet.getRow(rowNum).getCell(cellNum).toString();
    }

    public int getLastRowCount(Sheet sheet)
    {
        return sheet.getLastRowNum();
    }

    public int getFirstRowCount(Sheet sheet)
    {
        return sheet.getFirstRowNum();
    }

    public int getLastCellCount(Sheet sheet,int row)
    {
        return sheet.getRow(row).getLastCellNum();
    }

    public int getFirstCellCount(Sheet sheet,int row)
    {
        return sheet.getRow(row).getFirstCellNum();
    }

}
