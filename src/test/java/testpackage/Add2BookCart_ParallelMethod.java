package testpackage;

import baseclasspackage.ParallelMethodBaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class Add2BookCart_ParallelMethod extends ParallelMethodBaseClass
{


    @Test
    public void addComputerBookToCart()
    {
        actions.clickOnElement(books.getComputingAndInternetBookLink());
        actions.clickOnElement(product.getAddToCartButton());
    }

    @Test
    public void addFictionBookToCart()
    {
        actions.clickOnElement(books.getFictionBookLink());
        actions.clickOnElement(product.getAddToCartButton());
    }


}
