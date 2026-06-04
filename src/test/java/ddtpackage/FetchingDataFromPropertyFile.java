package ddtpackage;

import java.io.FileInputStream;
import java.util.Properties;

public class FetchingDataFromPropertyFile
{
    public static void main(String[] args)
    {
        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/DemoWebShopConfig.properties");

            Properties property = new Properties();

            property.load(fis);

            System.out.println(property.getProperty("browser"));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
