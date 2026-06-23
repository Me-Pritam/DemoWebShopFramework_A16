package baseclasspackage;

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
     browser = property.getData("browser");
     url = property.getData("url");
     email = property.getData("email");
     password = property.getData("password");

    }

    @BeforeTest
    public void performConfig()
    {
      browserUtils = new BrowserUtils();
      browserUtils.openBrowser(browser);
      browserUtils.openURL(url);
      browserUtils.waitForElementsLoad(5);

      navBar = new NavBarPOM(browserUtils.getDriver());
      books = new BooksPagePOM(browserUtils.getDriver());
      product = new ProductPagePOM(browserUtils.getDriver());
      cart = new CartPagePOM(browserUtils.getDriver());

      actions = new ActionsUtil(browserUtils.getDriver());
    }

}
