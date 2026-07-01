package pompackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavBarPOM
{
    @FindBy(xpath = "//a[@href='/register']")
    private WebElement registerLink;
    @FindBy(xpath = "//a[@href='/login']")
    private WebElement logInLink;
    @FindBy(xpath = "//li[@id='topcartlink']/a[@href='/cart']")
    private WebElement shoppingCartLinkOnTop;
    @FindBy(xpath = "//div[@class='header-links']/descendant::a[@href='/wishlist']")
    private WebElement wishListLinkOnTop;
    @FindBy(xpath = "//div[@class='header-menu']/descendant::a[@href='/books']")
    private WebElement booksLink;

    @FindBy(xpath = "//ul[@class='top-menu']/descendant::a[normalize-space()='Computers']")
    private WebElement computersLink;



    public NavBarPOM(WebDriver driver)
    {

        PageFactory.initElements(driver,this);
    }

    public WebElement getBooksLink()
    {
        return booksLink;
    }

    public WebElement getComputersLink() {
        return computersLink;
    }

    public WebElement getRegisterLink() {
        return registerLink;
    }

    public WebElement getLogInLink() {
        return logInLink;
    }

    public WebElement getShoppingCartLinkOnTop() {
        return shoppingCartLinkOnTop;
    }

    public WebElement getWishListLinkOnTop() {
        return wishListLinkOnTop;
    }

}
