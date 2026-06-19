package dataproviderpackage;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.DataProvider;
import utilitypackage.ExecelFileUtility;

public class LogInCredentialsDataProvider
{
    ExecelFileUtility excel;

    @DataProvider(name = "userCredentials")
    public Object[][] getUserCredentials()
    {
        Object[][] credentials = null;

        try
        {
            excel = new ExecelFileUtility();

            Sheet mySheet = excel.getDesiredSheet("LogInSheet");

            int firstRow = excel.getFirstRowCount(mySheet);
            int lastRow = excel.getLastRowCount(mySheet);

            int firstCell = excel.getFirstCellCount(mySheet,0);
            int lastCell = excel.getLastCellCount(mySheet,0);

            credentials = new Object[lastRow][lastCell];

            for(int r=firstRow+1; r<=lastRow; r++)
            {
                for (int c=firstCell; c<lastCell; c++)
                {
                    credentials[r-1][c] = excel.getCellData(mySheet,r,c);
                }
            }

            return credentials;


        } catch (Exception e)
        {
            e.printStackTrace();
        }

        return credentials;

    }
}
