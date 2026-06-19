package dataproviderpackage;

import org.testng.annotations.DataProvider;

public class DummyDataProviderClass
{
    @DataProvider(name = "dummyData")
    public Object[][] getData()
    {
        Object [][]arr = new Object[3][2];

        arr[0][0]="Java";
        arr[0][1]="Selenium";
        arr[1][0]="Javascript";
        arr[1][1]="Playwright";
        arr[2][0]="TypeScript";
        arr[2][1]="Cypress";

        return arr;
    }
}
