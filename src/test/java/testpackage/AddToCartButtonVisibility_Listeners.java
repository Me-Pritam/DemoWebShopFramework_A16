package testpackage;

import baseclasspackage.AddingItemToCartBaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AddToCartButtonVisibility_Listeners extends AddingItemToCartBaseClass
{
    public WebDriver driver ;
    WebDriverWait wait;

    @Test
    public void clickOnBooksLink()
    {
        driver = browserUtils.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(navBar.getBooksLink().isDisplayed(),"The Books Link in NavBar is not displayed");
        Reporter.log("The Book Link in NavBar is displayed",true);

        actions.clickOnElement(navBar.getBooksLink());
        Reporter.log("The Books Link in NavBar is Clicked",true);

        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "clickOnBooksLink")
    public void checkBookPageVisibility()
    {
        SoftAssert softAssert = new SoftAssert();

        softAssert.assertTrue(wait.until(ExpectedConditions.urlContains("/books")),"Not Redirected to Books Link");
        Reporter.log("Redirected to Books Link",true);

        softAssert.assertFalse(wait.until(ExpectedConditions.visibilityOfAllElements(books.getAllBooksCard())).isEmpty(),"The Books are not Present");
        Reporter.log("The Books are present",true);

        softAssert.assertAll();
    }

    @Test(dependsOnMethods = "checkBookPageVisibility")
    public void checkAddToCartButtonVisibility()
    {
        SoftAssert softAssert = new SoftAssert();

        for(WebElement itemCard : books.getAllBooksCard())
        {
           softAssert.assertNull(itemCard.findElement(By.xpath(".//-descendant::input[@value='Add to cart']")),"Add To Cart Button is not present");
           Reporter.log("Add to cart Button is present",true);
        }

        softAssert.assertAll();
    }
}
