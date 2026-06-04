package ddtpackage;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class PerformLogInUsingProperties
{
    public static String browser;
    public static String url;
    public static String username;
    public static String password;

    public static WebDriver driver;


    public static void main(String[] args)
    {
        try
        {
            FileInputStream fis = new FileInputStream("./src/test/resources/DemoWebShopConfig.properties");

            Properties property = new Properties();

            property.load(fis);

            browser = property.getProperty("browser");
            url = property.getProperty("url");
            username = property.getProperty("username");
            password = property.getProperty("password");

            switch (browser.toLowerCase())
            {
                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    System.setProperty("webdriver.edge.driver","./AllBrowserDrivers/msedgedriver.exe");
                    driver = new EdgeDriver();
                    break;
                default: throw new InvalidArgumentException("Invalid Browser name");
            }


        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
