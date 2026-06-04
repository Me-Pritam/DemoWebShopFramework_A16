package ddtpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class WritingProductPriceInPropertyFile
{
    public static String browser;
    public static String password;
    public static String productName;
    public static String url;
    public static String username;

    public static WebDriver driver;

    public static void main(String[] args)
    {
     try
     {
         FileInputStream fis = new FileInputStream("./src/test/resources/DemoWebShopConfig.properties");

         Properties properties = new Properties();

         properties.load(fis);

         browser = properties.getProperty("browser");
         url = properties.getProperty("url");
         username = properties.getProperty("username");
         password = properties.getProperty("password");
         productName = properties.getProperty("productName");

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

         driver.manage().window().maximize();
         driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
         driver.get(url);
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

         driver.findElement(By.linkText("Log in"))
                 .click();
         driver.findElement(By.xpath("//input[@id='Email']"))
                 .sendKeys(username);
         driver.findElement(By.xpath("//input[@id='Password']"))
                 .sendKeys(password);
         driver.findElement(By.xpath("//input[@value='Log in']"))
                 .click();
         driver.findElement(By.xpath("//a[@href='/books']"))
                 .click();

         List<WebElement> allBooksNames = driver.findElements(By.xpath("//h2[@class='product-title']"));

         for(WebElement bookName : allBooksNames)
         {
             if (bookName.getText().equals(productName))
             {
                 bookName.click();
                 break;
             }
         }

         String productPrice = driver.findElement(By.xpath("//div[@class='product-price']/child::span"))
                 .getText();

         properties.setProperty("productPrice",productPrice);

         FileOutputStream fos = new FileOutputStream("./src/test/resources/DemoWebShopConfig.properties");

         properties.store(fos,"ProductPrice added");


     }
     catch (Exception e)
     {
         e.printStackTrace();
     }
    }
}
