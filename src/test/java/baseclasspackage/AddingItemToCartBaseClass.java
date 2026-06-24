package baseclasspackage;

import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import pompackage.BooksPagePOM;
import pompackage.CartPagePOM;
import pompackage.NavBarPOM;
import pompackage.ProductPagePOM;
import utilitypackage.ActionsUtil;
import utilitypackage.BrowserUtils;
import utilitypackage.PropertyFileUtils;

public class AddingItemToCartBaseClass
{
    public PropertyFileUtils property ;
    public BrowserUtils browserUtils;
    public ActionsUtil actions;

    public String browser;
    public String url;
    public String email;
    public String password;


    public NavBarPOM navBar;
    public BooksPagePOM books;
    public ProductPagePOM product;
    public CartPagePOM cart;


    @BeforeSuite
    public void loadConfig()
    {
     property = new PropertyFileUtils();
     Reporter.log("PropertyFileUtils is Instantiated",true);

     browser = property.getData("browser");
        Reporter.log("Browser Name is loaded from the Configuration File",true);

     url = property.getData("url");
        Reporter.log("URL Address is loaded from the Configuration File",true);

     email = property.getData("email");
        Reporter.log("User Email Address is loaded from the Configuration File",true);

     password = property.getData("password");
        Reporter.log("User Password is loaded from the Configuration File",true);

    }

    @BeforeTest
    public void performConfig()
    {
      browserUtils = new BrowserUtils();
        Reporter.log("BrowserUtils is Instantiated",true);

      browserUtils.openBrowser(browser);
        Reporter.log("Desired Browser is launched",true);

      browserUtils.openURL(url);
        Reporter.log("Desired URL is loaded",true);

        browserUtils.waitForPageLoad(5);
        Reporter.log("Wait Time is provided for the Page Load",true);

      browserUtils.waitForElementsLoad(5);
        Reporter.log("Wait Time is provided for the WebElements",true);

      navBar = new NavBarPOM(browserUtils.getDriver());
        Reporter.log("NavBarPagePOM is Instantiated",true);

      books = new BooksPagePOM(browserUtils.getDriver());
        Reporter.log("BooksPagePOM is Instantiated",true);

      product = new ProductPagePOM(browserUtils.getDriver());
        Reporter.log("ProductPagePagePOM is Instantiated",true);

      cart = new CartPagePOM(browserUtils.getDriver());
        Reporter.log("CartPagePOM is Instantiated",true);

      actions = new ActionsUtil(browserUtils.getDriver());
        Reporter.log("ActionsUtil is Instantiated",true);
    }

}
