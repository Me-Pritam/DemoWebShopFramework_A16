package ddtpackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class WriteDataInPropertyFile
{
    public static void main(String[] args)
    {
      try
      {
          FileInputStream fis = new FileInputStream("./src/test/resources/DemoWebShopConfig.properties");

          Properties properties = new Properties();

          properties.load(fis);

          properties.setProperty("productName","High Definition 3D Camcorder");

          FileOutputStream fos = new FileOutputStream("./src/test/resources/DemoWebShopConfig.properties");

          properties.store(fos,"ProductName is added by SDET Pritam");

      }
      catch (Exception e)
      {
          e.printStackTrace();
      }
    }
}
