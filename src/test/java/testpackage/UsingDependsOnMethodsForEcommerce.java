package testpackage;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class UsingDependsOnMethodsForEcommerce
{
    @Test
    public void logIn()
    {
        Reporter.log("LogIn is successful",true);
    }

    @Test(dependsOnMethods = "logIn")
    public void searchProduct()
    {
        Reporter.log("Desired Product is searched",true);
    }

    @Test(dependsOnMethods = "searchProduct")
    public void goToProductPage()
    {
        Reporter.log("Desired Product details page is opened",true);
    }

    @Test(dependsOnMethods = "goToProductPage")

    public void addProductToCart()
    {
        Reporter.log("Product is added to cart",true);
    }

    @Test(dependsOnMethods = "addProductToCart")
    public void goToCartPage()
    {
        Reporter.log("Cart page is displayed",true);
    }

    @Test(dependsOnMethods = "goToCartPage")
    public void verifyProductVisibility()
    {
        Reporter.log("The Desired Product is present in the Cart",true);
    }

    @Test(dependsOnMethods = {"logIn","searchProduct","goToProductPage","addProductToCart","goToCartPage","verifyProductVisibility"})
    public void logOut()
    {
        Reporter.log("The LogOut is successful",true);
    }
}
