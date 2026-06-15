package testpackage;

import org.openqa.selenium.WebDriver;
import pompackage.LogInPagePOM;
import pompackage.NavBarPOM;
import utilitypackage.ActionsUtil;
import utilitypackage.BrowserUtils;
import utilitypackage.PropertyFileUtils;

public class LogInUsing_Pom_Utils
{
    static ActionsUtil actions;
    static BrowserUtils browserUtils;
    static PropertyFileUtils property;

    static NavBarPOM navBar;
    static LogInPagePOM login;

    static WebDriver driver;

    static String browser;
    static String password;
    static String url;
    static String username;

    public static void main(String[] args)
    {
        property = new PropertyFileUtils();
        browser = property.getData("browser");
        url = property.getData("url");
        username = property.getData("username");
        password = property.getData("password");

        browserUtils = new BrowserUtils();

        browserUtils.openBrowser(browser);
        browserUtils.maximizeBrowser();
//        browserUtils.waitForPageLoad(5);
        browserUtils.openURL(url);
    }
}
