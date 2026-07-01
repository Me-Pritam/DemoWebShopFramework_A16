package baseclasspackage;

import com.beust.jcommander.Parameter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import pompackage.*;
import utilitypackage.ActionsUtil;
import utilitypackage.BrowserUtils;
import utilitypackage.PropertyFileUtils;

public class CrossBrowserBaseClass
{
    public PropertyFileUtils property ;
    public BrowserUtils browserUtils;
    public ActionsUtil actions;

    public String browser;
    public String url;


    public NavBarPOM navBar;
    public ComputerPagePOM computer;
    public NoteBookPOM notebook;
    public ProductPagePOM product;


    @BeforeTest
    @Parameters({"browser"})
    public void loadConfig(String browser)
    {
        property = new PropertyFileUtils();
        this.browser = browser;
        url = property.getData("url");

        browserUtils = new BrowserUtils();
        browserUtils.openBrowser(browser);
        browserUtils.openURL(url);
        browserUtils.waitForElementsLoad(10);
        navBar = new NavBarPOM(browserUtils.getDriver());
        computer = new ComputerPagePOM(browserUtils.getDriver());
        notebook = new NoteBookPOM(browserUtils.getDriver());
        product = new ProductPagePOM(browserUtils.getDriver());

        actions = new ActionsUtil(browserUtils.getDriver());
    }


}


