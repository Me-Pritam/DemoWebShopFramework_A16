package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParallelClassAddLaptopToCart
{
    WebDriver driver;

    @Test
    public void doConfig()
    {
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().window().setSize(new Dimension(500,500));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(dependsOnMethods = "doConfig")
    public void goToComputerPage()
    {
        driver.findElement(By.xpath("//ul[@class='top-menu']/descendant::a[normalize-space()='Computers']"))
                .click();

        driver.findElement(By.xpath("//div[@class='item-box']/descendant::a[normalize-space()='Notebooks']"))
                .click();

        driver.findElement(By.xpath("//div[@class='item-box']/descendant::a[text()='14.1-inch Laptop']"))
                .click();
    }

    @Test(dependsOnMethods = "goToComputerPage")
    public void addLaptopToCart()
    {
        driver.findElement(By.xpath("//div[@class='add-to-cart-panel']/child::input[@value='Add to cart']"))
                .click();
    }

    @Test(dependsOnMethods = "addLaptopToCart",enabled = false)
    public void closeBrowser()
    {
        driver.quit();
    }
}
