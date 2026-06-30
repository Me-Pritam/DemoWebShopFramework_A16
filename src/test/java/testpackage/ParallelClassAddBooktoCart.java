package testpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class ParallelClassAddBooktoCart
{
    WebDriver driver;

    @Test
    public void doConfig()
    {
        driver = new ChromeDriver();
//        driver.manage().window().maximize();
        driver.manage().window().setPosition(new Point(600,200));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    @Test(dependsOnMethods = "doConfig")
    public void goToBookPage()
    {
        driver.findElement(By.xpath("//ul[@class='top-menu']/descendant::a[normalize-space()='Books']"))
                .click();

        driver.findElement(By.xpath("//div[@class='item-box']/descendant::a[text()='Computing and Internet']"))
                .click();
    }

    @Test(dependsOnMethods = "goToBookPage")
    public void addBookToCart()
    {
        driver.findElement(By.xpath("//div[@class='add-to-cart-panel']/child::input[@value='Add to cart']"))
                .click();
    }

    @Test(dependsOnMethods = "addBookToCart",enabled = false)
    public void closeBrowser()
    {
        driver.quit();
    }
}
