package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavBarPOM
{
    By registerLink = By.xpath("//a[@href='/register']");
    By logInLink = By.xpath("//a[@href='/login']");
    By shoppingCartLinkOnTop = By.xpath("//li[@id='topcartlink']/a[@href='/cart']");
    By wishListLinkOnTop = By.xpath("//div[@class='header-links']/descendant::a[@href='/wishlist']");
    By booksLink = By.xpath("//div[@class='header-menu']/descendant::a[@href='/books']");

    WebDriver driver;

    public NavBarPOM(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebElement getBooksLink()
    {
        return driver.findElement(booksLink);
    }

    public WebElement getRegisterLink() {
        return driver.findElement(registerLink);
    }

    public WebElement getLogInLink() {
        return driver.findElement(logInLink);
    }

    public WebElement getShoppingCartLinkOnTop() {
        return driver.findElement(shoppingCartLinkOnTop);
    }

    public WebElement getWishListLinkOnTop() {
        return driver.findElement(wishListLinkOnTop);
    }

}
