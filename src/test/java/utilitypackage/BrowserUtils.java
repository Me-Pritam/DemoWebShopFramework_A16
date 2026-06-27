package utilitypackage;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;

public class BrowserUtils
{
    private static WebDriver driver;

    public void openBrowser(String browser)
    {
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
            default:throw new InvalidArgumentException("Incorrect Browser Name");

        }
    }

    public WebDriver getDriver()
    {
        return driver;
    }

    public void maximizeBrowser()
    {
        getDriver().manage().window().maximize();
    }

    public void openURL(String url)
    {
        getDriver().get(url);
    }

    public void waitForPageLoad(int num)
    {
        getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(num));
    }

    public void waitForElementsLoad(int num)
    {
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(num));
    }

    public String getRunningURL()
    {
        return getDriver().getCurrentUrl();
    }

    public void closeBrowser()
    {
        getDriver().quit();
    }


}
