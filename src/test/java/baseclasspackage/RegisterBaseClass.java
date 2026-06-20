package baseclasspackage;

import org.apache.poi.ss.usermodel.Sheet;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pompackage.NavBarPOM;
import pompackage.RegisterPagePOM;
import utilitypackage.ActionsUtil;
import utilitypackage.BrowserUtils;
import utilitypackage.ExecelFileUtility;
import utilitypackage.PropertyFileUtils;

public class RegisterBaseClass
{
    PropertyFileUtils property ;
    BrowserUtils browserUtils;
    public ActionsUtil actions;
    ExecelFileUtility excel;

    public String browser;
    public String url;

    public String gender;
    public String firstName;
    public String lastName;
    public String email;
    public String password;
    public String confirmPassword;

    public NavBarPOM navBar;
    public RegisterPagePOM register;

    @BeforeSuite
    public void loadConfig()
    {
        try
        {
            property = new PropertyFileUtils();
            excel = new ExecelFileUtility();

            browser = property.getData("browser");
            url = property.getData("url");

           Sheet desiredSheet = excel.getDesiredSheet("RegisterSheet");

           gender = excel.getCellData(desiredSheet,1,0);
           firstName = excel.getCellData(desiredSheet,1,1);
           lastName = excel.getCellData(desiredSheet,1,2);
           email = excel.getCellData(desiredSheet,1,3);
           password = excel.getCellData(desiredSheet,1,4);
           confirmPassword = excel.getCellData(desiredSheet,1,5);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @BeforeTest
    public void doConfig()
    {
        browserUtils = new BrowserUtils();

        browserUtils.openBrowser(browser);
        browserUtils.maximizeBrowser();
        browserUtils.waitForPageLoad(5);
        browserUtils.openURL(url);
        browserUtils.waitForElementsLoad(5);

        actions = new ActionsUtil(browserUtils.getDriver());

        navBar = new NavBarPOM(browserUtils.getDriver());
        register = new RegisterPagePOM(browserUtils.getDriver());

    }


}
