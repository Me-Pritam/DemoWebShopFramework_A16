package baseclasspackage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import pompackage.BooksPagePOM;
import pompackage.CartPagePOM;
import pompackage.NavBarPOM;
import pompackage.ProductPagePOM;
import utilitypackage.ActionsUtil;
import utilitypackage.BrowserUtils;
import utilitypackage.PropertyFileUtils;

public class ParallelMethodBaseClass
{
    public String url;
    public String browser;

    public PropertyFileUtils property ;
    public BrowserUtils browserUtils;
    public ActionsUtil actions;

    public NavBarPOM navBar;
    public BooksPagePOM books;
    public ProductPagePOM product;





    @BeforeMethod
    public void doConfig()
    {
        property = new PropertyFileUtils();
        url = property.getData("url");
        browser = property.getData("browser");

        browserUtils = new BrowserUtils();

        browserUtils.openBrowser(browser);
        browserUtils.maximizeBrowser();
        browserUtils.waitForPageLoad(15);
        browserUtils.openURL(url);
        browserUtils.waitForElementsLoad(5);

        actions = new ActionsUtil(browserUtils.getDriver());
        navBar = new NavBarPOM(browserUtils.getDriver());
        books = new BooksPagePOM(browserUtils.getDriver());
        product = new ProductPagePOM(browserUtils.getDriver());



    }

    @AfterMethod
    public void closeSession()
    {
        browserUtils.closeBrowser();
    }

}
