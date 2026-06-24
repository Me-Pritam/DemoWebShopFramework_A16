package testpackage;

import baseclasspackage.AddingItemToCartBaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AddingItemToCartHardAssertion extends AddingItemToCartBaseClass
{
    WebDriverWait wait;

    @Test
    public void clickOnBooksLink()
    {
        wait = new WebDriverWait(browserUtils.getDriver(), Duration.ofSeconds(5));

        Assert.assertEquals(navBar.getBooksLink().isDisplayed(),true,"BooksLink is not displayed");
        Reporter.log("The Books link is displayed",true);

        actions.clickOnElement(navBar.getBooksLink());
        Reporter.log("Clicked on the BooksLink",true);


    }

    @Test(dependsOnMethods = "clickOnBooksLink")
    public void checkBookVisibility()
    {

        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("/books")),"Not redirected to Books resource");
        Reporter.log("Redirected To Books Resource",true);

        Assert.assertTrue(books.getComputingAndInternetBookLink().isDisplayed(),"The Desired Book is not displayed");
        Reporter.log("The Desired Book is displayed",true);
    }

    @Test(dependsOnMethods = "checkBookVisibility")
    public void clickOnTheBook()
    {

        actions.clickOnElement(books.getComputingAndInternetBookLink());
        Reporter.log("The Computing And Internet Book is clicked",true);
    }

    @Test(dependsOnMethods = "clickOnTheBook")
    public void addBookToCart()
    {
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("/computing-and-internet")),"Not Redirected to Desired Book Page");
        Reporter.log("Redirected To desired Book Page",true);

        Assert.assertEquals(product.getAddToCartButton().isDisplayed(),true,"Add to cart button is not displayed");
        Reporter.log("Add to cart button is displayed",true);

        actions.clickOnElement(product.getAddToCartButton());
        Reporter.log("Clicked on the Add to Cart Button",true);
    }

    @Test(dependsOnMethods = "addBookToCart")
    public void goToCart()
    {
        Assert.assertTrue(navBar.getShoppingCartLinkOnTop().isDisplayed(),"The Shopping cart Link on navBar is not displayed");
        Reporter.log("The Shopping Cart Link on Navbar is Displayed",true);

        actions.clickOnElement(navBar.getShoppingCartLinkOnTop());
        Reporter.log("Clicked on Shopping cart NavBar",true);
    }

    @Test(dependsOnMethods = "goToCart")
    public void checkProductVisibility()
    {
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("/cart")),"Not redirected to Cart Page");
        Reporter.log("Redirected to Cart Page",true);

        Assert.assertTrue(cart.getProductTable().isDisplayed(),"The Desired Product is not present in the Cart Page");
        Reporter.log("The Desired Product is present in the Cart Page",true);
    }

}
