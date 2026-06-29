package utilitypackage;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.JavascriptExecutor;
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
    private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public void openBrowser(String browser)
    {
        switch (browser.toLowerCase())
        {
            case "chrome":
                tlDriver.set(new ChromeDriver());
                break;
            case "firefox":
                tlDriver.set(new FirefoxDriver());
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver","./AllBrowserDrivers/msedgedriver.exe");
                tlDriver.set(new EdgeDriver());
                break;
            default:throw new InvalidArgumentException("Incorrect Browser Name");

        }
    }

    public WebDriver getDriver()
    {
        return tlDriver.get();
    }

    public void maximizeBrowser()
    {
        getDriver().manage().window().maximize();

        ((JavascriptExecutor)getDriver()).executeScript("document.body.style.zoom='60%'");
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

    public void refreshBrowser()
    {
        getDriver().navigate().refresh();
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
