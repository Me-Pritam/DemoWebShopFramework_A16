package utilitypackage;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtils
{



    public String getData(String key)
    {
        String value=null;

        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/CommonDataFolder/DemoWebShopConfig.properties");

            Properties proeprty = new Properties();

            proeprty.load(fis);

            value = proeprty.getProperty(key);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return value;
    }
}
