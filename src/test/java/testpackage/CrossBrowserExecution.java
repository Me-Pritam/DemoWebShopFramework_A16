package testpackage;

import baseclasspackage.CrossBrowserBaseClass;
import org.testng.annotations.Test;

public class CrossBrowserExecution extends CrossBrowserBaseClass
{
    @Test
    public void clickOnComputerLink()
    {
        actions.clickOnElement(navBar.getComputersLink());
    }

    @Test(dependsOnMethods = "clickOnComputerLink")
    public void selectDesiredComputerOption()
    {
        computer.selectDesiredComputerOption("Notebooks");

        actions.clickOnElement(notebook.getLaptopLink());
    }

    @Test(dependsOnMethods = "selectDesiredComputerOption")
    public void addLaptopToCart()
    {
        actions.clickOnElement(product.getAddToCartButton());
    }
}
