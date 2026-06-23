package testpackage;

import baseclasspackage.AddingItemToCartBaseClass;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class AddingItemToCartHardAssertion extends AddingItemToCartBaseClass
{
    @Test
    public void clickOnBooksLink()
    {
        actions.clickOnElement(navBar.getBooksLink());
    }

    @Test(dependsOnMethods = "clickOnBooksLink")
    public void checkBookVisibility()
    {
        Assert.assertTrue(books.getComputingAndInternetBookLink().isDisplayed(),"The Desired Book is not displayed");
        Reporter.log("The Desired Book is displayed",true);
    }

}
