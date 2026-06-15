package utilitypackage;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtils
{
    FileInputStream fis;

    public PropertyFileUtils()
    {
       try
       {
         fis = new FileInputStream("./src/test/resources/CommonDataFolder/DemoWebShopConfig.properties");
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
    }

    public String getData(String key)
    {
        String value=null;

        try
        {
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
