package testpackage;

import baseclasspackage.ParallelMethodBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pompackage.BooksPagePOM;
import pompackage.NavBarPOM;
import pompackage.ProductPagePOM;
import utilitypackage.ActionsUtil;
import utilitypackage.BrowserUtils;
import utilitypackage.PropertyFileUtils;

public class Add2BookCart_ParallelMethod extends ParallelMethodBaseClass
{


    @Test
    public void addComputerBookToCart()
    {

        actions.clickOnElement(navBar.getBooksLink());



        books.selectDesiredBook("Computing and Internet");

        actions.clickOnElement(product.getAddToCartButton());
    }

    @Test
    public void addFictionBookToCart()
    {

        actions.clickOnElement(navBar.getBooksLink());



        books.selectDesiredBook("Computing and Internet");

        actions.clickOnElement(product.getAddToCartButton());
    }


}
